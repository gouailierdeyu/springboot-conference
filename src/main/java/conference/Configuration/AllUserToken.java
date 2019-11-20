package conference.Configuration;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * UTF-8
 * Created by CZY    Time : 2019/10/10 9:50
 */
public class AllUserToken extends UsernamePasswordToken {
    UserType type;
    private String kaptchavalue;

    public AllUserToken(String username, String password, String kaptchavalue, UserType type) {
        super(username, password);
        this.type = type;
        this.kaptchavalue = kaptchavalue;
    }

    public AllUserToken(String username, String password, UserType type) {
        super(username, password);
        this.type = type;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getKaptchavalue() {
        return kaptchavalue;
    }

    public void setKaptchavalue(String kaptchavalue) {
        this.kaptchavalue = kaptchavalue;
    }
}
