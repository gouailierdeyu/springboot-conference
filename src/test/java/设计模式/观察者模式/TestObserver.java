package 设计模式.观察者模式;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/21 10:39
 *
 * @version 1.0
 */
public class TestObserver implements Observer<Object>{

    @Override
    public  void update(Subject<Object> subject) {
        System.out.println("1收到 "+subject.getSubjectName()+" 的信息更新，请处理");
    }
}
