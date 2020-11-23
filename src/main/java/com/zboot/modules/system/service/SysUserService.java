package com.zboot.modules.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zboot.modules.system.domain.SysUser;
import com.zboot.modules.system.domain.vo.SysUserVo;

/**
*
* @author lsc
* <p>
*    服务层
* </p>
*/
public interface SysUserService {


    /**
    * author lsc
    * 查询用户列表
    **/
    IPage<SysUser> getSysUser (SysUserVo sysUserVo, Integer pageNum, Integer pageSize);

    /* *
     * @Author lsc
     * <p> 根据用户名获取用户</p>
     * @Param [userName]
     */
    SysUser getUserByUserName(String username);



    /**
    * author lsc
    * 新增 用户
    **/
    Integer addSysUser (SysUser SysUser);


    /**
    * author lsc
    * 修改 用户
    **/
    Integer updateSysUser (SysUser SysUser);


    /**
    * author lsc
    * 删除 用户
    **/
    Integer deleteSysUser (SysUser SysUser);


    SysUser getSysUserById(Long userId);

    /* *
     * @Author lsc
     * <p>修改密码 </p>
     * @Param [sysUser]
     * @Return
     */
    Integer updateSysUserByUserName(SysUser sysUser);
}