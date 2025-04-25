package thread;

public class day_04_20_SequentialPrinting {
    private int count = 0;
    private final Object lock = new Object();


    public static void main(String[] args) {
        day_04_20_SequentialPrinting sp = new day_04_20_SequentialPrinting();

        Thread threadA = new Thread(() -> sp.printNumbers(1),"A");
        Thread threadB = new Thread(() -> sp.printNumbers(2),"B");
        Thread threadC = new Thread(() -> sp.printNumbers(3),"C");

        threadA.start();
        threadB.start();
        threadC.start();
    }

    private void printNumbers(int number){
        for (int i = 0; i <10; i++){
            synchronized (lock){
                while (count % 3 != number - 1){
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }

                if (count < 30){
                    System.out.println("Thread" + Thread.currentThread().getName() + " printed: " + number);
                    count++;
                    lock.notifyAll();
                }
            }
        }
    }
}
