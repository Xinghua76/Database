package dataStructure.month_25_05;

import java.util.List;

public class day_05_21_PalindromeLinkedList {

    public class ListNode {
        public int val;
        public ListNode next;
    }

    public static boolean PalindromeLinkedList(ListNode head){
        if (head == null || head.next == null) {
            return true;
        }

        //快慢指针找中点
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //将后半部分翻转
        ListNode pre = slow;
        ListNode cur = slow.next;
        ListNode next = null;
        pre.next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        //从两边向间作比较
        boolean ans = true;
        ListNode left = head, right = pre;
        while (left != null && right != null) {
            if (left.val != right.val) {
                ans = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        //恢复原链
        cur = pre.next;
        next = null;
        pre.next = null;
        while (cur.next != slow) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return ans;

    }
}
