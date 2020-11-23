package com.zboot.common.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

/**
 * @Author lsc
 * <p> </p>
 */
public class PasswordUtils {

    /* *
     * @Author lsc
     * <p>获取用户名 </p>
     */
    public static String getUserName(){
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principals = subject.getPrincipals();
        String userNameByToken = JwtUtil.getUserNameByToken(principals.toString());
        return userNameByToken;
    }

    /* *
     * @Author lsc
     * <p>获取加密后的密码 </p>
     * @Param [salt, password]
     * @Return
     */
    public static String getEncoder(String salt, String password){
        String hashAlgorithmName = "MD5";
        int hashIterations = 2;
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, password, credentialsSalt, hashIterations);
        return simpleHash.toString();
    }
}
