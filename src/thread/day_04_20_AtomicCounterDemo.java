package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class day_04_20_AtomicCounterDemo {

    private static final AtomicInteger counter = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService excuter = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++){
            excuter.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++){
                        counter.incrementAndGet();
                    }
                }
            });
        }

        excuter.shutdown();
        excuter.awaitTermination(1, TimeUnit.HOURS);

        System.out.println("Final count :" + counter.get());
    }
}
