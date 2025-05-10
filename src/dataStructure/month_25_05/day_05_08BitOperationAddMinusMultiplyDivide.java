package dataStructure.month_25_05;

// 不用任何算术运算，只用位运算实现加减乘除
// 代码实现中你找不到任何一个算术运算符
// 测试链接 : https://leetcode.cn/problems/divide-two-integers/
public class day_05_08BitOperationAddMinusMultiplyDivide {

    public static int MIN = Integer.MIN_VALUE;

    //加法
    public static int add(int a, int b){
        int ans = 0;
        while (b != 0) {
            ans = a ^ b;
            b = (a & b) << 1;
            a = ans;
        }
        return ans; 
    }

    //减法
    public static int minus(int a, int b){
        return add(a,neg(b));
    }


    //取负
    public static int neg(int i){
        return add(~i, 1);
    }

    //乘法
    public static int multiply(int a, int b){
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = add(ans, a);
            }

            a <<= 1;
            b >>>= 1;
        }

        return ans;
    }

    //除法判断
    public static int divide(int a, int b){
        //两数都为最小
        if (a == MIN && b == MIN) {
            return 1;
        }
        //两数都不为最小
        if (a != MIN && b != MIN) {
            return div(a,b);
        }
        //除数最小
        if (b == MIN) {
            return 0;
        }
        
        if (a == MIN &&  b == neg(1)) {
            return Integer.MAX_VALUE;
        }
        //a为整数最小，b不为最小也不为-1
        add(a, b > 0 ? b : neg(b));
        int ans = div(a, b);
        return add(ans, b > 0 ? neg(1) : 1);

    }

    //一般情况除法处理
    public static int div(int a, int b){
        int ans = 0;
        int x = a > 0 ? a : neg(a);
        int y = b > 0 ? b : neg(b);
        for (int i = 30; i >= 0; minus(i,1)){
            if ((x >> i) >= y) {
                ans |= (1 << i);
                y = minus(x, y << i);
            }
        }

        return a > 0 && b > 0 ? ans : neg(ans);
    }
    
}
