package conference.MyFilter;

import conference.Configuration.AllUserToken;
import conference.Configuration.UserType;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/15 18:43
 */

public class MyAuthorFilter extends FormAuthenticationFilter {

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String username= request.getParameter("userEmail");
        String password=request.getParameter("password");
        String kaptcha= request.getParameter("kaptcha");
        return new AllUserToken(username, password,kaptcha , UserType.ME);
    }
}
