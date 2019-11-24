package conference.DAO.Mapper;

import conference.DAO.ORM.Conference;
import conference.DAO.ORM.MyUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/6 20:39
 */
@Repository
public interface MyUserMapper extends BaseMapper<MyUser> {
    int insert(MyUser myUser);
    int insertMyConference(@Param("userEmail") String userEmail, @Param("conferenceName") String conferenceName,
						   @Param("orderId") String orderId, @Param("statue") String statue);
    MyUser selectByUserEmail(@Param("userEmail") String userEmail);
    MyUser getCheckMyUser(@Param("userEmail") String userEmail, @Param("passWord") String passWord);
    List<Conference> selectMyJoin(@Param("userEmail") String userEmail);
    int delete(@Param("id") int id);
    int update(MyUser myUser);
    int updateMyConference(@Param("orderId") String orderId, @Param("statue") String statue);
    MyUser findQQuser(@Param("realName") String realName, @Param("passWord") String passWord);
}
