package dataStructure;

// 找到缺失的数字
// 测试链接 : https://leetcode.cn/problems/missing-number/
public class day_05_05_MissingNumber {
    public static int MissingNumber(int[] nums){
        int eorALL = 0, eorHas = 0;
        for (int i = 0; i < nums.length; i++){
            eorALL ^= i;
            eorHas ^= nums[i];
        }

        eorALL ^= nums.length;

        return eorALL ^ eorHas;
    }
}
