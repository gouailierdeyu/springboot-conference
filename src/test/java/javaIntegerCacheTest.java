import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * UTF-8
 * Created by czy  Time : 2020/9/26 21:56
 *
 * @version 1.0
 */
public class javaIntegerCacheTest {
    public static void main(String[] args) {
        //设置VM options 为-Djava.lang.Integer.IntegerCache.high=666
        Integer a1=Integer.valueOf(650);
        Integer a2=Integer.valueOf(650);
        System.out.println(a1==a2); //true
        Integer a7=new Integer(650);
        Integer a6=new Integer(650);
        System.out.println(a6==a7); //true
        //不设置时返回false

        //不设置缓存  -128到127
        Integer a3=Integer.valueOf(-128);
        Integer a4=Integer.valueOf(-128);
        System.out.println(a3==a4);

        List<Integer> integers=new ArrayList();
        List<String> strings=new ArrayList();
        System.out.println(strings.getClass()==integers.getClass());

    }
}
