package conference.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/15 9:47
 *
 * @version 1.0
 */
@Component
@ConfigurationProperties(prefix = "mptest")
public class MpTestProperty {
    String appId;
    String secret;
    String token;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
