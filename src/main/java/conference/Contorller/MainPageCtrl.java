package conference.Contorller;

import conference.DAO.ORM.MyUser;
import conference.Utils.ResultSet;
import conference.services.ConferenceService;
import conference.services.MyUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/3 16:03
 */
@Controller
public class MainPageCtrl {
    @Autowired
    ConferenceService conferenceService;
    @Autowired
    MyUserService myUserService;

    @GetMapping("/")
    public String index (){
        return "view/index";
    }

    @GetMapping("/index")
    public String mainpage(){

        return "view/index";
    }


    @GetMapping("/conference/search")
    @ResponseBody
    public String search(){
        return "";
    }

    @GetMapping("/conference/edit")
    @ResponseBody
    public String editConference(){
        return "";
    }


    @GetMapping("/register")
    public String register(){
        return "view/register/register";
    }


    @GetMapping(value = "/login")
    public String login(){
        return "view/login/login";
    }

    @GetMapping(value = "/logout")
    @ResponseBody
    public String logout(){
        Subject currsubject= SecurityUtils.getSubject();
        if(currsubject.isAuthenticated() || currsubject.isRemembered()){
            currsubject.logout();
            return  "logout";
        }
        return "logoutfail";
    }


    @GetMapping(value = "/getMyUser")
    @ResponseBody
    public ResultSet<MyUser> getMyUser(String userEmail){
        
        return myUserService.doCheckMyUser(userEmail);
    }

    @GetMapping("/checkme")
    @ResponseBody
    public ResultSet<MyUser> checkrememberMe(){ //修改qq登录问题
            Subject currsubject= SecurityUtils.getSubject();
            if(currsubject.isAuthenticated() || currsubject.isRemembered()){
                    MyUser myUser=(MyUser) currsubject.getPrincipal();
                    return  new ResultSet(200,"ok",myUser) ;
            }


        return  new ResultSet(400,"用户不存在",null);
    }

    @GetMapping("/account")
    public String myinfo()
    {
        return "view/account/index";
    }


    @GetMapping("/account/myevent")
    @ResponseBody
    public String myevent(){
        return "";
    }


    @GetMapping("/conference/show")

    public String showConference(@RequestParam("conferencename") String conferenceName){

        return "view/map/map";
    }


    @GetMapping("/conference/getTopConferenceList")
    @ResponseBody
    public ResultSet getTopConferenceList(){
        return new ResultSet(0,null,conferenceService.getTopConferenceList());
    }

    @GetMapping("/conference/getMiddleConferenceList")
    @ResponseBody
    public ResultSet getMiddleConferenceList(){
        return new ResultSet(0,null,conferenceService.getMiddleConferenceList());
    }

    @GetMapping("/conference/getBottomConferenceList")
    @ResponseBody
    public ResultSet getBottomConferenceList(){

        return new ResultSet(200,null,conferenceService.getBottomConferenceList());
    }
}
