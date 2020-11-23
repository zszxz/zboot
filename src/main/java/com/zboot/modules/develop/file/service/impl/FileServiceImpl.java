package com.zboot.modules.develop.file.service.impl;

import com.zboot.modules.develop.file.service.FileService;
import io.minio.MinioClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @Author lsc
 * <p> </p>
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {


    @Value("${zszxz.minio.endpoint}")
    private String endpoint;
    @Value("${zszxz.minio.accessKey}")
    private String accessKey;
    @Value("${zszxz.minio.secretKey}")
    private String secretKey;
    @Value("${zszxz.minio.bucketName}")
    private String bucketName;
    @Value("${zszxz.minio.baseURL}")
    private String baseURL;


    @Override
    public String uploadFileMinio(MultipartFile multipartFile) {
        String downPath = null;
        MinioClient minioClient = null;
        try {
            minioClient = new MinioClient(endpoint, accessKey, secretKey);
            // 检查存储桶是否已经存在
            boolean isExist = minioClient.bucketExists(bucketName);
            if(!isExist) {
                // 创建一个存储桶
                minioClient.makeBucket(bucketName);
            }
            InputStream inputStream = multipartFile.getInputStream();
            // 获取文件名
            String originalFilename = multipartFile.getOriginalFilename();
            // 获取后缀
            String suffix = StringUtils.substringAfterLast(originalFilename, ".");
            String filePath = new StringBuilder("files/")
                    .append(System.currentTimeMillis())
                    .append(".")
                    .append(suffix)
                    .toString();
            // 使用putObject上传一个文件到存储桶中。
            minioClient.putObject(bucketName,filePath, inputStream,"application/octet-stream");
            downPath = baseURL + filePath;
        } catch (Exception e) {
            log.error("文件上传失败！！！[{}]",e.getMessage());
            e.printStackTrace();
            return "文件上传失败";
        }
        return downPath;
    }

    @Override
    public void downloadFileMinio(String path, String filename, Boolean inline, HttpServletResponse response) {
        MinioClient minioClient = null;
        try {
            minioClient = new MinioClient(endpoint, accessKey, secretKey);
            if (inline==true){
                InputStream inputStream = minioClient.getObject(bucketName, path);
                // 文件后缀
                String suffix = StringUtils.substringAfterLast(path, ".");
                if (StringUtils.isNotBlank(filename)){
                    String encodeFileName = URLEncoder.encode(filename+"."+suffix, "UTF-8");
                    response.addHeader("Content-Disposition","inline;filename*=UTF-8''"+encodeFileName);
                }
                // 文件在线预览
                response.reset();
                ServletOutputStream sout = response.getOutputStream();
                BufferedInputStream bis = new BufferedInputStream(inputStream);
                BufferedOutputStream bos = new BufferedOutputStream(sout);
                byte[] buff = new byte[2048];
                int bytesRead;
                while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, bytesRead);
                }
                sout.flush();
                bos.close();
                bis.close();
            }else {
                // 直接在线，有效期为一天
                String url = minioClient.presignedGetObject(bucketName, path, 60 * 60 * 24);
                response.sendRedirect(url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
