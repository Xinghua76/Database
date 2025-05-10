package dataStructure.month_25_05;

// 返回两个无环链表相交的第一个节点
// 测试链接 : https://leetcode.cn/problems/intersection-of-two-linked-lists/
public class day_05_10_IntersectionOfTwoLinkedLists {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

        public static ListNode getIntersectionNode(ListNode h1, ListNode h2){
            
            //如果一条链为空，两条链就不可能相交
            if (h1 == null || h2 == null) {
                return null;
            }
            ListNode a = h1, b = h2;
            int differ = 0;

            //求出一条链长
            while (a.next != null) {
                a = a.next;
                differ++;
            }
            //求出链长差
            while (b.next != null) {
                b = b.next;
                differ--;
            }
            //如果链尾不同，一定不相交
            if (a != b) {
                return null;
            }
            //将较长的链赋值给a
            if (differ > 0) {
                a = h1;
                b = h2;
            }else {
                a = h2;
                b = h1;
            }
            //求出differ绝对值
            differ = Math.abs(differ);
            //先遍历多出的部分
            for (int i = 0; i < differ; i++){
                a = a.next;
            }
            //开始遍历，找第一个交点
            while (a != b) {
                a = a.next;
                b = b.next;
            }
            return a;
        }
}
