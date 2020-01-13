package cn.svenbarnett.dframe.core.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro的配置文件
 *
 * @author pswen/3197544360@qq.com
 * @date 2019/10/12 14:54
 * @since 1.0
 */
@Configuration
public class ShiroConfig {

    private static final String NAME = "custom.name";
    private static final String VALUE = "/";

    private Map<String, String> configMap;

    @Value("${shiroFilter.loginUrl}")
    private String loginUrl;

    @Value("${shiroFilter.successUrl}")
    private String successUrl;

    @Value("${shiroFilter.unauthorizedUrl}")
    private String unauthorizedUrl;

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager,
                                              @Qualifier("frameShiroSerivce") FrameShiroSerivce frameShiroSerivce) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 设置自定义的角色权限过滤器
        Map<String, Filter> filterMap = new LinkedHashMap<>(1);
        filterMap.put("roles", rolesAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        shiroFilterFactoryBean.setSuccessUrl(successUrl);
        shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);
        // 加载数据库的相关权限路由控制
        shiroFilterFactoryBean.setFilterChainDefinitionMap(frameShiroSerivce.loadFilterChainDefinitions());
        return shiroFilterFactoryBean;
    }

    @Bean("rolesAuthorizationFilter")
    public RolesAuthorizationFilter rolesAuthorizationFilter() {
        return new FrameRolesAuthorizationFilter();
    }

    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(authRealm);
        return securityManager;
    }

    @Bean("authRealm")
    public AuthRealm authRealm() {
        AuthRealm authRealm = new AuthRealm();
        return authRealm;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean("simpleCookie")
    public SimpleCookie simpleCookie() {
        SimpleCookie simpleCookie = new SimpleCookie();
        simpleCookie.setName(NAME);
        simpleCookie.setValue(VALUE);
        return simpleCookie;
    }
}

