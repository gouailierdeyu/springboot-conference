package conference.Contorller;

import conference.Utils.ResultSet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * UTF-8
 * Created by czy  Time : 2020-06-15 16:04
 *
 * @version 1.0
 */
@Controller
@Api(tags = "权限测试")
public class AuthorCtrl {

    @GetMapping("/html/admin")
    @ApiOperation("管理员权限")
    @ResponseBody
    public ResultSet<String> getAdmin(){
        return new ResultSet(200,"管理员操作", null);
    }

}
