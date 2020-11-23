package com.zboot.modules.system.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author lsc
 * <p> </p>
 */
@Data
@ApiModel(value="部门用户关联", description="部门用户关联")
public class SysDepUser {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "角色编号")
    private Long depId;

    @ApiModelProperty(value = "菜单编号")
    private Long useId;
}
