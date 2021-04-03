package concurrent;

/**
 * UTF-8
 * Created by czy  Time : 2021/3/12 21:11
 *
 * @version 1.0
 */

import java.util.concurrent.locks.LockSupport;

class SupportThread extends Thread {
    private Object object;

    public SupportThread(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before unpark");
        // 释放许可
        LockSupport.unpark((Thread) object);
        System.out.println("after unpark");
    }
}

public class TestLockSupport {
    public static void main(String[] args) {
        SupportThread myThread = new SupportThread(Thread.currentThread());
        myThread.start();
        try {
            // 主线程睡眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }
}
