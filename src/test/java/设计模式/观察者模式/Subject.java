package 设计模式.观察者模式;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/21 10:28
 *
 * @version 1.0
 */

import java.util.LinkedList;

/**
 * 目标，发出动作，可以有多个观察者接受消息
 */
public abstract class Subject<T> {
    LinkedList<Observer<T>> observers=new LinkedList<>();
    String subjectName;
    T mes;
    public Subject(String name){
        subjectName= name;
    }
    public void attach(Observer<T> observer){
        observers.add(observer);
    }

    public void detach(Observer<T> observer){
        observers.remove(observer);
    }

    public void notifyAllObserver(){
        for (Observer<T> observer : observers) {
            observer.update(this);
        }
    }

    public T getMes() {
        return mes;
    }

    public void setMes(T mes) {
        this.mes = mes;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
