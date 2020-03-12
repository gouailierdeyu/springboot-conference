package conference;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UTF-8
 * Created by czy  Time : 2020-03-11 13:05
 *
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlatformConfigTest {

    @Value("${platform.name}")
    String platformName;

    @Value("${platform.static.resources.path}")
    String platformPath;

    @Test
    public void testPlatform(){

        System.out.println(platformName+platformPath);

    }

}
