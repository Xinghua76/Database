package thread;

import java.util.List;

// 给你两个 非空 的链表，表示两个非负的整数
// 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字
// 请你将两个数相加，并以相同形式返回一个表示和的链表。
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头
// 测试链接：https://leetcode.cn/problems/add-two-numbers/
public class day_04_18_AddTwoNumbers {

    public static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }
        public ListNode (int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode AddTwoNumbers(ListNode head1, ListNode head2){
        ListNode ans = null, cur = null;
        int carry = 0;
        for(int val,sum;
            head1 != null || head2 != null;
            head1 = head1 == null ? null : head1.next,
                head2 = head2 == null ? null : head2.next){
            sum = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val) + carry ;

            val = sum % 10;
            carry = sum / 10;

            if(ans == null){
                ans = new ListNode(val);
                cur =ans;
            }else {
                cur.next = new ListNode(val);
                cur = cur.next;
            }
        }

        if(carry == 1){
            cur.next = new ListNode(1);
        }

        return ans;

    }
}
