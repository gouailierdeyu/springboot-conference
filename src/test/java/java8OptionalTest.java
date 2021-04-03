
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;


/**
 * UTF-8
 * Created by czy  Time : 2020/2/5 19:24
 *
 * @version 1.0
 */
public class java8OptionalTest {

    @Test
    public void testOptional(){
        //Assert.assertEquals(Optional.of(66), Optional.of(33).map(i -> Optional.of(i * 2)));
        Optional<Integer> num = Optional.of(33);
        //map()是返回调用者类型
        //flatMap（）是参数类型必须和调用者类型相同

        Assertions.assertEquals(Optional.of(66), num.map(i -> i * 2));
        Assertions.assertEquals(Optional.of(66), Optional.of(33).flatMap(i -> Optional.of(i * 2)));
    }

}
