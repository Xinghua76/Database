package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;


// 随机快速排序，acm练习风格
// 测试链接 : https://www.luogu.com.cn/problem/P1177
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过
public class day_04_26_QuickSort {
    public static int MAX = 100001;
    public static int[] arr = new int[MAX];
    public static int n;
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = (int)in.nval;
        for (int i = 0; i < n; i++){
            in.nextToken();
            arr[i] = (int)in.nval;
        }

        for (int i = 0; i < n - 1; i++){
            out.print(arr[i] + " ");
        }
        out.print(arr[n - 1]);
        out.flush();
        out.close();
        br.close();
    }
    
    // 随机快速排序经典版(不推荐)
	// 甚至在洛谷上测试因为递归开太多层会爆栈导致出错
    public static void quickSort1 (int l, int r){
        // l == r，只有一个数
		// l > r，范围不存在，不用管
        if (l >= r) {
            return;
        }
        // 随机这一下，常数时间比较大
		// 但只有这一下随机，才能在概率上把快速排序的时间复杂度收敛到O(n * logn)
        int x = arr[l + (int)(Math.random() * (r - l + 1))];
        int a = partition1(l, r, x);
        quickSort1(l, a - 1);
        quickSort1(a + 1, r);

    }

    // 已知arr[l....r]范围上一定有x这个值
	// 划分数组 <=x放左边，>x放右边
	// 并且确保划分完成后<=x区域的最后一个数字是x
    public static int partition1(int l, int r, int x){
        int a = l;
        int xi = 0;//返回下标
        for (int i = l; i <= n; i++){
            if (arr[i] <= x) {
                Swap(i,a);
                if (arr[i] == x) {
                    xi = a;
                }
            }
        }
        Swap(a - 1, xi);
        return a - 1;

    }

    public static void Swap(int a, int b){
        int temp;
        temp = arr[a];
        arr[a] =arr[b];
        arr[b] = temp;
    }
    
    // 随机快速排序改进版(推荐)
	// 可以通过所有测试用例
    public static int first,last;

    public static void quickSort2(int l, int r){
        if (l >= r) {
            return;
        }

        int x = arr[l + (int)(Math.random() * (r - l + 1))];
        partition2(l, r, x);
        // 为了防止底层的递归过程覆盖全局变量
		// 这里用临时变量记录first、last
        int left = first;
        int right = last;
        quickSort1(l, left - 1);
        quickSort2(right, r);
    }

    public static void partition2(int l, int r, int x){
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] == x) {
                i++;
            }else if (arr[i] < x) {
                Swap(i++, first++);
            }else {
                Swap(i, last--);
            }
        }
    }
}
