package com.zboot.modules.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author lsc
 * <p> </p>
 */
@Configuration
public class ShiroConfiguration {

    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /* *
     * @Author lsc
     * <p> 登陆拦截</p>
     * @Param [securityManager]
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt", new JwtFilter());
        shiroFilterFactoryBean.setFilters(filterMap);
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 自定义拦截规则
        Map<String, String> filterRuleMap = new HashMap<>();
        // 系统接口放行
        filterRuleMap.put("/system/login","anon");
        filterRuleMap.put("/system/logout","anon");
        filterRuleMap.put("/system/download/**","anon");
        filterRuleMap.put("/system/error","anon");
        // swagger 端口放行
        filterRuleMap.put("//","anon");
        filterRuleMap.put("/","anon");
        filterRuleMap.put("/swagger-ui.html","anon");
        filterRuleMap.put("/webjars/**","anon");
        filterRuleMap.put("/webjars/**/**/**","anon");
        filterRuleMap.put("/swagger**/**", "anon");
        filterRuleMap.put("/swagger**/**/**", "anon");
        filterRuleMap.put("/null/swagger-resources/**", "anon");
        filterRuleMap.put("/v2/**", "anon");
        filterRuleMap.put("/csrf", "anon");
        filterRuleMap.put("/csrf/**", "anon");
        filterRuleMap.put("/druid/**", "anon");
        filterRuleMap.put("/druid//**", "anon");
        // 静态文件放行
        filterRuleMap.put("/**/*.ttf", "anon");
        filterRuleMap.put("/**/*.jpg", "anon");
        filterRuleMap.put("/**/*.png", "anon");
        filterRuleMap.put("/**/*.ico", "anon");
        filterRuleMap.put("/**/*.js", "anon");
        filterRuleMap.put("/**/*.css", "anon");
        filterRuleMap.put("/**/*.html", "anon");
        filterRuleMap.put("/file/download/**", "anon");

        filterRuleMap.put("/**", "jwt");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(Realm());
        return securityManager;
    }

    /* *
     * @Author lsc
     * <p>认证信息 </p>
     * @Param []
     */
    @Bean
    public Realm Realm() {
        Realm realm = new Realm();
        return realm;
    }
    /* *
     * @Author lsc
     * <p> 加密</p>
     * @Param []
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }
    /* *
     * @Author lsc
     * <p> 开启Shiro-aop注解支持</p>
     * @Param [securityManager]
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator app=new DefaultAdvisorAutoProxyCreator();
        app.setProxyTargetClass(true);
        return app;
    }

}
