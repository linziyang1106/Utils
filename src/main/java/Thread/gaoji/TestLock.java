package Thread.gaoji;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lin
 * @create 2020-10-06 14:42
 */

//测试Lock锁
public class TestLock {

    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();

        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }

}

class TestLock2 implements Runnable{

    int ticketNums = 10;

    private final ReentrantLock lock = new ReentrantLock();  //可重入锁

    public void run() {
        while (true){
            try {
                lock.lock(); //加锁
                if (ticketNums > 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNums--);
                }else{
                    break;
                }
            }finally {
                //解锁
                lock.unlock();
            }

        }
    }
}
