package thread;
// 线程交叉打印12A34B56C，多种实现方式（一个打印数字，一个打印字母
//使用ReenTrantLock（） 和 Condition()

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class day_04_25_CrossPrint_2 {
    private static final Lock lock = new ReentrantLock();
    private static final Condition printNumberCondition = lock.newCondition(); 
    private static final Condition printLetterCondition = lock.newCondition();
    private static boolean printNumber = true;

    public static void main(String[] args) {
        Thread printNumberThread = new Thread(() -> {
            lock.lock();
            try {
                for (int i = 1; i <= 52; i++){
                    while (!printNumber) {
                        printNumberCondition.await();
                    }
                    System.out.print(i);
                    System.out.print(i + 1);
                    printNumber = false;
                    printLetterCondition.signal();
                    
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }finally {
                lock.unlock();
            }
        });
        Thread printLetterThread = new Thread(() -> {
            lock.lock();
            try {
                for (char c = 'A'; c <= 'Z'; c++){
                    while (printNumber) {
                        printLetterCondition.await();
                    }
                    System.out.print(c);
                    printNumber = true;
                    printNumberCondition.signal();
                    
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }finally {
                lock.unlock();
            }
        });


        printLetterThread.start();
        printNumberThread.start();

    }

}
