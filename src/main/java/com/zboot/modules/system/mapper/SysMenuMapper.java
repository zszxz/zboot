package com.zboot.modules.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zboot.modules.system.domain.SysMenu;
import com.zboot.modules.system.domain.SysRole;
import com.zboot.modules.system.domain.SysRoleMenu;
import com.zboot.modules.system.domain.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

@Repository
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {


    /* *
     * @Author lsc
     * <p> 通过角色获取所有菜单</p>
     * @Param [role_id]
     */
    LinkedList<SysMenu> getRoleMenus(@Param("roleIdList") List<Long> roleIdList, @Param("typeList") List<String> typeList);

    /* *
     * @Author lsc
     * <p> 添加角色菜单关联</p>
     * @Param [userRoles]
     */
    Integer addRoleMenu(@Param("roleMenus") List<SysRoleMenu> roleMenus);

    /* *
     * @Author lsc
     * <p> 删除角色菜单关联</p>
     * @Param [user_id]
     */
    Integer deleteRoleMenu(Long roleId);

}
