package thread;

import java.util.concurrent.CountDownLatch;

//使用join配合CountDownLatch
public class day_04_27_ThreadJoinDemo_1 {
    public static void main(String[] args) throws InterruptedException{
        CountDownLatch t1ToT2CountDownLatch = new CountDownLatch(1);
        CountDownLatch t2ToT3CountDownLatch = new CountDownLatch(1);

        Thread t1 = new Thread(() ->{
            System.out.println("T1开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T1执行结束");
            t1ToT2CountDownLatch.countDown();
        });

        Thread t2 = new Thread(() ->{
            try {
                t1ToT2CountDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2执行结束");
            t2ToT3CountDownLatch.countDown();
        });

        Thread t3 = new Thread(() ->{
            try {
                t2ToT3CountDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T3开始执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("T3执行结束");
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("全部任务执行完成");
    }
}
