package com.zboot.common.exception;

import com.zboot.common.result.CodeMsg;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lsc
 * <p> </p>
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ZBootException extends RuntimeException{

    // 序列化号
    private static final long serialVersionUID = 132719492019L;

    // 引入自定义异常消息
    private CodeMsg codeMsg;
}
