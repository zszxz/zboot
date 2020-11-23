package com.zboot.common.result;


import lombok.*;

/**
 * @Author lsc
 * <p> </p>
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResultPage<T> {

    // 状态码
    private Integer code;
    // 消息提示
    private String msg;
    // 存放的数据
    private T data;


    ResultPage(Integer code,String msg) {
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    // 成功的时候调用
    public static <T> ResultPage<T> sucess(CodeMsg codeMsg, T data){
        return new ResultPage<T>(codeMsg.getCode(),codeMsg.getMsg(),data);
    }

    // 成功的时候调用
    public static <T> ResultPage<T> sucess(CodeMsg codeMsg){
        return new ResultPage<T>(codeMsg.getCode(),codeMsg.getMsg());
    }
    //失败的时候调用
    public static <T> ResultPage<T> error(CodeMsg codeMsg){
        return new ResultPage<T>(codeMsg.getCode(),codeMsg.getMsg());
    }
    public static <T> ResultPage<T> error(CodeMsg codeMsg, T data){
        return new ResultPage<T>(codeMsg.getCode(),codeMsg.getMsg(),data);
    }
}
