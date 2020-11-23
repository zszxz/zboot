package com.zboot.modules.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lsc
 * <p> </p>
 */
@Data
@ApiModel(value="用户角色", description="用户角色")
public class SysUserRole {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "用户编号")
    private Long uid;

    @ApiModelProperty(value = "角色编号")
    private Long rid;

}