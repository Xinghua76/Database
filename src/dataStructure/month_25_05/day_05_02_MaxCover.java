package dataStructure.month_25_05;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;

// 最多线段重合问题
// 测试链接 : https://www.nowcoder.com/practice/1ae8d0b6bb4e4bcdbf64ec491f63fc37
// 测试链接 : https://leetcode.cn/problems/meeting-rooms-ii/
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过

public class day_05_02_MaxCover {


    public static int MAX = 10001;

    public static int[][] line = new int[MAX][2];

    public static int[] heap = new int[MAX];

    public static int ans;

    public static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)in.nval;
            for (int i = 0; i < n; i++){
                in.nextToken();
                line[i][0] = (int)in.nval;
                in.nextToken();
                line[i][1] = (int)in.nval;
            }

            out.println(compute());
        }

        out.flush();
        out.close();
        br.close();
    }   

    public static int compute(){
        ans = 0;
        Arrays.sort(line, 0, n, (a,b) -> a[0] - b[0]);
        int size = 0;
        for (int i = 0; i < n; i++){
            while (ans > 0 && heap[0] <= line[i][0]) {
                pop();
            }

            add(line[i][1]);
            size = Math.max(ans, size);
        }

        return size;
    }

    public static void pop(){
        swap(0, --ans);
        int i  = 0;
        int l = 1;
        while (l < ans) {
            int best = l + 1 < ans && heap[l + 1] < heap[l] ? l + 1 : l;
            best = heap[i] < heap[best] ? i : best;
            if (best == i) {
                break;
            }

            swap(i, best);
            i = best ;
            l =  i * 2 + 1;
        }
    }

    public static void add(int x){
        heap[ans] = x;
        int i = ans++;
        while (heap[i] < heap[(i - 1) / 2]) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void swap(int i, int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    

}
