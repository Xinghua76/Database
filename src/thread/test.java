package thread;


import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class test {

    private static final AtomicInteger countor = new AtomicInteger(0);

    public static void main (String[] args) throws InterruptedException {
        System.out.print((char)('a'+(0%4)));
    }

}
