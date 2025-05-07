package dataStructure.month_25_04;

// 翻转对数量
// 测试链接 : https://leetcode.cn/problems/reverse-pairs/
public class day_04_27_ReversePairs {


    static int MAX = 50001;
    static int[] help = new int[MAX];

    public int reversePairs(int[] nums) {
        int n = nums.length;
        return rp(0, n - 1, nums);
    }

    public int rp(int l, int r, int[] arr){
        if (l == r) {
            return 0;
        }

        int m = (r + l ) / 2;

        return rp(l, m, arr) + rp(m + 1, r, arr) + merge(l, m, r, arr);
    }

    public int merge(int l, int m, int r,int[] arr){
        int ans = 0;    
        
        for (int i = l, j = m + 1; i <= m; i++) {
			while (j <= r && (long) arr[i] > (long) arr[j] * 2) {
				j++;
			}
			ans += j - m - 1;
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

        for (i = l; i <= r; i++){
            arr[i] = help[i];
        }

        return ans;
    }
}
