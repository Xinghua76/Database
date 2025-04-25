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
        ExecutorService executer = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++){
            executer.submit(new Runnable(){
                @Override
                public void run(){
                    for (int j = 0; j <100; j++){
                        countor.incrementAndGet();
                    }
                }
            });
        }
        
        // 关闭线程池
        // 关闭线程池，等待所有任务完成
        executer.shutdown();
        executer.awaitTermination(1,TimeUnit.HOURS);
        System.out.println(countor.get());
    }

}
