package thread;

//写一个双线程轮流打印1-100
public class date_04_16_AlternatePrinting {
    private static int count = 1;
    private static final Object lock = new Object();
    private static boolean isThreadATurn = true;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (count > 100) break;
                    if (isThreadATurn) {
                        System.out.println("Thread A: " + count);
                        count++;
                        isThreadATurn = false;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread threadB = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    if (count > 100) break;
                    if (!isThreadATurn) {
                        System.out.println("Thread B: " + count);
                        count++;
                        isThreadATurn = true;
                        lock.notifyAll();
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        threadA.start();
        threadB.start();
    }
}
