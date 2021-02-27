package com.xf.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean getFliter(@Qualifier("getSecurityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);

        filterFactoryBean.setLoginUrl("/logincheck");
        return filterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager getSecurityManager(@Qualifier("realm")UserRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);

        return securityManager;
    }
    @Bean
    public UserRealm realm(){
        return new UserRealm();
    }
}
