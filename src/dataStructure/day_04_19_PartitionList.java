package dataStructure;


// 给你一个链表的头节点 head 和一个特定值 x
// 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
// 你应当 保留 两个分区中每个节点的初始相对位置
// 测试链接 : https://leetcode.cn/problems/partition-list/
public class day_04_19_PartitionList {

    public class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val ;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode partitionList(ListNode head, int x){
        ListNode leftHead = null,leftTail = null,rightHead = null, rightTail = null, next = null;
        while (head != null){
            next = head.next;
            head.next = null;
            if (head.val < x){
                if (leftHead == null){
                    leftHead = head;
                }else {
                    leftTail.next = head;
                }
                leftTail = head;
            }else {
                if (rightHead == null){
                    rightHead = head;
                }else{
                    rightTail.next = head;
                }
                rightTail = head;
            }
            head = next;
        }

        if (leftHead == null){
            return rightHead;
        }

        leftTail.next = rightTail;
        return leftHead;
    }
}
