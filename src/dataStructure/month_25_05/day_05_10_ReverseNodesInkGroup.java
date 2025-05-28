package dataStructure.month_25_05;

// 每k个节点一组翻转链表
// 测试链接：https://leetcode.cn/problems/reverse-nodes-in-k-group/
public class day_05_10_ReverseNodesInkGroup {
    public class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode reverseKGroup(ListNode head, int k){
        ListNode start = head;
        ListNode end = teamEnd(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, end);
        ListNode lastTeamEnd = start;
        while (end != null) {
            start = lastTeamEnd.next;
            end = teamEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastTeamEnd.next = end;
            lastTeamEnd = start;
        }
        return head;
    }

    //找到队尾
    public static ListNode teamEnd(ListNode s, int k){
        while (--k > 0 && s != null) {
            s = s.next;
        }
        return s;   
    }

    //翻转函数
    public static void reverse(ListNode s, ListNode e){
        e = e.next;
        ListNode pre = null, cur = s, next = null;
        while (cur != e) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        s.next = e;
    }


}
