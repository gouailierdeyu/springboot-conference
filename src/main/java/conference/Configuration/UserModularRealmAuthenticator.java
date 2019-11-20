package conference.Configuration;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;

/**
 * UTF-8
 * Created by CZY    Time : 2019/10/10 10:03
 */
public class UserModularRealmAuthenticator extends ModularRealmAuthenticator {
    private static final Logger log = LoggerFactory.getLogger(ModularRealmAuthenticator.class);
    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken) throws AuthenticationException {
        this.assertRealmsConfigured();
        AllUserToken token=(AllUserToken) authenticationToken;
        UserType userType=token.getType();
        Collection<Realm> realms=this.getRealms();
        String typeSting=null;
        if (userType==UserType.ME){
            typeSting="MyUserRealm";
        }else if(userType==UserType.QQ){
            typeSting="QQUserRealm";
        }



        Collection<Realm> typeRealms = new ArrayList<>();
        for (Realm realm : realms) {
            if (realm.getName().contains(typeSting)) // 注：这里使用类名包含枚举，区分realm
                typeRealms.add(realm);
        }
        // 判断是单Realm还是多Realm

        if (typeRealms.size() == 1) {
            return doSingleRealmAuthentication(typeRealms.iterator().next(), token);
        } else {
            return doMultiRealmAuthentication(typeRealms, token);
        }
    }
}
