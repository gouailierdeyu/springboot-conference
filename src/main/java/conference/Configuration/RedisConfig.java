package conference.Configuration;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * UTF-8
 * Created by CZY    Time : 2019/11/12 22:39
 */
@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
// 注意redistemplate 对 key 的序列化方式
// 和 StringRedisTemplate 的序列化方式不一样，
// StringRedisTemplate 是直接把 key 的 string 值作为key
public class RedisConfig {

	@Bean
	public RedisTemplate<String,Object> getRedisTemplate(RedisConnectionFactory factory){
		RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
		redisTemplate.setKeySerializer(RedisSerializer.string());
		redisTemplate.setValueSerializer(RedisSerializer.string());
		redisTemplate.setConnectionFactory(factory);
		return redisTemplate;
	}
}
