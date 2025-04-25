package thread;

public class day_04_18_AlternatePrintingThreeThreads {
    private int cur = 1;
    private final Object lock = new Object();
    int turn = 0;

    public static void main(String[] args) {
        day_04_18_AlternatePrintingThreeThreads ap = new day_04_18_AlternatePrintingThreeThreads();

        Thread p1 =new Thread(() -> ap.printNumbers(0));
        Thread p2 =new Thread(() -> ap.printNumbers(1));
        Thread p3 =new Thread(() -> ap.printNumbers(2));

        p1.start();
        p2.start();
        p3.start();
    }


    private void printNumbers(int turn){
        while (cur <= 100){
            synchronized (lock){
                while (cur % 3 != turn){
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }


                if(cur <= 100 ){
                    System.out.println("Printer"+ (turn % 3 + 1) + ": " + cur);
                    cur++;
                    turn = (turn + 1) % 3;
                    lock.notifyAll();
                }
            }
        }
    }
}
