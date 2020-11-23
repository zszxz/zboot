package com.zboot.modules.system.service.impl;


import cn.hutool.core.util.PageUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zboot.common.utils.QueryWraperUtils;
import com.zboot.modules.system.domain.SysUser;
import com.zboot.modules.system.domain.vo.SysUserVo;
import com.zboot.modules.system.mapper.SysMenuMapper;
import com.zboot.modules.system.mapper.SysRoleMapper;
import com.zboot.modules.system.mapper.SysUserMapper;
import com.zboot.modules.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*
* @author lsc
* <p>
*    服务层
* </p>
*/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper SysUserMapper;

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Autowired
    SysRoleMapper sysRoleMapper;

    /**
    * author lsc
    * 查询 列表
    **/
    @Override
    public IPage<SysUser> getSysUser (SysUserVo sysUserVo, Integer pageNum, Integer pageSize){
        Page<SysUser> page = new Page<>(pageNum, pageSize);
        QueryWrapper<SysUser> queryWrapper = QueryWraperUtils.getQueryWrapper(sysUserVo);
        return SysUserMapper.selectPage(page,queryWrapper);
    }

    @Override
    public SysUser getUserByUserName(String username) {

        return SysUserMapper.getUserByUserName(username);
    }



    /**
    * author lsc
    * 新增
    **/
    @Override
    public Integer addSysUser (SysUser sysUser){

        return SysUserMapper.insert (sysUser);
    }


    /**
    * author lsc
    * 修改
    **/
    @Override
    public Integer updateSysUser (SysUser sysUser){

        return SysUserMapper.updateById(sysUser);
    }


    /**
    * author lsc
    * 删除
    **/
    @Override
    @Transactional
    public Integer deleteSysUser (SysUser sysUser){
        sysRoleMapper.deleteUserRole(sysUser.getId());
        return SysUserMapper.deleteById (sysUser.getId());
    }

    @Override
    public SysUser getSysUserById(Long userId) {
        return SysUserMapper.selectById(userId);
    }

    @Override
    public Integer updateSysUserByUserName(SysUser sysUser) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",sysUser.getUsername());
        return SysUserMapper.update(sysUser,queryWrapper);
    }


}