package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/4 9:59
 *
 * @version 1.0
 */
public class PhantomReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        PhantomReference<String> pr = new PhantomReference<String>(new String("hello"), queue);
        System.out.println(queue.poll());
    }
}
