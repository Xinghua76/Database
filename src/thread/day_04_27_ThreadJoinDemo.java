package thread;

//假设有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
public class day_04_27_ThreadJoinDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task("T1"),"T1");
        Thread t2 = new Thread(new Task("T2"),"T2");
        Thread t3 = new Thread(new Task("T3"),"T3");

        t1.start();

        try {
            t1.join();
            t2.start();
            t2.join();
            t3.start();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("全部任务执行完毕");
    }


    static class Task implements Runnable{
        private String name;
        
        public Task(String name) {
            this.name = name;
        }
        @Override
        public void run(){
            System.out.println(name +"任务开始执行");
            try {
                Thread.sleep((long)(Math.random() * 10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + "任务执行完毕");
        }
    }
}
