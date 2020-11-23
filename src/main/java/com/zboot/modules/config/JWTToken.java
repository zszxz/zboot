package com.zboot.modules.config;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @Author lsc
 * <p> </p>
 */
public class JWTToken implements AuthenticationToken {
    // sing
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
