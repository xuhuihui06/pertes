package com.kingduns.pertes.config.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ShiroConfig {

	/**
	 * 创建ShiroFilterFactoryBean
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(
			@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		// 1、设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		// 2、设置Shiro内置的安全过滤器，来对相关权限进行拦截
		/**
		 * 常用过滤器 anon：无需认证（登录）可以访问 authc：必须认证才可以访问 user：如果使用rememberMe的功能可以直接访问
		 * perms：该资源必须得到资源权限才可以访问 role：该资源必须得到角色权限才可以访问
		 */
		Map<String, String> filterMap = new LinkedHashMap<String, String>();
		filterMap.put("/rsat/user/queryUser", "anon");
		filterMap.put("rsat/user/addUser", "anon");
		filterMap.put("/register", "anon");
		filterMap.put("/rsat/iteration/getIterationList", "anon");
		/**
		 * 资源权限过滤器
		 */
		filterMap.put("/user/add", "perms[user:addUser]");
		/*filterMap.put("/addUser", "authc");
		filterMap.put("/updateUser", "authc");*/
		/**
		 * 若一个文件夹下的所有页面全部需要拦截可采用通配符
		 */
		filterMap.put("/user/*", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
		// 3、没有权限访问时，转跳到登录页面
		shiroFilterFactoryBean.setLoginUrl("/login");
		return shiroFilterFactoryBean;
	}

	/**
	 * 创建DefaultWebSecurityManager
	 * 
	 * @return
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		return securityManager;
	}

	@Bean
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	/**
	 * 创建Realm
	 * 
	 * @return
	 */
	@Bean(name = "userRealm")
	@DependsOn(value = { "lifecycleBeanPostProcessor" })
	public UserRealm getRealm() {
		UserRealm userRealm = new UserRealm();
		// 设置认证密码算法及迭代复杂度
		userRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return userRealm;
	}

	/**
	 * 创建CredentialsMatcher
	 * 
	 * @return
	 */
	@Bean(name = "hashedCredentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
		credentialsMatcher.setHashAlgorithmName("MD5");
		credentialsMatcher.setHashIterations(2);
		// credentialsMatcher.setStoredCredentialsHexEncoded(true);
		return credentialsMatcher;
	}

	/**************************************
	 * Session管理
	 *******************************************/
	/**
	 * 配置session监听
	 * 
	 * @return
	 */
	/*@Bean("sessionListener")
	public ShiroSessionListener sessionListener() {
		ShiroSessionListener sessionListener = new ShiroSessionListener();
		return sessionListener;
	}
	
	*//**
		 * 配置会话ID生成器
		 * 
		 * @return
		 */
	/*
	@Bean
	public SessionIdGenerator sessionIdGenerator() {
	return new JavaUuidSessionIdGenerator();
	}
	
	*//**
		 * SessionDAO的作用是为Session提供CRUD并进行持久化的一个shiro组件 MemorySessionDAO 直接在内存中进行会话维护
		 * EnterpriseCacheSessionDAO
		 * 提供了缓存功能的会话维护，默认情况下使用MapCache实现，内部使用ConcurrentHashMap保存缓存的会话。
		 * 
		 * @return
		 *//*
			@Bean
			public SessionDAO sessionDAO() {
			 EnterpriseCacheSessionDAO enterpriseCacheSessionDAO = new EnterpriseCacheSessionDAO();
			 //使用ehCacheManager
			 enterpriseCacheSessionDAO.setCacheManager(ehCacheManager());
			 //设置session缓存的名字 默认为 shiro-activeSessionCache
			 enterpriseCacheSessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");
			 //sessionId生成器
			 enterpriseCacheSessionDAO.setSessionIdGenerator(sessionIdGenerator());
			 return enterpriseCacheSessionDAO;
			}*/
}
