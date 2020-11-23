package com.zboot.modules.system.controller;


import com.alibaba.fastjson.JSONObject;
import com.zboot.common.result.ResultPage;
import com.zboot.common.exception.ZBootException;
import com.zboot.common.utils.PasswordUtils;
import com.zboot.modules.config.JWTToken;
import com.zboot.modules.system.annotation.SystemLog;
import com.zboot.modules.system.domain.SysLog;
import com.zboot.modules.system.domain.SysUser;
import com.zboot.modules.system.domain.vo.SysPasswordVo;
import com.zboot.modules.system.eu.LogEnum;
import com.zboot.modules.system.service.SysLogService;
import com.zboot.modules.system.service.SysUserService;
import com.zboot.common.utils.JwtUtil;
import com.zboot.common.result.CodeMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author lsc
 * <p> </p>
 */
@RestController
@Slf4j
@RequestMapping("system")
@Api(value = "用户登陆注册",tags = "用户登陆注册")
public class LonginController {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysLogService sysLogService;

    @ApiOperation(value = "用户登陆")
    @PostMapping(value = "login")
    public ResultPage login(@RequestBody SysUser sysUser) {
        String username = sysUser.getUsername();
        Subject subject = SecurityUtils.getSubject();
        SysUser user = sysUserService.getUserByUserName(username);
        if (user==null){
            throw  new ZBootException(CodeMsg.ACCOUNT_NOT_EXIST);
        }
        String sign = JwtUtil.sign(username, user.getPassword());
        JWTToken jwtToken = new JWTToken(sign);
        try {
            subject.login(jwtToken);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("token",sign);
            jsonObject.put("name",user.getName());
            SysLog sysLog = new SysLog();
            sysLog.setUsername(username);
            sysLog.setOprator("用户登陆");
            sysLogService.addSysLog(sysLog);
            return ResultPage.sucess(CodeMsg.SUCESS,jsonObject);
        } catch (AuthenticationException e) {
            log.error("账号或者密码错误[{}]",e.getMessage());
            return ResultPage.error(CodeMsg.ACCOUNT_ERROR);
        }
    }

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    @RequiresPermissions("user:add")
    public ResultPage register(@RequestBody SysUser sysUser){
        SysUser userByUserName = sysUserService.getUserByUserName(sysUser.getUsername());
        if (userByUserName!=null){
            return ResultPage.error(CodeMsg.ACCOUNT_USERED);
        }
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String encoder = PasswordUtils.getEncoder(salt, sysUser.getPassword());
        sysUser.setPassword(encoder);
        sysUser.setSalt(salt);
        sysUserService.addSysUser(sysUser);
        return ResultPage.sucess(CodeMsg.SUCESS,sysUser);
    }

    @ApiOperation(value = "修改密码")
    @SystemLog(operateType=LogEnum.UPDATE,value = "修改密码")
    @PutMapping("/password")
    public ResultPage updateUserPassword(@RequestBody SysPasswordVo sysPasswordVo){
        // 获取用户名
        String userName = PasswordUtils.getUserName();
        // 密码比对
        SysUser userByUserName = sysUserService.getUserByUserName(userName);
        String oldPassword = PasswordUtils.getEncoder(userByUserName.getSalt(), sysPasswordVo.getOldPassword());
        if (!oldPassword.equals(userByUserName.getPassword())){
            return ResultPage.error(CodeMsg.VERIFY_ERROR,sysPasswordVo);
        }
        SysUser sysUser = new SysUser();
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        // 获取加密后的密码
        String encoder = PasswordUtils.getEncoder(salt, sysPasswordVo.getNewPassword());
        sysUser.setPassword(encoder);
        sysUser.setUsername(userName);
        sysUser.setSalt(salt);
        sysUserService.updateSysUserByUserName(sysUser);
        return ResultPage.sucess(CodeMsg.SUCESS,sysUser);
    }


    @ApiOperation(value = "用户注销")
    @GetMapping("/logout")
    @SystemLog(operateType=LogEnum.LOGOUT)
    public  ResultPage  logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ResultPage.sucess(CodeMsg.SUCESS,"用户注销成功");
    }

    @ApiOperation(value = "未认证错误")
    @GetMapping("/error")
    //@CrossOrigin
    public  ResultPage  authMessage() {
        return ResultPage.sucess(CodeMsg.AUTH_ERROR);
    }
}
