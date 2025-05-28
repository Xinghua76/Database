package dataStructure.month_25_05;

public class day_05_11_CopyListWithRandomPointer {
    public class Node {
        public int val;
        public Node next;
        public Node random;
        public Node(int v){
            val = v;
        }
        
    }

    public static Node CopyListWithRandomPointer(Node head){
        if (head == null) {
            return null;
        }

        Node cur = head;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }

        cur = head;
        while (cur != null) {
            next = cur.next.next;
            cur.next.random = cur.random == null ? null : cur.random.next;
            cur = next;
        }

        cur = head;
        Node copy, ans = head.next;
        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            cur.next = next;
            copy.next = next == null ? null : next.next;
            cur = next;
        }

        return ans;
    }
}
