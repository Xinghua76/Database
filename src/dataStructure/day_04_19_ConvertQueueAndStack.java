package dataStructure;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 用栈实现队列
// 用队列实现栈
public class day_04_19_ConvertQueueAndStack {

    // 测试链接 : https://leetcode.cn/problems/implement-queue-using-stacks/
    class MyQueue{
        public Stack<Integer> in;
        public Stack<Integer> out;

        public MyQueue(){
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }

        public void inToOut(){
            while (out.isEmpty()){
                while (!in.isEmpty()){
                    out.push(in.peek());
                }
            }
        }

        public void push(int x){
            in.push(x);
            inToOut();

        }

        public int pop(){
            inToOut();
            return out.pop();
        }
        public int peek(){
            inToOut();
            return out.peek();
        }


        public boolean isEmpty(){
            return in.isEmpty() && out.isEmpty();
        }


    }

    // 测试链接 : https://leetcode.cn/problems/implement-stack-using-queues/
    class Myqueue{
        public Queue<Integer> queue;

        public Myqueue(){
            queue = new LinkedList<>();
        }

        public void push(int x){
            int n = queue.size();
            queue.offer(x);
            for(int i = 0; i < n; i++){
                queue.offer(queue.poll());
            }
        }

        public int pop(){
            return queue.poll();
        }

        public int top(){
            return queue.peek();
        }

        public boolean isEmpty(){
            return queue.isEmpty();
        }

    }

}
