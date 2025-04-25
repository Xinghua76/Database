package thread;

// 线程交叉打印12A34B56C，多种实现方式（一个打印数字，一个打印字母
//使用wait()和notifyAll（）
public class day_04_25_CrossPrint_1 {
    private static final Object lock = new Object();
    private static boolean printNumber = true;
    public static void main(String[] args) {
        Thread printNumberThread = new Thread(() ->{
            for (int i = 1; i <= 52; i++){
                synchronized(lock){
                    while (!printNumber) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
    
                    System.out.print(i);
                    System.out.print(i + 1);
                    printNumber = false;
                    lock.notifyAll();
                }
            }
        });

        Thread printLetterThread = new Thread( () -> {
            for ( char c = 'A'; c <= 'Z'; c++){
                synchronized(lock){
                    while (printNumber) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
    
                    System.out.print(c);
                    printNumber = true;
                    lock.notifyAll();
                }
                
            }
        });

        printLetterThread.start();
        printNumberThread.start();


    }
}
