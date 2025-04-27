package thread;

//两个线程交替打印ABCD..Z字母，一个大写一个小写
//​目标输出：AbCdEfGhIjKlMnOpQrStUvWxYz
public class day_04_26_AlternatePrinting {
    private static final Object lock = new Object();
    private static char currentLetter = 'A';
    private static boolean printUpperCase = true;

    public static void main(String[] args) {
        Thread upperCasePrinter = new Thread(() -> printLetter(true));
        Thread lowerCasePrinter = new Thread(() -> printLetter(false));
        
        upperCasePrinter.start();
        lowerCasePrinter.start();
    }

    public static void printLetter(boolean isUpperCaseThread){
        while (currentLetter <= 'Z') {
            synchronized(lock){
                while (printUpperCase != isUpperCaseThread) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }   
                if (currentLetter > 'Z') {
                    break;
                }

                if (isUpperCaseThread) {
                    System.out.print((char)currentLetter);
                }else {
                    System.out.print(Character.toLowerCase((char)currentLetter));
                }

                printUpperCase = !printUpperCase;
                currentLetter++;

                lock.notifyAll();
            }
        }
    }
}
