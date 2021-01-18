package concurrent;

/**
 * UTF-8
 * Created by czy  Time : 2020/12/15 16:11
 *
 * @version 1.0
 */
public class testdeadlock {
    public static void main(String[] args) {
        new testdeadlock().deadLock();
    }

    private static String A = "A";
    private static String B = "B";

    private void deadLock() {
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("1");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (B) {
                synchronized (A) {
                    System.out.println("2");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
