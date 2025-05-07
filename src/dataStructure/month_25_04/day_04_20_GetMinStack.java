package dataStructure.month_25_04;
import java.util.Stack;

// 最小栈
// 测试链接 : https://leetcode.cn/problems/min-stack/
public class day_04_20_GetMinStack {

    public class MinStack1{
        public Stack<Integer> data;
        public Stack<Integer> min;

        public MinStack1(){
            data = new Stack<Integer>();
            min = new Stack<Integer>();
        }

        public int getMin(){
            return min.peek();
        }


        public void push(int x){
            data.push(x);
            if(min.isEmpty() || x <= min.peek()){
                min.push(x);
            }else {
                min.push(min.peek());
            }
        }

        public int pop(){
            min.pop();
            return data.pop();
        }

        public int top(){
            return data.peek();
        }


    }


    public class MinStack2{
        public final int MAXN = 8001;

        public int[] data;
        public int[] min;
        public int size;

        public MinStack2(){
            data = new int[MAXN];
            min = new int[MAXN];
            size = 0;
        }

        public void push(int x){
            data[size] = x;
            if(size == 0 || x <= min[size - 1]){
                min[size] = x;
            }else {
                min[size] = min[size -1];
            }
            size++;
        }


        public int getMin(){
            return min[size - 1];
        }

        public void pop(){
            size--;
        }

        public int top(){
            return data[size-1];
        }

    }




}
