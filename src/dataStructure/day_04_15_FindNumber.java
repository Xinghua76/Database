package dataStructure;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//二分查找，有序数组是否存在一个数字
public class day_04_15_FindNumber {

    //对数器
    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTimes = 50000;
        System.out.println("测试开始");
        for(int i = 0; i < testTimes; i++){
            int n = (int)(Math.random()*N);
            int[] arr = randomArray(N,V);
            Arrays.sort(arr);
            if(right(arr,n) != exist(arr,n)){

                System.out.println("出错了");
            }
            System.out.println("测试结束");
        }

    }

    //生成随机数组
    public static int[] randomArray(int n, int v){
        int[] arr = new int[n];
        for(int i = 0;i<n; i++){
            arr[i] = (int)(Math.random()*v)+1;
        }
        return arr;
    }

    //验证是否存在
    public static boolean right(int[] sortedArr, int num){
        for(int cur : sortedArr){
            if(cur == num){
                return true;
            }
        }

        return false;
    }

    //算法函数
    public static boolean exist(int[] arr,int num){
        if(arr == null || arr.length == 0){
            return false;
        }
        int l = 0, r = arr.length - 1, m = 0;
        while (l <= r){
            m = l + (r - l) / 2;
            if(arr[m] > num){
                r = m - 1;
            } else if(arr[m] < num){
                l = m + 1;
            }else return true;
        }

        return false;
    }
}
