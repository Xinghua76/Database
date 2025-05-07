package dataStructure.month_25_04;

// 归并排序，填函数练习风格
// 测试链接 : https://leetcode.cn/problems/sort-an-array/
public class day_04_25_MergeSort_1 {
    public static int[] sortArray(int[] nums){
        if (nums.length > 1) {
            // mergeSort1为递归方法
			// mergeSort2为非递归方法
			// 用哪个都可以
			// mergeSort1(nums);
			mergeSort2(nums);
        }
        return nums;
    }


    public static int MAXN = 50001;

	public static int[] help = new int[MAXN];
    
    //递归
    public static void mergeSort1(int[] nums,int l,int r){
        sort(nums, 0, nums.length);
    }

    public static void sort(int[] nums, int l, int r){
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort1(nums, l, m);
        mergeSort1(nums, m + 1, r);
        merge(nums, l, m, r);
    }

    //非递归
    public static void mergeSort2(int[] arr){
        int n = arr.length;
        for (int l,m,r,step = 1; step < n; step <<= 1){
            l = 0;
            while (l < n) {
                m = l + step - 1;
                if (m + 1 >= n) {
                    break;
                }
                r = Math.min(l + (step << 1) -1, n);
                merge(arr, l, m, r);
                l = r + 1;
            }
        }
    }

    public static void merge(int[] arr, int l, int m, int r){
        int a = l;
        int b = m + 1;
        int i = l;
        while (a <= m && b <= r) {
            help[i++] = arr[a] < arr[b] ? arr[a++] : arr[b++]; 
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
