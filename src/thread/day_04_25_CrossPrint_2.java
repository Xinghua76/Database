package thread;
// 线程交叉打印12A34B56C，多种实现方式（一个打印数字，一个打印字母
//使用ReenTrantLock（） 和 Condition()

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class day_04_25_CrossPrint_2 {
    private static final Lock lock = new ReentrantLock();
    private static final Condition printNumberCondition = lock.newCondition(); 
       
    private static boolean printNumber = true;

}
