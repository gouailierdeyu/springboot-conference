package conference.Contorller;

import conference.Configuration.AllUserToken;
import conference.Configuration.UserType;
import conference.DAO.ORM.MyUser;
import conference.DAO.ORM.ThirdApp;
import conference.MyException.KaptchaErrorException;
import conference.Utils.ResultSet;
import conference.services.MyUserService;
import conference.services.ThirdAppService;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PortFilter;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/6 20:02
 */
@Controller
public class LoginPageCtrl {

    @Autowired
    MyUserService myUserService;

    @Autowired
    ThirdAppService thirdAppService;

    @Autowired
    @Qualifier("mydefaultKaptcha")
    Producer producer ;

    @PostMapping("/checkMyUser")
    @ResponseBody
    public ResultSet<String> checkMyUser(@RequestBody Map<Object,Object> map ){
        map=(Map<Object, Object>) map.get("data");
        String userEmail=(String) map.get("userEmail");
        String password=(String) map.get("password");
        String rememberMe=String.valueOf( map.get("rememberMe"));
        String inputkactpha=(String) map.get("inputkactpha");
        Subject subject= SecurityUtils.getSubject();

        System.out.println(userEmail+password+rememberMe+inputkactpha);
        AllUserToken token=new AllUserToken(userEmail,password,inputkactpha, UserType.ME);
        boolean rbm=rememberMe.equals("")?false:true;
        token.setRememberMe(rbm);
        try {
            subject.login(token);
            return new ResultSet(200,"登录成功", null);
        }catch (KaptchaErrorException e){
            return new ResultSet(200,"验证码错误", null);
        }catch (UnknownAccountException e){
            return new ResultSet(200,"用户不存在", null);
        }catch (IncorrectCredentialsException e){
            return new ResultSet(200,"密码错误", null);
        }

    }

    @GetMapping("/kactpha")
    @ResponseBody
    public String getkactpha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        HttpSession session = request.getSession();
        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码

        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        //SecurityUtils.getSubject(Constants.KAPTCHA_SESSION_KEY, text);
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        String base64string=java.util.Base64.getEncoder().encodeToString(baos.toByteArray());
        baos.close();
        return base64string;

    }

    @GetMapping("/qqappid")
    @ResponseBody
    public ResultSet<ThirdApp> getqqappid(){
        return  thirdAppService.doGetQQAppid();
    }

}
