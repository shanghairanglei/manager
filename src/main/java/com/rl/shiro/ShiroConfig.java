package com.rl.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        System.err.println("ShiroConfiguration.shirFilter()------shiro已经加载");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //添加shiro内置的过滤器
        /**
         *常用过滤器
         * anon:无需认证(登录)就可以访问
         * authc:必须认证才可以访问
         * user:如果使用RememberMe的功能就可以直接访问
         * perms:该资源必须得到资源权限才可以访问
         * role:该资源必须得到角色权限才可以使用
         */
        Map<String,String> filterMap = new LinkedHashMap<String, String>();
        //认证过滤器
        filterMap.put("/Login/add","authc");
        filterMap.put("/Login/update","authc");
        filterMap.put("/Login/login","anon");
        //授权过滤器
        filterMap.put("/Login/seeOneFile","perms[/seeOneFile]");

        //修改认证不通过跳转的页面
        shiroFilterFactoryBean.setLoginUrl("/Login/toLogin");
        //设置未授权跳转页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/Login/unAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }
    /**
     * 创建DefaultWebSecurityManager
     * @param shiroRealm
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("shiroRealm") ShiroRealm shiroRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(shiroRealm);
        return securityManager;

    }
    /**
     * 创建Realm
     * @return
     */
    @Bean(name = "shiroRealm")
    public ShiroRealm getRealm(){
        return new ShiroRealm();
    }

    /**
     * 配置ShiroDialect， 用于Thymeleaf和shiro的使用
     */
    @Bean
    public ShiroDialect getShiroDialect(){
        return new ShiroDialect();
    }

}
