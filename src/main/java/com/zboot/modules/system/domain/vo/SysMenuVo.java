package com.zboot.modules.system.domain.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author lsc
 * <p> </p>
 */
@Data
public class SysMenuVo {

    /** 菜单类型：1 目录，2菜单，3 按钮 **/
    private List<String> typeList;
    /** 是否构建为树 **/
    private Boolean buildTree;
}
