package com.zboot.modules.config;

import com.zboot.common.utils.PasswordUtils;
import com.zboot.modules.system.domain.SysMenu;
import com.zboot.modules.system.domain.SysRole;
import com.zboot.modules.system.domain.SysUser;
import com.zboot.modules.system.service.SysMenuService;
import com.zboot.modules.system.service.SysRoleService;
import com.zboot.modules.system.service.SysUserService;
import com.zboot.common.utils.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author lsc
 * <p> </p>
 */
public class Realm extends AuthorizingRealm {

    @Autowired
    private SysUserService userService;

    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    SysMenuService sysMenuService;


    // 简单重写获取授权信息方法
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String token = principalCollection.toString();
        String userName = JwtUtil.getUserNameByToken(token);
        SysUser sysUser = userService.getUserByUserName(userName);
        List<SysRole> userRoles = sysRoleService.getUserRoles(sysUser.getId());
        Set<String> roleSet = userRoles.stream().map(userRole -> {
            return userRole.getRoleName();
        }).collect(Collectors.toSet());
        // 授权角色
        simpleAuthorizationInfo.setRoles(roleSet);
        // 授权权限
        ArrayList<String> typeList = new ArrayList<>();
        typeList.add("3");
        Set<SysMenu> userMenu = sysMenuService.getUserMenu(sysUser.getId(), typeList, false);
        Set<String> permission = userMenu.stream()
                .map(menu -> {
                    return menu.getPermission();
                })
                .collect(Collectors.toSet());
        simpleAuthorizationInfo.setStringPermissions(permission);
        return simpleAuthorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JWTToken jwtToken = (JWTToken) token;
        String sign = jwtToken.getPrincipal().toString();
        String userName = JwtUtil.getUserNameByToken(sign);
        SysUser user = userService.getUserByUserName(userName);
        String password = user.getPassword();
        if (StringUtils.isBlank(userName)) {
            throw new AuthenticationException("token 无效，不存在此用户");
        }
        if (!JwtUtil.verify(sign,userName,password)) {
            throw new AuthenticationException("token校验失败，请重新登陆");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(sign, sign, getName());
        return authenticationInfo;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }
}
