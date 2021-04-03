package conference;

import conference.service.MyUserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/9 13:03
 */

@SpringBootTest
public class Springtest {

    @Autowired
    MyUserService myUserService;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate<String,Object> objectTemplate;


    @BeforeEach
    public void willdo(){
        System.out.println("初始化工作");
    }

    @Test
    public void hello(){
       // Assert.assertEquals("用户不存在", myUserService.getCheckMyUser("aaa","bbb"));
      //  System.out.println( myUserService.getCheckMyUser("aaa","bbb"));
   		String s1="框架java";
   		String s2="框架";
		final  String s3="java";
		String s4=s2+s3;
		String s5="java";
		System.out.println(s1==s4);//false
		System.out.println(s5==s3);//true
    }

    // StringRedisTemplate 和 RedisTemplate<String,Object> 对同一个key操作时，出现问题？
    @Test
	public void testredis(){
		stringRedisTemplate.opsForValue().set("rao", "stringrao");
		System.out.println(stringRedisTemplate.opsForValue().get("rao"));
		objectTemplate.opsForValue().set("czy", "objectczy");
		objectTemplate.opsForValue().set("rao","objectrao");
		stringRedisTemplate.opsForValue().set("czy","stringczy");
		stringRedisTemplate.opsForList().leftPush("lst","sss");
		stringRedisTemplate.opsForList().leftPush("lst","eee");
		stringRedisTemplate.opsForList().rightPush("lst","wett");
		objectTemplate.opsForList().rightPush("lst","wsn");

    }

	@Test
	public void testgetFromRedis(){
		System.out.println(stringRedisTemplate.opsForValue().get("czy"));
		System.out.println(stringRedisTemplate.opsForValue().get("rao"));
		System.out.println(objectTemplate.opsForValue().get("czy"));
		System.out.println(objectTemplate.opsForValue().get("rao"));
	}

	@Test
	public void testdirs(){
		String savepath= null;
		try {
			savepath = ResourceUtils.getURL("classpath:").getPath();
			String serverFilePath =savepath+ "/static/upload/headImg/" + "userEmail";
			System.out.println(serverFilePath);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

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

	@Test
	public void javascheduletest(){
		System.out.println("hello world");
	}


    @AfterEach
    public void release(){
        System.out.println("善后工作");
    }
}
