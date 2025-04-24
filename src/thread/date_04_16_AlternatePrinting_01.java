package thread;




public class date_04_16_AlternatePrinting_01 {
    private int currentNumber = 1;//当前要打印的数字
    private final Object lock = new Object();//用于同步的锁对象

    public static void main(String[] args) {
        date_04_16_AlternatePrinting_01 ap = new date_04_16_AlternatePrinting_01();

        Thread oddPrinter = new Thread(() -> ap.printNumbers(true));//创建奇数打印线程，并启动
        oddPrinter.start();

        Thread evenPrinter = new Thread(() -> ap.printNumbers(false));//创建偶数数打印线程，并启动
        evenPrinter.start();
    }

    private void printNumbers(boolean isOdd){
        while (currentNumber <= 100){
            synchronized (lock){
                while ((isOdd && currentNumber % 2 == 0) || (!isOdd && currentNumber % 2 == 1)){
                    try {
                        lock.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }

                if (currentNumber <= 100){
                    System.out.println("Printer" + (isOdd ? "Odd" : "Even") + ":" + currentNumber);
                    currentNumber++;
                    lock.notifyAll();
                }
            }
        }
    }


}
