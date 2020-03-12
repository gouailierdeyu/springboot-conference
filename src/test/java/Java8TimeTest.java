import com.baomidou.mybatisplus.core.toolkit.SystemClock;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

@RunWith(BlockJUnit4ClassRunner.class)
public class Java8TimeTest {



    @Test
    public void testDate(){
        LocalDateTime dateTime=LocalDateTime.now();
        LocalTime localTime=LocalTime.now();
        Clock clock=Clock.systemUTC();
        DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        System.out.println(dateTime.toString());
        System.out.println(format.format(dateTime));
        ZonedDateTime zonedDateTime=ZonedDateTime.now(ZoneId.of("GMT"));
        System.out.println(zonedDateTime);
        YearMonth yearMonth=YearMonth.now();
        System.out.println(yearMonth);


        System.out.println("执行毫秒："+(Clock.systemUTC().millis()-clock.millis()));
        System.out.println("执行纳秒："+(LocalTime.now().getNano()-localTime.getNano()));

    }
}
