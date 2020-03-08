package conference.Configuration;

import conference.DAO.ORM.MyUser;
import conference.MyException.KaptchaErrorException;
import conference.services.MyUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/11 15:48
 */
@Component
public class MyUserRealm extends AuthorizingRealm {
    @Autowired
    private MyUserService myUserService;

    public MyUserService getMyUserService() {
        return myUserService;
    }

    public void setMyUserService(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return super.supports(token);
    }

    @Override//授权管理
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override//认证管理
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        AllUserToken token=(AllUserToken)authenticationToken;
        if (token.getType()==UserType.ME) {
            String username = token.getUsername();
            String kaptcha = token.getKaptchavalue();
            //String username=(String) authenticationToken.getPrincipal();

            String sessionCaptcha = (String) SecurityUtils.getSubject().getSession().getAttribute("KAPTCHA_SESSION_KEY");

            // 比较登录输入的验证码和SESSION保存的验证码是否一致
            if (!sessionCaptcha.equals(kaptcha)) {

                // 抛出自定义异常(继承AuthenticationException), Shiro会捕获AuthenticationException异常
                // 发现该异常时认为登录失败,执行登录失败逻辑,登录失败页中可以判断如果是CaptchaEmptyException时为验证码错误
                throw new KaptchaErrorException();
            }

            MyUser myUser = myUserService.doGetUserByName(username);
            if (myUser == null) {
                return null;
            }

            return new SimpleAuthenticationInfo(myUser, myUser.getPassword(), "");
        }else {
            return null;
        }
    }


}
