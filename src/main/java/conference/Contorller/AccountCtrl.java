package conference.Contorller;

import conference.DAO.ORM.MyUser;
import conference.Utils.ResultSet;
import conference.service.MyUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * UTF-8
 * Created by CZY    Time : 2019/10/20 19:50
 */
@Controller
@RequestMapping("/account")
@Api(tags = "用户信息")
@PropertySource("classpath:platform.properties")
public class AccountCtrl {

	//private static final String midpath=File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+File.separator;


	private static final String startpath=File.separator+"var"+File.separator+"www"+File.separator+"html";
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


	@ApiOperation("用户信息修改")
	@PostMapping("/updateUser")
	@ResponseBody
	public ResultSet updateUser(String userEmail, String realName, String companyName, String job,
								@RequestParam(value = "headImgFile",required = false) MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response){

		File serverFile=null;
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
				// savepath= System.getProperty("user.dir")+midpath;
				File serverFileDir = new File(startpath,File.separator+"headImg"+File.separator+userEmail);

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

		String path=null;
		Subject currsubject= SecurityUtils.getSubject();
		if(currsubject.isAuthenticated() || currsubject.isRemembered()){
			MyUser myUser=(MyUser) currsubject.getPrincipal();
			myUser.setRealName(realName);
			myUser.setUserEmail(userEmail);
			myUser.setJob(job);
			myUser.setCompanyName(companyName);
			if (multipartFile!=null){
				path=serverFile.getAbsolutePath().replace(startpath,"");
				path=path.replace(File.separator,"/");
				path="http://47.107.236.226:8080"+path;
				//路径问题，wins和linux在\\和/有区别，存入何读取数据库要重新修改。
				myUser.setHeadImgUrl(path);
			}

			//修改
			myUserService.doUpdateMyUser(myUser);
			return new ResultSet(200, path, null);
		}
		return new ResultSet(500, "信息修改失败，请稍后再试", null);
	}




//	public ResultSet updateUser(String userEmail, String realName, String companyName, String job,
//								@RequestParam(value = "headImgFile",required = false) MultipartFile multipartFile, HttpServletRequest request, HttpServletResponse response){
//
//		File serverFile=null;
//		String savepath=null;
//		if (multipartFile!=null) {
//
//			if (multipartFile.isEmpty()) {
//				return new ResultSet(200, "上传文件失败1", null);
//			}
//			String contentType = multipartFile.getContentType();
//			String filetype = ".jpg";
//			switch (contentType) {
//				case "image/pjpeg":
//				case "image/jpeg": {
//					filetype = ".jpg";
//					break;
//				}
//				case "image/png": {
//					filetype = ".png";
//					break;
//				}
//				case "image/x-png": {
//					filetype = ".bmp";
//					break;
//				}
//				default:
//					filetype = ".jpg";
//			}
//			String filename = "header" + filetype;//上传路径不对
//			try { //还是有问题会到target目录里面
//				// savepath= System.getProperty("user.dir")+midpath;
//				savepath="E:"+File.separator;
//				File serverFileDir = new File(savepath,"upload"+File.separator+"headImg"+File.separator+userEmail);
//
//				if (!serverFileDir.exists()) {
//					serverFileDir.mkdirs();
//
//				}
//				if (serverFileDir.isDirectory()) {
//					File[] files = serverFileDir.listFiles();
//					for (File f : files) {
//						f.delete();
//					}
//
//				}
//
//				serverFile = new File(serverFileDir.getPath(), filename);
//				Files.copy(multipartFile.getInputStream(), serverFile.toPath());
//			} catch (IOException e) {
//				return new ResultSet(200, e.getMessage(), null);
//			}
//		}
//
//		Subject currsubject= SecurityUtils.getSubject();
//		if(currsubject.isAuthenticated() || currsubject.isRemembered()){
//			MyUser myUser=(MyUser) currsubject.getPrincipal();
//			myUser.setRealName(realName);
//			myUser.setUserEmail(userEmail);
//			myUser.setJob(job);
//			myUser.setCompanyName(companyName);
//			if (multipartFile!=null){
//				String path=serverFile.getAbsolutePath().replace(savepath,"");
//				path=path.replace(File.separator,"/");
//				path="http://localhost:8090/"+path;
//				//路径问题，wins和linux在\\和/有区别，存入何读取数据库要重新修改。
//				myUser.setHeadImgUrl(path);
//			}
//
//
//			//修改
//			myUserService.doUpdateMyUser(myUser);
//		}
//		return new ResultSet(200, "信息已保存", null);
//	}
}
