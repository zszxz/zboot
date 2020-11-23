package com.zboot.modules.system.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zboot.common.result.ResultPage;
import com.zboot.modules.system.annotation.SystemLog;
import com.zboot.modules.system.domain.SysRole;
import com.zboot.modules.system.domain.SysUser;
import com.zboot.modules.system.domain.vo.SysUserVo;
import com.zboot.modules.system.eu.LogEnum;
import com.zboot.modules.system.service.SysRoleService;
import com.zboot.modules.system.service.SysUserService;
import com.zboot.common.result.CodeMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * @Author lsc
 * <p> </p>
 */
@RestController
@RequestMapping("system")
@Api(value = "用户",tags = "用户")
public class SysUserController {

    @Autowired
    SysUserService userService;

    @Autowired
    SysRoleService sysRoleService;

    @ApiOperation(value = "查询用户分页查询")
    @GetMapping("/user/list")
    public ResultPage getSysUser(SysUserVo sysUserVo,
                                 @RequestParam(defaultValue = "1") int pageNum,
                                 @RequestParam(defaultValue = "10") int pageSize) {
        IPage<SysUser> sysUser = userService.getSysUser(sysUserVo, pageNum, pageSize);
        return ResultPage.sucess(CodeMsg.SUCESS,sysUser);
    }

    @ApiOperation(value = "根据用户编号查询用户")
    @GetMapping("/user/{userId}")
    public ResultPage getSysUser(@PathVariable("userId") Long userId) {
        SysUser sysUser = userService.getSysUserById(userId);
        return ResultPage.sucess(CodeMsg.SUCESS,sysUser);
    }

    @ApiOperation(value = "通过用户id获取所有角色")
    @GetMapping("/user/role/{userId}")
    public ResultPage getUserRoles(@PathVariable("userId") Long userId) {
        List<SysRole> userRoles = sysRoleService.getUserRoles(userId);
        return ResultPage.sucess(CodeMsg.SUCESS,userRoles);
    }

    @ApiOperation(value = "修改用户")
    @PutMapping("/user/{id}")
    @RequiresPermissions("user:edit")
    @SystemLog(operateType= LogEnum.UPDATE,value = "修改用户")
    public ResultPage updateUser(@RequestBody SysUser sysUser, @PathVariable("id") Long id){
        sysUser.setId(id);
        // 禁止修改用户密码
        if (StringUtils.isNotBlank(sysUser.getPassword())){
            sysUser.setPassword(null);
        }
        Integer integer = userService.updateSysUser(sysUser);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }


    @ApiOperation(value = "删除用户")
    @DeleteMapping("/user/{id}")
    @RequiresPermissions("user:delete")
    @SystemLog(operateType= LogEnum.DELETE,value = "删除用户")
    public ResultPage deleteUser( @PathVariable("id") Long id){
        SysUser user = new SysUser();
        user.setId(id);
        Integer integer = userService.deleteSysUser(user);
        return ResultPage.sucess(CodeMsg.SUCESS,integer);
    }

}
