package com.zboot.common.exception;

import com.zboot.common.result.CodeMsg;
import com.zboot.common.result.ResultPage;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.UnknownHostException;

/**
 * @Author lsc
 * <p> </p>
 */
@ControllerAdvice
@Configuration
@Slf4j
public class ZBootExceptionHandler {

    // 捕获CommonException异常
    @ExceptionHandler(value = ZBootException.class)
    @ResponseBody
    public ResponseEntity<ResultPage> CommonExceptionHandler(ZBootException e){
        // 获得异常消息
        CodeMsg codeMsg = e.getCodeMsg();
        // 设置错误消息页面返回
        return ResponseEntity.status(HttpStatus.OK).body(ResultPage.error(codeMsg));
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    public ResponseEntity<ResultPage> unauthorizedExceptionHandler(UnauthorizedException e){
        // 获得异常消息
        String message = e.getMessage();
        log.error("权限不足：[{}]",message);
        // 设置错误消息页面返回
        return ResponseEntity.status(HttpStatus.OK).body(ResultPage.error(CodeMsg.PERMISSION_ERROR));
    }

    @ExceptionHandler(value = IllegalStateException.class)
    @ResponseBody
    public ResponseEntity<ResultPage> illegalStateExceptionHandler(IllegalStateException e){
        // 获得异常消息
        String message = e.getMessage();
        log.error("非常状态异常：[{}]",message);
        // 设置错误消息页面返回
        return ResponseEntity.status(HttpStatus.OK).body(ResultPage.error(CodeMsg.Request_ERROR));
    }


}
