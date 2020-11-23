package com.zboot.modules.develop.file.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author lsc
 * <p> </p>
 */
public interface FileService {

    /* *
     * @Author lsc
     * <p> 文件上传 </p>
     * @Param [file]
     * @Return java.lang.String
     */
    String uploadFileMinio(MultipartFile file);
    /* *
     * @Author lsc
     * <p>文件下载 </p>
     * @Param [path, filename, inline]
     */
    void downloadFileMinio(String path, String filename,Boolean inline, HttpServletResponse response);
}
