package thread;

//两个线程，一个打印abcd，一个打印1234，需求交替打印出 a1b2c3d4a1b2c3d4 ； 打印10轮
public class day_04_27_AlternatePrinting_1 {
    private static final Object lock = new Object();
    private static boolean printLetter = true;
    private static int round = 0;
    
    public static void main(String[] args) {
        Thread printLettersThread = new Thread(() ->{
            for (int i = 0; i < 40; i++){
                synchronized (lock){
                    while (!printLetter) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if (round > 10) {
                        break;
                    }

                    System.out.print((char)('a'+ i%4));
                    printLetter = false;
                    round = i / 4 + 1;
                    lock.notifyAll();
                }
            }
        });

        Thread pirntNumbersThread = new Thread(() ->{
            for ( int i = 0; i <= 40; i++){
                synchronized (lock){
                    while (printLetter) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
    
                    if (round > 10) {
                        break;
                    }
    
                    System.out.print(i % 4 + 1);
                    printLetter =true;
                    lock.notifyAll();
                }
            }
        });


        printLettersThread.start();
        pirntNumbersThread.start();
    }
    
}
