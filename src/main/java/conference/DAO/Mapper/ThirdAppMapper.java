package conference.DAO.Mapper;

import conference.DAO.ORM.ThirdApp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * UTF-8
 * Created by CZY    Time : 2019/10/14 20:26
 */
@Repository
public interface ThirdAppMapper extends BaseMapper {

	ThirdApp getQQAppid();

}
