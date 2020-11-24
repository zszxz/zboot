package com.zboot.modules.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zboot.common.result.ResultPage;
import com.zboot.common.utils.QueryWraperUtils;
import com.zboot.modules.system.annotation.SystemLog;
import com.zboot.modules.system.domain.SysRole;
import com.zboot.modules.system.domain.vo.SysRoleVo;
import com.zboot.modules.system.eu.LogEnum;
import com.zboot.modules.system.service.SysRoleService;
import com.zboot.common.result.CodeMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author lsc
 * <p> </p>
 */
@RestController
@RequestMapping("system")
@Api(value = "角色",tags = "角色")
public class SysRoleController {

    @Autowired
    SysRoleService sysRoleService;

    @ApiOperation(value = "角色列表分页查询")
    @GetMapping("/role/page")
    public ResultPage getSysRole(SysRoleVo sysRoleVo,
                                  @RequestParam(defaultValue = "1") int pageNum,
                                  @RequestParam(defaultValue = "10") int pageSize) {
        IPage<SysRole> sysRole = sysRoleService.getSysRole(sysRoleVo,pageNum,pageSize);
        return ResultPage.sucess(CodeMsg.SUCESS,sysRole);
    }

    @ApiOperation(value = "角色列表")
    @GetMapping("/roles")
    public ResultPage getSysRoleList(SysRoleVo sysRoleVo) {
        List<SysRole> sysRole = sysRoleService.getSysRoleList(sysRoleVo);
        return ResultPage.sucess(CodeMsg.SUCESS,sysRole);
    }

    @ApiOperation(value = "根据角色编号查询角色")
    @GetMapping("/role/{roleId}")
    public ResultPage getSysRoleById(@PathVariable("roleId") Long roleId) {
        SysRole sysRole = sysRoleService.getSysRoleById(roleId);
        return ResultPage.sucess(CodeMsg.SUCESS,sysRole);
    }

    @ApiOperation(value = "添加修改用户拥有的角色")
    @PutMapping("/user/role/{userId}")
    @RequiresPermissions("user:role")
    @SystemLog(operateType= LogEnum.UPDATE,value = "添加修改用户角色")
    public ResultPage updateUserRole(@PathVariable("userId") Long userId, @RequestParam List<Long> roleIds){
        Integer integer = sysRoleService.updateUserRole(userId, roleIds);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }

    @ApiOperation(value = "修改角色")
    @PutMapping("/role/{id}")
    @RequiresPermissions("role:edit")
    @SystemLog(operateType= LogEnum.DELETE,value = "修改角色")
    public ResultPage updateUser(@RequestBody SysRole sysRole, @PathVariable("id") Long id){
        sysRole.setId(id);
        Integer integer = sysRoleService.updateSysRole(sysRole);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/role")
    @RequiresPermissions("role:add")
    @SystemLog(operateType= LogEnum.DELETE,value = "添加角色")
    public ResultPage addUser(@RequestBody SysRole sysRole){
        Integer integer = sysRoleService.addSysRole(sysRole);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/role/{id}")
    @RequiresPermissions("role:delete")
    @SystemLog(operateType= LogEnum.DELETE,value = "删除角色")
    public ResultPage deleteUser( @PathVariable("id") Long id){
        SysRole role = new SysRole();
        role.setId(id);
        Integer integer = sysRoleService.deleteSysRole(role);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }
}
