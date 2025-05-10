package dataStructure.month_25_05;


// 位图的实现
// Bitset是一种能以紧凑形式存储位的数据结构
// Bitset(int n) : 初始化n个位，所有位都是0
// void fix(int i) : 将下标i的位上的值更新为1
// void unfix(int i) : 将下标i的位上的值更新为0
// void flip() : 翻转所有位的值
// boolean all() : 是否所有位都是1
// boolean one() : 是否至少有一位是1
// int count() : 返回所有位中1的数量
// String toString() : 返回所有位的状态
public class day_05_07_DesignBitsetTest {
    class Bitset{
        private int[] set;
        private final int size;
        private int zeros;
        private int ones;
        private boolean reverse;

        public Bitset(int n){
            set = new int[(n + 31) / 32];
            size = n;
            zeros = n;
            ones = 0;
            reverse = false;
        }

        public void fix(int n){
            int index = n / 32;
            int bit = n % 32;
            if (!reverse) {
                if ((set[index] >> bit & 1) == 0) {
                    set[index] |=  (1 << bit);
                    ones++;
                    zeros--;
                }
            }else {
                if ((set[index] >> bit & 1 )== 1) {
                    set[index] ^= (1 << bit);
                    ones--;
                    zeros++;
                }
            }
        }

        public void unfix(int n){
            int index = n / 32;
            int bit = n % 32;
            if (!reverse) {
				if ((set[index] & (1 << bit)) != 0) {
					ones--;
					zeros++;
					set[index] ^= (1 << bit);
				}
			} else {
				if ((set[index] & (1 << bit)) == 0) {
					ones--;
					zeros++;
					set[index] |= (1 << bit);
				}
			}
        }

        public void flip(){
            zeros = ones;
            ones = size - zeros;
            reverse = !reverse;
        }

        public boolean all(){
            return ones == size;
        }

        public boolean one(){
            return ones > 0 ;
        }

        public int count(){
            return ones;
        }

        public String toString(){
            StringBuilder builder = new StringBuilder();
            for (int i = 0, k = 0, number, status; i < size ; k++){
                number = set[k];
                for (int j = 0; j < 32 && i < size; j++, i++){
                    status = (number >> j) & 1;
                    status ^= reverse ? 1 : 0;
                    builder.append(status);
                }
            }

            return builder.toString();
        }




    }
}
