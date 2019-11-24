package conference.Contorller;

import conference.Configuration.AllUserToken;
import conference.Configuration.UserType;
import conference.services.MyUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * UTF-8
 * Created by CZY    Time : 2019/9/28 18:41
 */
@Controller
@RequestMapping("/user")
public class QQLoginCtrl {

    @Autowired
    MyUserService myUserService;

    @GetMapping("/qqlogin")
    public void qqlogin(HttpServletRequest request, HttpServletResponse response) throws Exception{
        // QQ登录有点特殊，参数放在#后面，后台无法获取#后面的参数，只能用JS做中间转换
        String html =   "<!DOCTYPE html>" +
                "<html lang=\"zh-cn\">" +
                "<head>" +
                "   <title></title>" +
                "   <meta charset=\"utf-8\"/>" +
                "</head>" +
                "<body>" +
                "   <script type=\"text/javascript\">" +
                "   window.location.href = '/user/qqlogining?'+window.location.hash.replace('#', '');" +
                "   </script>" +
                "</body>" +
                "</html>";
        response.getWriter().print(html);

    }

    @GetMapping("/qqlogining")
    public String qqlogining(String access_token,String expires_in,String state,HttpServletRequest request) throws Exception{
        URL url=new URL("https://graph.qq.com/oauth2.0/me?access_token=" + access_token);
        HttpsURLConnection connection=(HttpsURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.connect();
        if (connection.getResponseCode()==200){
            InputStream inputStream=connection.getInputStream();
            InputStreamReader is = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(is);
            StringBuffer strBuffer = new StringBuffer();
            String line = null;
            while (null!=(line = bufferedReader.readLine()))  {
                strBuffer.append(line);
            }
            String result = strBuffer.toString();
            is.close();
            connection.disconnect();
            result=result.replaceAll("callback","");
            result=result.replaceAll(";", "");
            result=result.replaceAll("\\(","");
            result=result.replaceAll("\\)","");
            result=result.trim();
            System.out.println(result);
            JSONObject  jsonObject=new JSONObject(result);
            String client_id=jsonObject.getString("client_id");
            String openid=jsonObject.getString("openid");
            URL url1=new URL("https://graph.qq.com/user/get_user_info?access_token="+access_token+"&oauth_consumer_key="+client_id+"&openid="+openid);
            HttpsURLConnection connection1=(HttpsURLConnection)url1.openConnection();
            connection1.setRequestMethod("GET");
            connection1.setConnectTimeout(5000);
            connection1.connect();
            if (connection1.getResponseCode()==200) {
                InputStream inputStream1 = connection1.getInputStream();
                InputStreamReader is1 = new InputStreamReader(inputStream1);
                BufferedReader bufferedReader1 = new BufferedReader(is1);
                StringBuffer strBuffer1 = new StringBuffer();
                String line1 = null;
                while (null != (line1 = bufferedReader1.readLine())) {
                    strBuffer1.append(line1);
                }
                String result1 = strBuffer1.toString();
                is1.close();
                connection1.disconnect();
                JSONObject jsonObject1 = new JSONObject(result1);
                if(jsonObject1.getInt("ret")==0){
                    String name=jsonObject1.getString("nickname");
                    String figureurl_qq_1=jsonObject1.getString("figureurl_qq_1");
                    if(myUserService.doFindQQuser(name, openid)==0){ //这里存入数据库
                        myUserService.doInsertQQUser(" ", name, openid,figureurl_qq_1);
                    }
                    System.out.println(name+figureurl_qq_1);
                    AllUserToken token=new AllUserToken(name, openid, UserType.QQ);
                    Subject subject= SecurityUtils.getSubject();
                    subject.login(token);
                    return "redirect:/index";
                }
            }
        }
        return  "redirect:/index";

    }
}
