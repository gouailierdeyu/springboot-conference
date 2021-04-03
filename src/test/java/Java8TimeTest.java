
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;

public class Java8TimeTest {
    @Test
    public void testDate(){
        LocalDateTime dateTime=LocalDateTime.now();
        LocalTime localTime=LocalTime.now();
        Clock clock=Clock.systemUTC();//标准时间
        DateTimeFormatter format=DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        System.out.println(dateTime.toString());
        System.out.println(format.format(dateTime));
        ZonedDateTime zonedDateTime=ZonedDateTime.now(ZoneId.of("GMT"));//标准时间
        System.out.println(zonedDateTime);
        YearMonth yearMonth=YearMonth.now();
        System.out.println(yearMonth);


        System.out.println("执行毫秒："+(Clock.systemUTC().millis()-clock.millis()));
        System.out.println("执行纳秒："+(LocalTime.now().getNano()-localTime.getNano()));

    }

    @Test
    public void testweek(){
        LocalDate localDate=LocalDate.of(2020,12,31);
        System.out.println(localDate.getDayOfWeek());

        LocalDate enddate=localDate.plusDays(1);
        System.out.println(enddate);
        System.out.println(enddate.getDayOfWeek());
    }
}
