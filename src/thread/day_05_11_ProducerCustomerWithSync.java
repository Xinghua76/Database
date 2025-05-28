package thread;

public class day_05_11_ProducerCustomerWithSync {
    //缓冲区大小
    private static int BUFFER_SIZE  = 50;
    //缓冲区数组
    private static Object[] buffer = new Object[BUFFER_SIZE];
    //缓冲区元素计数
    private static int count = BUFFER_SIZE;
    //下个要放入元素的位置
    private static int in = 0;
    //下个要去出元素的位置
    private static int out = 0;
    //用于同步的锁对象
    private static final Object lock = new Object();

    //生产者类
    static class Producer extends Thread{
        public void run(){
            while (true) {
                synchronized(lock){
                    while (count == BUFFER_SIZE){
                        try {
                            System.out.println("队列已满-生产者等待########");
                            lock.wait();
                        } catch (Exception e) {
                            Thread.currentThread().interrupt();//回复中断状态
                        }
                    }

                    buffer[in] = count;
                    in = (in + 1) % BUFFER_SIZE;
                    count++;
                    System.out.println("生产者生产"+ count + "|缓冲区元素" + count);
                    lock.notify();
                }
            }
        }
    }


    static class Customer extends Thread{
        public void run(){
            while (true) {
                synchronized(lock){
                    while (count == 0) {
                        try {
                            System.out.println("消费者阻塞，缓冲区为空############");
                            lock.wait();
                        } catch (Exception e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    buffer[out] = 0;
                    out = (out + 1) % BUFFER_SIZE;
                    count--;
                    System.out.println("消费者消费："+ out + "剩余元素数量" + count);
                    lock.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        Customer customer = new Customer();

        producer.start();
        customer.start();
    }

}
