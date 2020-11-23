package com.zboot.modules.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lsc
 * <p> </p>
 */
@Data
@ApiModel(value="菜单角色关联", description="菜单角色关联")
public class SysRoleMenu {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "角色编号")
    private Long rid;

    @ApiModelProperty(value = "菜单编号")
    private Long mid;

}