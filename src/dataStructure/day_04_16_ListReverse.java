package dataStructure;

public class day_04_16_ListReverse {

    // 反转单链表测试链接 : https://leetcode.cn/problems/reverse-linked-list/

    //单向链表
    public static class ListNode{

        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }

        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode reverSeList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    //双向链表
    public  static class DoubleListNode{

        public int value;
        public DoubleListNode next;
        public DoubleListNode last;
        public DoubleListNode(int v){
            value = v;
        }

    }

    public static DoubleListNode reverseDoubleList(DoubleListNode head){

        DoubleListNode pre = null;
        DoubleListNode next = null;
        while(head != null){
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }

        return pre;
    }



}
