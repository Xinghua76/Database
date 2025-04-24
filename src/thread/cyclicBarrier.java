package thread;


import java.util.concurrent.CyclicBarrier;

public class cyclicBarrier {

    public static void main(String[] args) throws Exception{

        CyclicBarrier cb = new CyclicBarrier(11);
        for (int i = 1; i <= 10; i++){
            String name = "task_" + i ;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("任务" + Thread.currentThread().getName() + "正在等待...");
                    try {
                        cb.await();
                    }catch (Exception e){
                        throw new RuntimeException(e);
                    }
                    }

            },name).start();
        }
        Thread.sleep(200);
        System.out.println("任务11还有5秒到来，其他任务先等等待....");
        Thread.sleep(5000);
        cb.await();
        System.out.println("主线程作为第11个线程一起运行");
    }
}
