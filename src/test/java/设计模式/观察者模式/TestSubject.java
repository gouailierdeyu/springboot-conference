package 设计模式.观察者模式;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/21 10:42
 *
 * @version 1.0
 */

/**
 * 这里是不是可以用cglib或者jdk动态代理实现切面的notify?
 */
public class TestSubject extends Subject<Object>{
    @Override
    public Object getMes() {
        return this.mes;
    }

    @Override
    public void setMes(Object mes) {
        this.mes = mes;
        notifyAllObserver();
    }

    public TestSubject(String name) {
        super(name);
    }
}
