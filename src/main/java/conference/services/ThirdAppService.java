package conference.services;

import conference.DAO.Mapper.ThirdAppMapper;
import conference.DAO.ORM.ThirdApp;
import conference.Utils.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UTF-8
 * Created by CZY    Time : 2019/10/14 20:32
 */
@Service
public class ThirdAppService {
	@Autowired
	ThirdAppMapper thirdAppMapper;

	public ResultSet<ThirdApp> doGetQQAppid(){
		ThirdApp thirdApp=thirdAppMapper.getQQAppid();
		return new ResultSet<>(200, "ok", thirdApp);
	}

}
