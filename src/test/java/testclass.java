import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * UTF-8
 * Created by czy  Time : 2020/10/14 20:53
 *
 * @version 1.0
 */
public class testclass {

     int a=2;
    {
        a=4;
        System.out.println("这是非静态代码块");
        b=9;
    }
    static {
        System.out.println("这是静态代码块");
    }
     int b=2;
    {
        b=5;
        a=8;
    }
    public  testclass(){
        System.out.println(a);
        System.out.println(b);
        System.out.println("这是构造函数");
    }
    public int getval(){
        return 5;
    }
    public static void main(String[] args) throws Exception {
//        testclass test=new testclass();
        List anotherList = new ArrayList<>();
        boolean instanceTest = anotherList instanceof List<? >;
        System.out.println(instanceTest);
        List<Integer> li = Arrays.asList(1, 2, 3);
        printListWildCard(li);
    }
    public static void printListWildCard(List<? extends Object> list) {
        for (Object element: list) {
            System.out.print(element + " ");
        }
//        list.add(2);
    }
}
