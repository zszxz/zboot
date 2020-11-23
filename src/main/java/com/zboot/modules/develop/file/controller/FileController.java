package com.zboot.modules.develop.file.controller;

import com.zboot.common.exception.ZBootException;
import com.zboot.common.result.CodeMsg;
import com.zboot.common.result.ResultPage;
import com.zboot.modules.develop.file.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
@RequestMapping("file")
@Api(value = "文件上传下载",tags = "文件上传下载")
public class FileController {

    @Autowired
    FileService fileService;

    /* *
     * @Author lsc
     * <p> 文件上传</p>
     * @Param file 文件
     * @Return 下载路径
     */
    @ApiOperation(value = "上传文件")
    @PostMapping("upload")
    public ResultPage fileUpload(@RequestParam("file") MultipartFile file){
        if (file==null){
            throw new ZBootException(CodeMsg.FILE_ERROR);
        }
        String path = fileService.uploadFileMinio(file);
        return ResultPage.sucess(CodeMsg.SUCESS,path);
    }

    /* *
     * @Author lsc
     * <p> 文件下载 </p>
     * @Param [request, filename, inline, response]
     * @Return
     */
    @ApiOperation(value = "上传下载")
    @GetMapping("download/**")
    public void downloadFile(HttpServletRequest request,
                             @RequestParam(required = false) String filename,
                             @RequestParam(required = false,defaultValue = "false") boolean inline,
                             HttpServletResponse response) {
        String path =request.getServletPath().replace("file/download","");
        fileService.downloadFileMinio(path,filename,inline,response);
    }


}
