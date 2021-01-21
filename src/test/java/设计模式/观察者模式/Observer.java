package 设计模式.观察者模式;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/21 10:28
 *
 * @version 1.0
 */
public interface Observer {

    <T> void update(Subject<T> subject) ;
}
