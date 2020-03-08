package conference.Contorller;

import conference.Utils.ResultSet;
import conference.services.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/11 21:19
 */
@Controller
public class RegisterPageCtrl {

    @Autowired
    MyUserService myUserService;

    @PostMapping("/insertMyUser")
    @ResponseBody
    public ResultSet<String> insertMyUser(@RequestBody Map<Object,Object> map){
        Map<Object,Object> map1=(Map<Object, Object>) map.get("senddata");
        String userEmail=(String)map1.get("userEmail");
        String realName=(String)map1.get("realName");
        String password=(String)map1.get("password");
        return  myUserService.doInsertMyUser(userEmail, realName, password);
    }
}

