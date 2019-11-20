package conference.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * UTF-8
 * Created by CZY    Time : 2019/7/3 18:48
 */
//继承WebMvcConfigurationSupport会导致自动配置的webmvc失效
@Configuration
public class webadapter implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");

    }

}
