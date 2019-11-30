package conference.Contorller;

import conference.DAO.ORM.MyUser;
import conference.Utils.ResultSet;
import conference.services.MyUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * UTF-8
 * Created by CZY    Time : 2019/10/20 19:50
 */
@Controller
@RequestMapping("/account")
public class AccountCtrl {

	public static final String midpath="\\src\\main\\resources\\static\\";
	@Autowired
	MyUserService myUserService;
	@GetMapping("/index")
	public String account(){
		return "view/account/index";
	}

	@GetMapping("/event")
	public String event(){
		return "view/account/index";
	}

	@PostMapping("updateUser")
	@ResponseBody
	public ResultSet updateUser(String userEmail, String realName, String companyName, String job,
								@RequestParam(value = "headImgFile",required = false) MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response){

		File serverFile=null;
		String savepath=null;
		if (multipartFile!=null) {

			if (multipartFile.isEmpty()) {
				return new ResultSet(200, "上传文件失败1", null);
			}
			String contentType = multipartFile.getContentType();
			String filetype = ".jpg";
			switch (contentType) {
				case "image/pjpeg":
				case "image/jpeg": {
					filetype = ".jpg";
					break;
				}
				case "image/png": {
					filetype = ".png";
					break;
				}
				case "image/x-png": {
					filetype = ".bmp";
					break;
				}
				default:
					filetype = ".jpg";
			}
			String filename = "header" + filetype;//上传路径不对
			try { //还是有问题会到target目录里面
				 savepath= System.getProperty("user.dir")+midpath;
				File serverFileDir = new File(savepath,"upload\\headImg\\"+userEmail);
			   if (!serverFileDir.exists()) {
			   		serverFileDir.mkdirs();
			   }
				if (serverFileDir.isDirectory()) {
					File[] files = serverFileDir.listFiles();
					for (File f : files) {
						f.delete();
					}
				}

			   serverFile = new File(serverFileDir.getPath(), filename);
			   Files.copy(multipartFile.getInputStream(), serverFile.toPath());
			} catch (IOException e) {
				return new ResultSet(200, e.getMessage(), null);
			}
		}
		Subject currsubject= SecurityUtils.getSubject();
		if(currsubject.isAuthenticated() || currsubject.isRemembered()){
			MyUser myUser=(MyUser) currsubject.getPrincipal();
			myUser.setRealName(realName);
			myUser.setUserEmail(userEmail);
			myUser.setJob(job);
			myUser.setCompanyName(companyName);
			if (multipartFile!=null){
				String path=serverFile.getAbsolutePath().replace(savepath,"");
				myUser.setHeadImgUrl(path);
			}

			System.out.println(myUser);
			myUserService.doUpdateMyUser(myUser);//修改
		}
		return new ResultSet(200, "上传文件成功", null);
	}
}
