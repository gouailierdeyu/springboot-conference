package reference;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/4 9:33
 *
 * @version 1.0
 */
// gc是优先级比较低的线程，发现弱引用即回收
public class WeakReferenceTest {
    public static void main(String[] args) throws Exception {
        WeakReference<String> sr = new WeakReference<String>(new String("hello"));
        System.out.println(sr.get());
        System.gc();                //通知JVM的gc进行垃圾回收
        System.out.println(sr.get());
        String ss = "hello";

        ReferenceQueue<String> queue = new ReferenceQueue<>();

        java.lang.ref.WeakReference<String> weak = new

                java.lang.ref.WeakReference<String>(ss,queue);

        System.out.println("现在的引用 " + weak.get());

        System.out.println(queue.poll());
        System.out.println(ss);
        ss = null;

        System.gc();    //gc
        System.gc();    //gc
        System.gc();    //gc
        System.gc();    //gc


        Thread.sleep(1000);

        Reference<? extends String> poll = queue.poll();    //如果为 null，说明被回收了



        if(poll != null) {

            String content = poll.get();

            System.out.println(content);

        }    //看看有没有被回收
    }
}
