package dataStructure.month_25_04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

// 小和问题
// 测试链接 : https://www.nowcoder.com/practice/edfe05a1d45c4ea89101d936cac32469
// 请同学们务必参考如下代码中关于输入、输出的处理
// 这是输入输出处理效率很高的写法
// 提交以下的code，提交时请把类名改成"Main"，可以直接通过
public class day_04_27_SmallSum {
    public static int MAX = 100001;
    public static int[] arr = new int[MAX];
    public static int[] help = new int[MAX];
    public static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br); 
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)in.nval;
            for (int i = 0; i < n; i++){
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            out.println(SmallSum(0, n - 1));
        }

        out.flush();
        out.close();
        br.close();
    }


    public static long SmallSum(int l, int r){
        if (l == r) {
            return 0;
        }

        int m = l + (r - l) / 2;
        return SmallSum(l, m) + SmallSum(m + 1, r) + Merge(l,r,m);
    }

    public static long Merge(int l, int r, int m){
        long ans = 0;
        for (int j = m + 1, i = l, sum = 0; j <= r; j++){
            while (arr[i] <= arr[j] && i <= m) {
                sum += arr[i++];
            }
            ans += sum;
        }

        
        int a = l;
        int b = m + 1;
        int i = l;
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }

        while (a <= m) {
            help[i++] = arr[a++];
        }

        while (b <= r) {
            help[i++] = arr[b++];
        }

        for ( i = l; i <= r; i++){
            arr[i] = help[i];
        }

        return ans;

    }

}
