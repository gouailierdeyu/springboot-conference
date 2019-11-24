package conference;

import conference.services.MyUserService;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.apache.tomcat.util.descriptor.web.MessageDestinationRef;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/9 13:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Springtest {

    @Autowired
    MyUserService myUserService;

	@Autowired
	StringRedisTemplate redisTemplate;

	@Autowired
	RedisTemplate<String,Object> template;

    @Before
    public void willdo(){
        System.out.println("初始化工作");
    }

    @Test
    public void hello(){
       /// Assert.assertEquals("用户不存在", myUserService.getCheckMyUser("aaa","bbb"));
       // System.out.println( myUserService.getCheckMyUser("aaa","bbb"));
   		String s1="框架java";
		final String s2="框架";
		final  String s3="java";
		String s4=s2+s3;
		System.out.println(s1==s4);


    }

    @Test
	public void testredis(){
		redisTemplate.opsForValue().set("rao", "2");
		System.out.println(redisTemplate.opsForValue().get("rao"));
		template.opsForValue().set("czy", 2);
		template.delete("czy");
		System.out.println(template.opsForValue().get("czy"));

	}
	@Test
	public void testjava(){
		Map<String,String> map=new HashMap<>();
		map.put("czy", "c");
		map.put("niuyi", "niu");
		map.put("wzl", "w");
		map.put("czy", "czy");
	//	Iterator<Map.Entry<String,String>> iter=   map.entrySet().iterator();
		Set<String> set=map.keySet();
		Iterator<String> iter=set.iterator();
		while (iter.hasNext()){
			iter.next();
			iter.remove();
		}
		while (iter.hasNext()){
			System.out.println(map.get(iter.next()));
		}
	}


    @After
    public void release(){
        System.out.println("善后工作");
    }
}
