/**
 * UTF-8
 * Created by czy  Time : 2021/3/16 15:00
 *
 * @version 1.0
 */
public class java8lambdaTest {
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("helllo world");
        }).start();
    }
}
