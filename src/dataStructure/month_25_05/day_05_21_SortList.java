package dataStructure.month_25_05;

// 时间复杂度O(n*logn)，额外空间复杂度O(1)，有稳定性
// 注意为了额外空间复杂度O(1)，所以不能使用递归
// 因为mergeSort递归需要O(log n)的额外空间
public class day_05_21_SortList {
    public class ListNode{
        public int val;
        public ListNode next;
    }

    public ListNode sortList(ListNode head){

        //统计链表长度方便设定步长
        int n = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }

        //处理第一组，需要更新头结点
        ListNode l1, r1, l2, r2, next, lastTeamEnd;
        for (int step = 1; step < n; step <<= 1){
            l1 = head;
            r1 = findEnd(head, step);
            l2 = r1.next;
            r2 = findEnd(l2, step);
            next = r2.next;
            //断开两段
            r1.next = null;
            r2.next = null;

            merge(l1, r1, l2, r2);

            head = start;
            lastTeamEnd = end;

            while (next != null) {
                l1 = next;
                r1 = findEnd(l1, step);
                l2 = r1.next;
                //考虑只有半段的情况
                if (l2 == null) {
					lastTeamEnd.next = l1;
					break;
				}
                r2 = findEnd(l2, step);
                next = r2.next;

                r1.next = null;
                r2.next = null;

                merge(l1, r1, l2, r2);

                lastTeamEnd.next = start;
                lastTeamEnd = end;
            }
        }

        return head;

    }

    public ListNode findEnd(ListNode s, int k){
        while (s.next != null && --k > 0) {
            s = s.next;
        }
        return s;
    }

    public static ListNode start;

	public static ListNode end;

    public void merge(ListNode l1, ListNode r1, ListNode l2, ListNode r2){
        ListNode pre;
        if (l1.val <= l2.val) {
            start = l1;
            pre = l1;
            l1 = l1.next;
        }else {
            start = l2;
            pre = l2;
            l2 = l2.next;
        }

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            }else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }


        if (l1 != null) {
            pre.next = l1;
            end = r1;
            
        }

        if (l2 != null) {
            pre.next = l2;
            end = r2;
        }
    }




}
