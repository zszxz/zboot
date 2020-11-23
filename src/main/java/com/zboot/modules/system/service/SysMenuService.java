package com.zboot.modules.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zboot.modules.system.domain.SysMenu;
import com.zboot.modules.system.domain.vo.SysMenuVo;

import java.util.List;
import java.util.Set;

public interface SysMenuService  {

    /* *
     * @Author lsc
     * <p> 根据用户id获取所有菜单 </p>
     */
    Set<SysMenu> getUserMenu(Long userId, List<String> typeList, Boolean buildTree);

    /* *
     * @Author lsc
     * <p>根据菜单编号查询菜单 </p>
     */
    SysMenu getMenuById(Long id);

    /* *
     * @Author lsc
     * <p>获取角色拥有菜单 </p>
     */
    Set<SysMenu>  getRoleMenu(Long roleId);

    /* *
     * @Author lsc
     * <p>树形菜单 </p>
     */
    Set<SysMenu> getMenuTree();


    /**
     * author lsc
     * 新增
     **/
    Integer addSysMenu (SysMenu sysMenu);

    /* *
     * @Author lsc
     * <p>更新修改角色菜单 </p>
     */
    Integer updateRoleMenu(Long roleId, List<Long> menuIds);


    /**
     * author lsc
     * 修改
     **/
    Integer updateSysMenu (SysMenu sysMenu);


    /**
     * author lsc
     * 删除
     **/
    Integer deleteSysMenu (Long id);

}
