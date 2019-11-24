package conference;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * UTF-8
 * Created by CZY    Time : 2019/7/3 15:52
 */
@SpringBootApplication
@MapperScan("conference.DAO.Mapper")
@EnableTransactionManagement
public class ProStart {

    public static void main(String[] args) {
       SpringApplication.run(ProStart.class,args);
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