package conference.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/15 16:25
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    @Bean
    public PaginationInterceptor getPaginationInterceptor(){
        return new PaginationInterceptor();
    }
}
