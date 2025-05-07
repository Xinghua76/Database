package dataStructure.month_25_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

// 堆结构和堆排序，acm练习风格
// 测试链接 : https://www.luogu.com.cn/problem/P1177
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过
public class day_04_29_HeapSort {
    public static int MAX = 100001;
    public static int[] arr = new int[MAX];
    public static int n;
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		n = (int) in.nval;
		for (int i = 0; i < n; i++) {
			in.nextToken();
			arr[i] = (int) in.nval;
		}
		// heapSort1();
		heapSort2();
		for (int i = 0; i < n - 1; i++) {
			out.print(arr[i] + " ");
		}
		out.println(arr[n - 1]);
		out.flush();
		out.close();
		br.close();
	}

    //从顶到底建堆
    public static void heapSort1(){
        for(int i = 0; i < n; i++){
            heapInsert(i);
        }

        int size = n;
        while (size > 1) {
            swap(0, --size);
            heapify(0, size);
        }
    }
    
    // 从底到顶建立大根堆
    public static void heapSort2(){
        for(int i = n - 1; i >= 0; i--){
            heapify(i, n);
        }

        int size = n;
        while (size > 1) {
            swap(0, --size);
            heapify(0, size);
        }

    }


    // i位置的数，向上调整大根堆
    public static void heapInsert(int i){
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    //当前数组大小为size
    //i位置的数，向下调整大根堆
    public static void heapify(int i, int size){
        int l = 2 * i + 1;
        while (l < size) {
            //先计算有没有右孩子，如果有右孩子，就计算哪个孩子更大
            int best = l + 1 < size && arr[l] < arr[l + 1] ? l + 1: l;
            //更大的孩子与父节点哪个更大
            best = arr[best] > arr[i] ? best : i;
            //如果父节点更大，说明位置合适，退出循环。
            if (best == i) {
                break;
            }
            swap(i, best);
            //更新父节点，左孩子节点
            i = best;
            l = 2 * i + 1;
        }
    }
    public static void swap(int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
