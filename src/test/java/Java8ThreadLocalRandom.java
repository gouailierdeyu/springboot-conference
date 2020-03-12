import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.concurrent.ThreadLocalRandom;

/**
 * UTF-8
 * Created by czy  Time : 2020/2/20 17:15
 *
 * @version 1.0
 */
//@RunWith(BlockJUnit4ClassRunner.class)
public class Java8ThreadLocalRandom {

    static  ThreadLocalRandom random=ThreadLocalRandom.current();

    //这里不会生成一样的随机数


    //@Test
    //public void testThreadLocalRandom1(){
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {

                // TODO Auto-generated method stub
                System.out.println(ThreadLocalRandom.current().nextInt(20));

                }

        });
        t.start();
        }

    }


    //这里会生成一样的随机数
    //@Test
    //public static void main(String[] args) {
    public void testThreadLocalRandom2(){
        for (int i = 0; i <10 ; i++) {
        Thread t= new Thread(new Runnable() {
                @Override
                public void run() {

                   // try {
                        //Thread.sleep(1000);
                    // TODO Auto-generated method stub
                    System.out.println(random.nextInt(20));

                   // } catch (InterruptedException e) {
                    //    e.printStackTrace();
                   // }
                    }

            });
        t.start();
        }
    }
}
