package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithReentrantLock {

    private static final int BUFFER_SIZE = 10; // 缓冲区大小
    private static int count = 0; // 当前缓冲区的元素数量
    private static Object[] buffer = new Object[BUFFER_SIZE]; // 缓冲区数组
    private static int in = 0; // 下一个要放入缓冲区的实际位置
    private static int out = 0; // 下一个要取出缓冲区的实际位置
    private static final ReentrantLock lock = new ReentrantLock(); // 锁对象
    private static final Condition notFull = lock.newCondition(); // 用于生产者等待缓冲区不满时
    private static final Condition notEmpty = lock.newCondition(); // 用于消费者等待缓冲区不为空时

    // 生产者线程类
    static class Producer extends Thread {
        public void run() {
            for (int num = 0; num < 180; num++) { // 改正循环变量初始化和条件
                lock.lock();
                try {
                    while (count == BUFFER_SIZE) {
                        System.out.println("队列已满-生产者等待");
                        notFull.await(); // 等待缓冲区不满
                    }
                    // 生产数据
                    buffer[in] = num;
                    in = (in + 1) % BUFFER_SIZE;
                    count++;
                    System.out.println("生产数据-" + num + "|缓冲区元素数量-" + count);
                    notEmpty.signal(); // 唤醒消费者
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    // 消费者线程类
    static class Consumer extends Thread {
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (count == 0) { // 改正判断条件为0
                        System.out.println("队列为空-消费者等待");
                        notEmpty.await(); // 等待缓冲区不为空
                    }
                    // 消费数据
                    Object data = buffer[out];
                    out = (out + 1) % BUFFER_SIZE;
                    count--;
                    System.out.println("消费数据-" + data + "|缓冲区元素数量-" + count);
                    notFull.signal(); // 唤醒生产者
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    // 主方法启动生产者和消费者线程
    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        producer.start(); // 启动生产者线程
        consumer.start(); // 启动消费者线程
    }
}