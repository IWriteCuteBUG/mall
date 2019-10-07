package com.cskaoyan.mall.config;

import com.cskaoyan.mall.realm.CustomRealmAuthenticator;
import com.cskaoyan.mall.realm.AdminRealm;
import com.cskaoyan.mall.realm.WeChatRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Configuration
public class ShirosConfig {
    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("adminRealm") AdminRealm adminRealm,
                                                     @Qualifier("weChatRealm") WeChatRealm wxRealm,
                                                     DefaultWebSessionManager sessionManager,
                                                     CustomRealmAuthenticator customRealmAuthenticator){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setSessionManager(sessionManager);
        defaultWebSecurityManager.setRealm(adminRealm);
        defaultWebSecurityManager.setRealm(wxRealm);
        defaultWebSecurityManager.setAuthenticator(customRealmAuthenticator);
        return defaultWebSecurityManager;
    }

    @Bean
    public CustomRealmAuthenticator customRealmAuthenticator(@Qualifier("adminRealm") AdminRealm adminRealm,
                                                             @Qualifier("weChatRealm") WeChatRealm wxRealm){
        CustomRealmAuthenticator customRealmAuthenticator = new CustomRealmAuthenticator();
        ArrayList<Realm> realms = new ArrayList<>();
        realms.add(adminRealm);
        realms.add(wxRealm);
        customRealmAuthenticator.setRealms(realms);
        return customRealmAuthenticator;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        HashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("admin/auth/login","anon");
        filterChainDefinitionMap.put("wx/home/index","anon");
        filterChainDefinitionMap.put("wx/catalog/**","anon");
        filterChainDefinitionMap.put("wx/auth/**","anon");
        filterChainDefinitionMap.put("wx/topic/**","anon");
        filterChainDefinitionMap.put("wx/brand/**","anon");
        filterChainDefinitionMap.put("wx/search/**","anon");
        filterChainDefinitionMap.put("wx/goods/**","anon");
        filterChainDefinitionMap.put("wx/groupon/list","anon");
        filterChainDefinitionMap.put("wx/coupon/list","anon");
        filterChainDefinitionMap.put("wx/comment/list","anon");
        filterChainDefinitionMap.put("wx/cart/**","authc");
        filterChainDefinitionMap.put("wx/collect/**","authc");
        filterChainDefinitionMap.put("wx/address/**","authc");
        filterChainDefinitionMap.put("wx/express/query","authc");
        filterChainDefinitionMap.put("wx/order/**","authc");
        filterChainDefinitionMap.put("wx/footprint/**","authc");
        filterChainDefinitionMap.put("wx/feedback/submit","authc");
        filterChainDefinitionMap.put("wx/comment/post","authc");
        filterChainDefinitionMap.put("wx/comment/count","authc");
        filterChainDefinitionMap.put("wx/storage/upload","authc");
        filterChainDefinitionMap.put("wx/user/index","authc");
        filterChainDefinitionMap.put("admin/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        shiroFilterFactoryBean.setLoginUrl("admin/auth/login");
        shiroFilterFactoryBean.setLoginUrl("wx/auth/logout");
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
