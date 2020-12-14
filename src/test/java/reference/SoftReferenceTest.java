package reference;

import java.lang.ref.SoftReference;

/**
 * UTF-8
 * Created by czy  Time : 2020/11/4 9:32
 *
 * @version 1.0
 */
// 软引用内存不足时，才回收
public class SoftReferenceTest {
    public static void main(String[] args) {
        String ss = "hello";

        //这时"hello"有一个强引用， 还有一个软引用

        //泛型指的是软引用指向的类型

        //软引用是内存不足时，对象被回收

        SoftReference<String> soft = new SoftReference<String>(ss);

        //获取软引用的对象

        String content = soft.get();

        System.out.println(content);

        ss = null; //强引用没有了，这时只有软引用指向"hello"

        System.gc(); //强制回收

        System.gc();

        System.gc();

        content = soft.get();//看看有没有被回收
        System.out.println(content);
    }
}
