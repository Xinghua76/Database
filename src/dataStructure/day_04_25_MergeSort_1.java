package dataStructure;

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
    
    public static int[] mergeSort2(int[] nums){
        
    }
}
