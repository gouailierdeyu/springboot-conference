package conference.services;

import conference.DAO.Mapper.ConferenceMapper;
import conference.DAO.ORM.Conference;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/5 19:06
 */
@Service
public class ConferenceService {
    @Autowired
    ConferenceMapper conferenceMapper;

    public  List<Conference> getMiddleConferenceList(){
        return conferenceMapper.selectList(new QueryWrapper<Conference>().eq("myshow", 1).orderByDesc("top_index").last("limit 5,8").lambda());

    }


    public  List<Conference> getBottomConferenceList(){
        return conferenceMapper.selectList(new QueryWrapper<Conference>().eq("myshow", 1).orderByDesc("update_time").last("limit 6").lambda());

    }

    public  List<Conference> getTopConferenceList(){
        return conferenceMapper.selectList(new QueryWrapper<Conference>().eq("myshow", 1).orderByDesc("top_index").last("limit 0,5").lambda());

    }

}
//myshow = 1 ORDER BY top_index DESC LIMIT 5, 8;myshow = 1 ORDER BY update_time DESC LIMIT 6;
