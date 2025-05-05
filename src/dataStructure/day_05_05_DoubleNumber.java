package dataStructure;

// 数组中有2种数出现了奇数次，其他的数都出现了偶数次
// 返回这2种出现了奇数次的数
// 测试链接 : https://leetcode.cn/problems/single-number-iii/
public class day_05_05_DoubleNumber {
    public static int[] DoubleNumber(int[] arr){
        int ero0 = 0, ero1 = 0;
        //算出a ^ b 最位为1的最低一位
        for (int i = 0; i < arr.length; i++){
            ero0 ^= arr[i];
        }
        int rightOne = ero0 &(-ero0);

        //找出第i位同样为1的数，做相与运算，得出的数即为a或者b
        for (int i = 0; i < arr.length; i++){
            if ((arr[i] & rightOne) == 0) {
                ero1 ^= arr[i];
            }
        }

        return new int[]{ero1, ero0 ^ ero1};

    }
}
