package com.zboot.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zboot.common.utils.QueryWraperUtils;
import com.zboot.modules.system.domain.SysRole;
import com.zboot.modules.system.domain.SysUserRole;
import com.zboot.modules.system.domain.vo.SysRoleVo;
import com.zboot.modules.system.mapper.SysMenuMapper;
import com.zboot.modules.system.mapper.SysRoleMapper;
import com.zboot.modules.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
*
* @author lsc
* <p>
*    服务层
* </p>
*/
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Autowired
    SysMenuMapper sysMenuMapper;


    /**
    * author lsc
    * 查询 列表
    **/
    @Override
    public IPage<SysRole> getSysRole (SysRoleVo sysRoleVo, Integer pageNum, Integer pageSize){
        Page<SysRole> page = new Page<>(pageNum, pageSize);
        QueryWrapper<SysRole> queryWrapper = QueryWraperUtils.getQueryWrapper(sysRoleVo);
        return sysRoleMapper.selectPage (page,queryWrapper);
    }

    @Override
    public List<SysRole> getSysRoleList(SysRoleVo sysRoleVo) {
        return sysRoleMapper.selectList (null);
    }

    @Transactional
    @Override
    public Integer updateUserRole(Long userId, List<Long> roleIds) {
        ArrayList<SysUserRole> userRoles = new ArrayList<>();
        roleIds.stream().forEach(role_id -> {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUid(userId);
            sysUserRole.setRid(role_id);
            userRoles.add(sysUserRole);
        });
        sysRoleMapper.deleteUserRole(userId);
        return sysRoleMapper.addUserRole(userRoles);
    }

    @Override
    public List<SysRole> getUserRoles(Long userId) {

        return sysRoleMapper.getUserRoles(userId);
    }

    /**
    * author lsc
    * 新增 
    **/
    @Override
    public Integer addSysRole (SysRole sysRole){

        return sysRoleMapper.insert (sysRole);
    }


    /**
    * author lsc
    * 修改 
    **/
    @Override
    public Integer updateSysRole (SysRole sysRole){

        return sysRoleMapper.updateById (sysRole);
    }


    /**
    * author lsc
    * 删除 
    **/
    @Override
    @Transactional
    public Integer deleteSysRole (SysRole sysRole){
        sysMenuMapper.deleteRoleMenu(sysRole.getId());
        return sysRoleMapper.deleteById (sysRole.getId());
    }

    @Override
    public SysRole getSysRoleById(Long roleId) {
        return sysRoleMapper.selectById(roleId);
    }


}