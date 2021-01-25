package 设计模式.观察者模式;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/21 10:29
 *
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Subject<Object> sub = new TestSubject("测试目标");
        sub.attach(new TestObserver());
        sub.attach(new TestObserver2());
        sub.setMes(8);
    }
}
