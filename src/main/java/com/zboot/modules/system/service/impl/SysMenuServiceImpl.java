package com.zboot.modules.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zboot.common.exception.ZBootException;
import com.zboot.modules.system.domain.*;
import com.zboot.modules.system.domain.vo.SysMenuVo;
import com.zboot.modules.system.mapper.SysMenuMapper;
import com.zboot.modules.system.mapper.SysRoleMapper;
import com.zboot.modules.system.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import static com.zboot.common.result.CodeMsg.parent_ERROR;

/**
 * @Author lsc
 * <p> </p>
 */
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public Set<SysMenu> getUserMenu(Long userId, List<String> typeList, Boolean buildTree) {
        // 获取用户下所有的角色
        List<SysRole> roles = sysRoleMapper.getUserRoles(userId);
        // 获取角色id列表
        List<Long> roleIdList = roles.stream().map(role -> {
            return role.getId();
        }).collect(Collectors.toList());
        // 获取角色下所有的菜单
        List<SysMenu> menuList = sysMenuMapper.getRoleMenus(roleIdList, typeList);
        Set<SysMenu> set = null;
        if (buildTree==true){
            // 递归重组为树形结构
            set = buildMenuTree(menuList, -1L);
        }else {
            set = menuList.stream().collect(Collectors.toSet());
        }
        return set;
    }

    @Override
    public SysMenu getMenuById(Long id) {
        return sysMenuMapper.selectById(id);
    }

    @Override
    public Set<SysMenu> getRoleMenu(Long roleId) {
        ArrayList<Long> list = new ArrayList<>();
        list.add(roleId);
        List<SysMenu> menuSet = sysMenuMapper.getRoleMenus(list,null);
        // 递归重组为树形结构
        Set<SysMenu> set = buildMenuTree(menuSet, -1L);
        return set;
    }

    @Override
    public Set<SysMenu> getMenuTree() {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        List<SysMenu> sysMenus = sysMenuMapper.selectList(queryWrapper);
        return buildMenuTree(sysMenus,-1l);
    }


    private Set<SysMenu> buildMenuTree(List<SysMenu> menuList, Long pid) {
        Set<SysMenu> treeList = new LinkedHashSet<>();
        menuList.forEach(menu -> {
            if (Objects.equals(pid, menu.getParentId())) {
                menu.setChildren(buildMenuTree(menuList, menu.getId()));
                treeList.add(menu);
            }
        });
        return treeList;
    }


    /**
     * author lsc
     * 新增
     **/
    @Override
    public Integer addSysMenu (SysMenu sysMenu){

        return sysMenuMapper.insert(sysMenu);
    }

    @Transactional
    @Override
    public Integer updateRoleMenu(Long roleId, List<Long> menuIds) {
        ArrayList<SysRoleMenu> roleMenus = new ArrayList<>();
        menuIds.stream().forEach(menuId -> {
            SysRoleMenu sysRoleMenu = new SysRoleMenu();
            sysRoleMenu.setRid(roleId);
            sysRoleMenu.setMid(menuId);
            roleMenus.add(sysRoleMenu);
        });
        sysMenuMapper.deleteRoleMenu(roleId);
        return sysMenuMapper.addRoleMenu(roleMenus);
    }


    /**
     * author lsc
     * 修改
     **/
    @Override
    public Integer updateSysMenu (SysMenu sysMenu){

        return sysMenuMapper.updateById (sysMenu);
    }


    /**
     * author lsc
     * 删除
     **/
    @Override
    public Integer deleteSysMenu (Long id){
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        int count = sysMenuMapper.selectCount(wrapper);
        if (count>0){
            throw new ZBootException(parent_ERROR);
        }
        return sysMenuMapper.deleteById (id);
    }

}
