package dataStructure.month_25_05;

// 不用任何判断语句和比较操作，返回两个数的最大值
// 测试链接 : https://www.nowcoder.com/practice/d2707eaf98124f1e8f1d9c18ad487f76
public class day_05_05_GetMaxWithoutJudge {
    public static int flip(int n){
        return n ^ 1;
    }

    //正数返回1，负数返回0
    public static int sign(int n){
        return flip(n >>> 31);
    }

    public static int getMax(int a, int b){
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);

        int differAB = sa ^ sb;
        int sameAB = flip(differAB);

        int returnA = differAB * sa + sameAB * sc;
        int returnB = flip(returnA);

        return returnA * a + returnB * b;

    }


}
