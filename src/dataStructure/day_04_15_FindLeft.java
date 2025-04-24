package dataStructure;
import java.util.Arrays;

// 有序数组中找>=num的最左位置
public class day_04_15_FindLeft {

    //验证正确性
    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTimes = 500000;
        System.out.println("开始测试");
        for(int i = 0; i < testTimes; i++){
            int n = (int)(Math.random() * N);
            int[] arr = randomArray(n,V);
            Arrays.sort(arr);
            int num = (int)(Math.random() * V);
            if(right(arr,num) != right(arr,num)){
                System.out.println("出错了");
            }
            System.out.println("测试结束");
        }



    }

    //生成随机数组
    public static int[] randomArray(int n,int v){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = (int)(Math.random()*v) + 1;
        }
        return arr;
    }

    //暴力解法
    public static int right(int[] arr,int num){

        for(int i = 0; i < arr.length; i++){
            if (arr[i] >= num){
                return i;
            }
        }
        return -1;
    }


    //算法函数
    public static int exist(int[] arr,int num){
        if (arr == null || arr.length == 0) return -1;
        int l = 0, r = arr.length - 1, m = 0;
        int ans = -1;
        while (l <= r){
            m = l + (r - l) / 2;
            if (arr[m] >= num){
                ans = m;
                r = m - -1;
            }else if (arr[m] < num){
                l = m + 1;
            }
        }
        return ans;
    }
}
