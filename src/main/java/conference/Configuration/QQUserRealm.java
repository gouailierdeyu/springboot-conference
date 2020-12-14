package conference.Configuration;

import conference.DAO.ORM.MyUser;
import conference.services.MyUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * UTF-8
 * Created by CZY    Time : 2019/9/30 9:38
 */

//继承AuthorizingRealm就既有Authorization的api 也有Authentication的api .
public class QQUserRealm extends AuthorizingRealm {

    @Autowired
    MyUserService myUserService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        AllUserToken token=(AllUserToken)authenticationToken;
        if (token.getType()==UserType.QQ){
            MyUser myUser = myUserService.doGetQQUser( token.getUsername(),String.valueOf(token.getPassword()));
            if (myUser == null) {
                return null;
            }
            return new SimpleAuthenticationInfo(myUser,myUser.getPassword(),"");
        }else {
            return null;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }


}
