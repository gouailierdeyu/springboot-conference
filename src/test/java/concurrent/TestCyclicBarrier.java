package concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/22 17:50
 *
 * @version 1.0
 */

/**
 * CyclicBarrier类可以实现一组线程相互等待，当 所有线程 都到达某个屏障点（await()）后再进行后续的操作。
 * CyclicBarrier 循环屏障，可复用的
 * CyclicBarrier(int parties, Runnable barrierAction)
 * parties代表一起参与的线程数，barrierAction表示最后一个线程执行到await()之前要调用的线程。
 * 当一起参与的线程数都达到 await() 后，CyclicBarrier可以循环利用，重置为设置的parties,继续过程
 * 如设置为parties为1，如果有2个线程用了 await()，那么一个线程到 await，就直接通过屏障 执行完，之后，下一个线程再执行。
 * 如果调用 await() 的线程数量少于设置的 parties，那么程序会一直等待着，不能通过屏障。
 */
public class TestCyclicBarrier {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cb = new CyclicBarrier(3, new Thread("barrierAction") { //最后一个线程执行到await()之前要调用的线程。
            public void run() {
                System.out.println(Thread.currentThread().getName() + " barrier action");

            }
        });
        MyThread t1 = new MyThread("t1", cb);
        MyThread t2 = new MyThread("t2", cb);
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName() + " going to await");
        cb.await();
        System.out.println(Thread.currentThread().getName() + " continue");

    }
}


class MyThread extends Thread {
    private CyclicBarrier cb;
    public MyThread(String name, CyclicBarrier cb) {
        super(name);
        this.cb = cb;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " going to await");
        try {
            cb.await();
            System.out.println(Thread.currentThread().getName() + " continue");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
