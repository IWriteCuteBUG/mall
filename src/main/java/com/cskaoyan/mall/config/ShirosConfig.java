package com.cskaoyan.mall.config;

import com.cskaoyan.mall.realm.MyRealm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Properties;

@Configuration
public class ShirosConfig {
    @Bean
    public DefaultWebSecurityManager securityManager(MyRealm myRealm, DefaultWebSessionManager sessionManager){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setSessionManager(sessionManager);
        defaultWebSecurityManager.setRealm(myRealm);
        return defaultWebSecurityManager;
    }
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        HashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("admin/auth/login","anon");
        filterChainDefinitionMap.put("admin/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setLoginUrl("admin/auth/login");
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultWebSessionManager sessionManager(){
        MySessionManager mySessionManager = new MySessionManager();
        return mySessionManager;
    }
    /*@Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver simpleMappingExceptionResolver = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("org.apache.shiro.authz.AuthorizationException","admin/auth/login");
        simpleMappingExceptionResolver.setExceptionMappings(mappings);
        return simpleMappingExceptionResolver;
    }*/

}
