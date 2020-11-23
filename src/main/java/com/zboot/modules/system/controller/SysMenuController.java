package com.zboot.modules.system.controller;


import com.zboot.common.result.ResultPage;
import com.zboot.common.utils.PasswordUtils;
import com.zboot.modules.system.annotation.SystemLog;
import com.zboot.modules.system.domain.SysMenu;
import com.zboot.modules.system.domain.SysUser;
import com.zboot.modules.system.domain.vo.SysMenuVo;
import com.zboot.modules.system.eu.LogEnum;
import com.zboot.modules.system.service.SysMenuService;
import com.zboot.modules.system.service.SysUserService;
import com.zboot.common.utils.JwtUtil;
import com.zboot.common.result.CodeMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;


/**
 * @Author lsc
 * <p> </p>
 */
@RestController
@RequestMapping("system")
@Api(value = "菜单",tags = "菜单")
public class SysMenuController {

    @Autowired
    SysMenuService menuService;
    @Autowired
    SysUserService sysUserService;

    @ApiOperation(value = "获取用户下拥有的菜单或者构建为菜单树")
    @GetMapping("menus/user")
    public ResultPage getUserMenu(SysMenuVo sysMenuVo ){
        String userName = PasswordUtils.getUserName();
        SysUser user = sysUserService.getUserByUserName(userName);
        Set<SysMenu> userMenu = menuService.getUserMenu(user.getId(),sysMenuVo.getTypeList(),sysMenuVo.getBuildTree());
        return ResultPage.sucess(CodeMsg.SUCESS,userMenu);
    }


    @ApiOperation(value = "查询角色拥有菜单树")
    @GetMapping("/menus/role/{roleId}")
    public ResultPage getRoleMenu(@PathVariable("roleId") Long roleId) {
        Set<SysMenu> sysMenu = menuService.getRoleMenu(roleId);
        return ResultPage.sucess(CodeMsg.SUCESS,sysMenu);
    }

    @ApiOperation(value = "根据菜单编号查询菜单")
    @GetMapping("/menus/{id}")
    public ResultPage getMenuById(@PathVariable("id") Long id) {
        SysMenu sysMenu = menuService.getMenuById(id);
        return ResultPage.sucess(CodeMsg.SUCESS,sysMenu);
    }

    @ApiOperation(value = "查询菜单树")
    @GetMapping("/menus/tree")
    public ResultPage getMenuTree() {
        Set<SysMenu> sysMenu = menuService.getMenuTree();
        return ResultPage.sucess(CodeMsg.SUCESS,sysMenu);
    }

    @ApiOperation(value = "添加修改角色菜单权限")
    @PutMapping("/menus/role/{roleId}")
    @RequiresPermissions("role:menu")
    @SystemLog(operateType= LogEnum.UPDATE,value = "添加修改菜单权限")
    public ResultPage updateRoleMenu(@PathVariable("roleId") Long roleId,@RequestParam List<Long> menuIds){
        Integer integer = menuService.updateRoleMenu(roleId,menuIds);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }

    @ApiOperation(value = "修改菜单")
    @PutMapping("/menus/{id}")
    @RequiresPermissions("menu:edit")
    public ResultPage updateSysMenu(@RequestBody SysMenu sysMenu, @PathVariable("id") Long id){
        sysMenu.setId(id);
        Integer integer = menuService.updateSysMenu(sysMenu);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }

    @ApiOperation(value = "添加菜单")
    @PostMapping("/menus")
    @RequiresPermissions("menu:add")
    @SystemLog(operateType= LogEnum.INSERT,value = "添加菜单")
    public ResultPage addSysMenu(@RequestBody SysMenu sysMenu){
        Integer integer = menuService.addSysMenu(sysMenu);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }

    @ApiOperation(value = "删除菜单")
    @DeleteMapping("/menus/{id}")
    @RequiresPermissions("menu:delete")
    @SystemLog(operateType= LogEnum.DELETE,value = "删除菜单")
    public ResultPage deleteSysMenu( @PathVariable("id") Long id){
        Integer integer = menuService.deleteSysMenu(id);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }
}
