package conference.services;

import conference.DAO.Mapper.MyUserMapper;
import conference.DAO.ORM.MyUser;
import conference.Utils.ResultSet;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/6 20:45
 */
@Service
@Transactional
public class MyUserService {

    @Autowired
    MyUserMapper myUserMapper;

    public MyUserMapper getMyUserMapper() {
        return myUserMapper;
    }

    public void setMyUserMapper(MyUserMapper myUserMapper) {
        this.myUserMapper = myUserMapper;
    }

    public MyUser getCheckMyUser(String useremail, String password){
            return myUserMapper.getCheckMyUser(useremail,password);
    }

    public MyUser doGetUserByName(String useremail){
        return myUserMapper.selectByUserEmail(useremail);
    }

    public ResultSet<MyUser> doCheckMyUser(String useremail ){
        MyUser myUser1=myUserMapper.selectByUserEmail(useremail);
        if(myUser1==null){
            return new ResultSet(200,"用户不存在",null);
        }else {

                return  new ResultSet(200,null, myUser1);
        }
    }

    public ResultSet<String> doInsertMyUser(String userEmail, String realName, String password)   {
        SimpleHash simpleHash=new SimpleHash("MD5",password);
        String hashpassword=simpleHash.toHex();
        try {
           int s= myUserMapper.insert(new MyUser(userEmail,realName,hashpassword));
        }catch (Exception ex){
          return  new ResultSet(400,"邮箱重复","");
        }
        return new ResultSet(200,"注册成功","");
    }

    public ResultSet<String> doInsertQQUser(String userEmail, String realName, String password,String headImgUrl)   {
        SimpleHash simpleHash=new SimpleHash("MD5",password);
        String hashpassword=simpleHash.toHex();
        try {
            MyUser myUser=new MyUser(userEmail,realName,hashpassword);
            myUser.setHeadImgUrl(headImgUrl);
            int s= myUserMapper.insert(myUser);
        }catch (Exception ex){
            return  new ResultSet(400,"邮箱重复","");
        }
        return new ResultSet(200,"注册成功","");
    }
    public int doFindQQuser(String realName,String password){
        SimpleHash simpleHash=new SimpleHash("MD5",password);
        String hashpassword=simpleHash.toHex();
        if(myUserMapper.findQQuser(realName, hashpassword)!=null){
            return 1;
        }else {
            return 0;
        }
    }

    public MyUser doGetQQUser(String name,String openid){
        SimpleHash simpleHash=new SimpleHash("MD5",openid);
        String hashpassword=simpleHash.toHex();
               MyUser user=myUserMapper.findQQuser(name,hashpassword);
               return user;

    }


}
