package conference;

import com.alipay.api.domain.Pair;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/3 15:52
 */
@SpringBootApplication
@MapperScan("conference.DAO.Mapper")
@EnableTransactionManagement
@EnableScheduling
public class ProStart {
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(ProStart.class,args);
        DriverManager.setLogWriter(new PrintWriter(System.out));
        DriverManager.getConnection("jdbc:postgresql://159.75.52.204:5432/conference","root","20155609");
//        Jedis jedis = new Jedis("localhost");
//        System.out.println("连接成功");
//        //设置 redis 字符串数据
//        jedis.set("runoobkey", "www.runoob.com");
//        // 获取存储的数据并输出
//        System.out.println("redis 存储的字符串为: "+ jedis.get("runoobkey"));
      //  Father father=new Sun();
//        System.out.println("dfhvdhv");
//        Sun sun=new Sun();
    }
}
//
//class Sun extends Father {
//
//static {
//    System.err.println("sun");
//}
//
//
//
//public  Sun() {
//        System. out.println("sun1");// #FX#tËẞ]
//    }
//
//
//
//public static void fun(){
//    System.err.println(" 儿子有趣 ");
//}
//
//
//}
//class  Father {
//
//    static {
//        System.err.println("Father");
//    }
//
//
//
//    public  Father() {
//        System. out.println("Father1");// #FX#tËẞ]
//    }
//
//
//
//    public static void fun(){
//        System.err.println(" 父亲有趣 ");
//    }
//
//
//}
