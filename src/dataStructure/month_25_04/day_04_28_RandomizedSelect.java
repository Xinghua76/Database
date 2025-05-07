package dataStructure.month_25_04;

// 无序数组中第K大的元素
// 测试链接 : https://leetcode.cn/problems/kth-largest-element-in-an-array/
public class day_04_28_RandomizedSelect {
    public static int first,last;

    public static int findKthLargest(int[] nums, int k) {
		return randomizedSelect(nums, nums.length - k);
	}

    public static int randomizedSelect(int[] arr, int i){

        int ans = 0;
        for (int l = 0, r = arr.length - 1; l <= r;){
            partition(l, r, arr[l + (int)Math.random() * (r - l + 1)], arr);

            if ( i < first) {
                r = first - 1;
            }else if (i > last) {
                l = last + 1;
            }else {
                ans = arr[i];
                break;
            }

        }

        return ans;
    }

    public static void partition(int l, int r, int x, int[] arr){
        first = l;
        last = r;
        int i = l;
        while (i <= last) {
            if (arr[i] < x) {
                Swap(first++, i++, arr);
            }else if (arr[i] > x) {
                Swap(last--, i, arr);
            }else {
                i++;
            }
        }
    }
    public static void Swap(int a, int b, int[] arr){
        int temp;
        temp = arr[a];
        arr[a] =arr[b];
        arr[b] = temp;
    }
}
