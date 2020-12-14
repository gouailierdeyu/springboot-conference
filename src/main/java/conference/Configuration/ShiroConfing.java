package conference.Configuration;

import conference.MyFilter.MyAuthorFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.servlet.Filter;
import java.util.*;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/10 15:48
 */
@Configuration
public class ShiroConfing  {
    /**
     * 创建ShiroFilterFactoryBean
     * shiro过滤bean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(
            @Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, Filter> myAuthorFilterMap=new LinkedHashMap<>();
        myAuthorFilterMap.put("authc", new MyAuthorFilter());
        shiroFilterFactoryBean.setFilters(myAuthorFilterMap);
        // 添加Shiro内置过滤器
        /**
         * Shiro内置过滤器，可以实现权限相关的拦截器
         *  常用的过滤器：
         *      anon: 无需认证（登录）可以访问
         *      authc: 必须认证才可以访问
         *      user: 如果使用rememberMe功能可以直接访问
         *      perms: 该资源必须得到资源权限才可以访问
         *      role: 该资源必须得到角色权限才可以访问
         */

        Map<String, String> filerMap = new LinkedHashMap<>(); //顺序的map
        //配置记住我或认证通过可以访问的地址
        //如果没有拦截，默认会跳转到login.jsp，可以通过setLoginUrl设置登录页面
         /*
         * anon:表示可以匿名使用。
           authc:表示需要认证(登录)才能使用，没有参数
           roles：参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，当有多个参数时，例如admins/user/**=roles["admin,guest"],每个参数通过才算通过，相当于hasAllRoles()方法。
           perms：参数可以写多个，多个时必须加上引号，并且参数之间用逗号分割，例如/admins/user/**=perms["user:add:*,user:modify:*"]，当有多个参数时必须每个参数都通过才通过，想当于isPermitedAll()方法。
           rest：根据请求的方法，相当于/admins/user/**=perms[user:method] ,其中method为post，get，delete等。
           port：当请求的url的端口不是8081是跳转到schemal://serverName:8081?queryString,其中schmal是协议http或https等，serverName是你访问的host,8081是url配置里port的端口，queryString是你访问的url里的？后面的参数。
           authcBasic：没有参数表示httpBasic认证
           ssl:表示安全的url请求，协议为https
           user:当登入操作时不做检查
         */
        filerMap.put("/script/**", "anon");
        filerMap.put("/images/**", "anon");
        filerMap.put("/index","anon");
        filerMap.put("/register","anon");
        filerMap.put("/insertMyUser","anon");
        filerMap.put("/login","anon");
        filerMap.put("/checkMyUser","anon");
        filerMap.put("/account/**","authc");
       // filerMap.put("/**","anon");

        //授权过滤器
//      filerMap.put("/add","perms[user:add]");
//      filerMap.put("/update","perms[user:update]");
        filerMap.put("/html/admin", "authc,roles[admin]");

        //设置登录的页面，发送toLogin请求
        shiroFilterFactoryBean.setLoginUrl("/login");

        //设置未授权的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        //设置过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filerMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(
    @Qualifier("authenticator") ModularRealmAuthenticator authenticator,
    @Qualifier("qquserRealm") QQUserRealm qqUserRealm,@Qualifier("userRealm") MyUserRealm userRealm,
    @Qualifier("rememberMeManager") RememberMeManager rememberMeManager ){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联多个realm
        Collection<Realm> realms=new ArrayList<>();
        realms.add(qqUserRealm);
        realms.add(userRealm);
        securityManager.setAuthenticator(authenticator);//在setrealms之前
        securityManager.setRealms(realms);
        securityManager.setRememberMeManager(rememberMeManager);
        //securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    @Bean("authenticator")
    public ModularRealmAuthenticator getModularRealmAuthenticator(@Qualifier("qquserRealm") QQUserRealm qqUserRealm,@Qualifier("userRealm") MyUserRealm userRealm){
        UserModularRealmAuthenticator authenticator=new UserModularRealmAuthenticator();

        Collection<Realm> realms=new ArrayList<>();
        realms.add(qqUserRealm);
        realms.add(userRealm);
        authenticator.setRealms(realms);

        authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());//默认
        return authenticator;
    }
    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public MyUserRealm getRealm(@Qualifier("hashedCredentialsMatcher")HashedCredentialsMatcher matcher){
        MyUserRealm userRealm=new MyUserRealm();
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }

    @Bean(name = "qquserRealm")
    public QQUserRealm getQQRealm(@Qualifier("hashedCredentialsMatcher")HashedCredentialsMatcher matcher){
        QQUserRealm qquserRealm=new QQUserRealm();
        qquserRealm.setCredentialsMatcher(matcher);
        return qquserRealm;
    }

    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher getHashedCredentialsMatcher(){
        HashedCredentialsMatcher matcher=new HashedCredentialsMatcher("MD5");
        matcher.setStoredCredentialsHexEncoded(true);
        return matcher;
    }

    @Bean("rememberMeCookie")
    public SimpleCookie getrememberMeCookie(){
        SimpleCookie cookie=new SimpleCookie("rememberMe");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(2592000);
        return cookie;
    }
    @Bean("rememberMeManager")
    public RememberMeManager getRememberMeManager(@Qualifier("rememberMeCookie") SimpleCookie cookie){
        CookieRememberMeManager manager=new CookieRememberMeManager();

        manager.setCipherKey(Base64.decode("3AvVhmFLUs0KTA3Kprsdag=="));
        manager.setCookie(cookie);
        return manager;
    }

    @Bean("rememberMeFilter")
    public FormAuthenticationFilter getrememberMeFilter(){
           FormAuthenticationFilter formAuthenticationFilter=new FormAuthenticationFilter();
           formAuthenticationFilter.setRememberMeParam("rememberMe");
        return formAuthenticationFilter;
    }


}
