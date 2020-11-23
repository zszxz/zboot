package com.zboot.common.result;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor//全参构造
@NoArgsConstructor//空参构造
public enum CodeMsg {

    SUCESS(200,"sucess"),
    SERVER_ERROR(500,"服务端异常"),
    Request_ERROR(400,"请求异常"),
    FILE_ERROR(400,"请求异常，文件上传失败"),
    ACCOUNT_ERROR(401,"账号或者密码错误"),
    ACCOUNT_USERED(401,"用户名已经被使用"),
    ACCOUNT_NOT_EXIST(401,"用户不存在"),
    AUTH_ERROR(401,"认证失败，请先登陆"),
    VERIFY_ERROR(402,"密码校验失败，请输入正确的旧密码"),
    Host_ERROR(407,"未知主机异常"),
    parent_ERROR(408,"存在子级节点，不可删除"),
    PERMISSION_ERROR(403,"您没有足够的权限，请联系管理员升级权限");


    // 错误消息码
    private Integer code;
    // 错误消息提示
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
