package dataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

// 归并排序，acm练习风格
// 测试链接 : https://www.luogu.com.cn/problem/P1177
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过
public class day_04_24_MergeSort {
    private static int MAX = 10001;

    private static int[] arr = new int[MAX];

    private static int[] help = new int[MAX];

    private static int n;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		n = (int) in.nval;
		for (int i = 0; i < n; i++) {
			in.nextToken();
			arr[i] = (int) in.nval;
		}

        mergeSort1(0, n-1);
        mergeSort2();
		for (int i = 0; i < n - 1; i++) {
			out.print(arr[i] + " ");
		}
		out.println(arr[n - 1]);
		out.flush();
		out.close();
		br.close();
    }

    // 归并排序递归版
	// 假设l...r一共n个数
	// T(n) = 2 * T(n/2) + O(n)
	// a = 2, b = 2, c = 1
	// 根据master公式，时间复杂度O(n * logn)
	// 空间复杂度O(n)
    public static void mergeSort1(int l, int r){
		if (l ==r ){
			return;
		}
		int m = (l + r) / 2;
		mergeSort1(l, m);
		mergeSort1(m + 1, r);
		merge(l, m, r);
    }

    // 归并排序非递归版
	// 时间复杂度O(n * logn)
	// 空间复杂度O(n)
    public static void mergeSort2() {
        for (int l, m, r, step = 1; step < n; step <<= 1){
			l = 0;
			while (l < n) {
				m = l + step - 1;
				if (m + 1 >= n) {
					break;
				}

				r = Math.min(l + (step << 1), n - 1);
				merge(l, m, r);
				l = r + 1;
			}
		}
    }

    // l....r 一共有n个数
	// O(n)
	public static void merge(int l, int m, int r){
        int a = l;
		int i = l;
		int b = m + 1;
		while (a <= m && b <= r) {
			help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
		}

		while (a <= m) {
			help[i++] = arr[a++];
		}

		while (b <= r) {
			help[i++] = arr[b++];
		}

		for (i = l; i <= r; i++){
			arr[i] = help[i];
		}
    }

}
