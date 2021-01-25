package conference.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/21 15:42
 *
 * @version 1.0
 */
@Configuration
@EnableAsync
public class ThreadPoolConfig {
    @Bean("messagePool")
    public Executor getExecutorA(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(6);
        executor.setQueueCapacity(10);
        executor.initialize();
        return executor;//返回ThreadPoolTaskExecutor被spring容器管理
    }
}
