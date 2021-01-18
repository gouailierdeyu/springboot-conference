/**
 * UTF-8
 * Created by czy  Time : 2021/1/18 16:18
 *
 * @version 1.0
 */
public class 测试类加载和初始化顺序 {
    public static void main(String[] args) {
        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
        StaticTest.staticFunction();
        System.out.println("sss\0sss".length());
    }
}

class StaticTest {
    static StaticTest st = new StaticTest();

    static {   //静态代码块
        System.out.println("1");
    }

    {       // 实例代码块
        System.out.println("2");
    }

    StaticTest() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }

    int a = 110;    // 实例变量
    static int b = 112;     // 静态变量
}

class SingleTon {
    private static SingleTon singleTon = new SingleTon();

    public static int count1;

    public static int count2 = 0;

    private SingleTon() {
        count1++;
        count2++;
    }
    public static SingleTon getInstance() {
        return singleTon;
    }
}

