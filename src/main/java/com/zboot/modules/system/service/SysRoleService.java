package com.zboot.modules.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zboot.modules.system.domain.SysRole;
import com.zboot.modules.system.domain.vo.SysRoleVo;

import java.util.List;

/**
*
* @author lsc
* <p>
*    服务层
* </p>
*/
public interface SysRoleService {


    /**
    * author lsc
    * 分页查询 列表
    **/
    IPage<SysRole> getSysRole(SysRoleVo sysRoleVo, Integer pageNum, Integer pageSize);

    /* *
     * @Author lsc
     * <p>查询列表 </p>
     * @Return
     */
    List<SysRole> getSysRoleList(SysRoleVo sysRoleVo);

    /* *
     * @Author lsc
     * <p> 修改用户拥有的角色</p>
     * @Param [userRoles]
     */
    Integer updateUserRole(Long userId, List<Long> roleIds);

    /* *
     * @Author lsc
     * <p>通过用户id获取所有角色 </p>
     * @Param [user_id]
     */
    List<SysRole> getUserRoles(Long userId);

    /**
    * author lsc
    * 新增
    **/
    Integer addSysRole(SysRole sysRole);


    /**
    * author lsc
    * 修改
    **/
    Integer updateSysRole(SysRole sysRole);


    /**
    * author lsc
    * 删除
    **/
    Integer deleteSysRole(SysRole sysRole);


    SysRole getSysRoleById(Long roleId);


}