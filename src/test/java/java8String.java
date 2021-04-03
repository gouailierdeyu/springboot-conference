
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * UTF-8
 * Created by czy  Time : 2020/2/11 17:48
 *
 * @version 1.0
 */
public class java8String {

    @Test
    public void main1() {
        String str1 = "what";
        String str2 = str1 + " a nice day";
        System.out.println("what a nice day".equals(str2));
        System.out.println("what a nice day" == str2);
        Class<?> class1=new ArrayList<String>().getClass();
        Class<?> class2=new ArrayList<Integer>().getClass();
        System.out.println(class1);		//class java.util.ArrayList
        System.out.println(class2);		//class java.util.ArrayList
        System.out.println(class1==class2);	//true

    }
    /**
     * 以下程序输出的结果是什么？
     * */
    @Test
    public  void main2() {
        String str1 = "what a nice day";
        String str2 = new String("what a nice day");
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);
    }
    /**
     * 以下程序输出的结果是什么？
     * */

    @Test
    public  void main3() {
        String str1 = "what";
        String str2 = str1.concat(" a nice day");
        System.out.println("what a nice day".equals(str2));
        System.out.println("what a nice day" == str2);
        System.out.println("what a nice day"==str2.intern());
    }
}
