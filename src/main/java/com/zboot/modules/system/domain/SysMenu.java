package com.zboot.modules.system.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @Author lsc
 * <p> </p>
 */
@Data
@TableName("sys_menu")
@ApiModel(value="菜单", description="菜单")
public class SysMenu {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "路径")
    private String path;

    @ApiModelProperty(value = "权限")
    private String permission;

    @ApiModelProperty(value = "图标")
    private String iconCls;

    @ApiModelProperty(value = "组件")
    private String component;

    @ApiModelProperty(value = "父节点")
    private Long parentId;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "菜单类型")
    private String type;

    @ApiModelProperty(value = "字节点")
    @TableField(exist = false)
    private Set<SysMenu> children;
    // 创建时间
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    // 更新时间
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建人")
    @TableField(fill = FieldFill.INSERT)
    private String createBy;
    // 更新时间
    @ApiModelProperty(value = "更新人")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

}
