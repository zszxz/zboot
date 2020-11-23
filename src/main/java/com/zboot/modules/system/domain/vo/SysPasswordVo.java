package com.zboot.modules.system.domain.vo;

import lombok.Data;

/**
 * @Author lsc
 * <p> </p>
 */
@Data
public class SysPasswordVo {

    /** 旧密码 **/
    private String oldPassword;

    /** 新密码 **/
    private String newPassword;
}
