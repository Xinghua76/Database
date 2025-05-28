import java.util.HashMap;
import java.util.List;

public class practive {
    class LRUcache{
        class DoubleNode{
            public int key;
            public int value;
            public DoubleNode last;
            public DoubleNode next;

            public DoubleNode(int k, int v){
                key = k;
                value = v;
            }
        }


        class NodeList{
            private DoubleNode head;
            private DoubleNode tail;
            
            public NodeList(){
                head = null;
                tail = null;
            }

            public void addNode(DoubleNode newnode){
                if (newnode == null) {
                    return;
                }

                if (head == null) {
                    head = newnode;
                    tail = newnode;
                } else {
                    tail.next = newnode;
                    newnode.last = tail;
                    tail = newnode;
                }
            }

            public void moveToTail(DoubleNode node){
                if (tail == node) {
                    return;
                }

                if (head == node) {
                    head = node.next;
                    head.last = null;
                } else {
                    node.last.next = node.next;
                    node.next.last = node.last;
                }

                tail.next = node;
                node.last = tail;
                tail = node;
            }

            public DoubleNode removeHead(){
                if (head == null) {
                    return null;
                }

                DoubleNode ans = head;
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    head = ans.next;
                    ans.next = null;
                    head.last = null;
                }

                return ans;
            }
        }

        private HashMap<Integer, DoubleNode> keyNodeMap;

        private NodeList nodeList;
        
        private final int captical;

        public LRUcache(int cap){
            keyNodeMap = new HashMap<>();
            nodeList = new NodeList();
            captical = cap;
        }

        public int get(int k){
            if (!keyNodeMap.containsKey(k)) {
                return -1;
            } else {
                DoubleNode ans = keyNodeMap.get(k);
                nodeList.moveToTail(ans);
                return ans.value;
            }
        }

        public void put(int key, int value){
            if (keyNodeMap.containsKey(key)) {
                DoubleNode ans = new DoubleNode(key, value);
                nodeList.addNode(ans);
            } else {
                if (keyNodeMap.size() == captical) {
                    keyNodeMap.remove(nodeList.removeHead().key);
                }
                
                DoubleNode newNode = new DoubleNode(key, value);
                keyNodeMap.put(key, newNode);
                nodeList.addNode(newNode);
                
            }
        }

    }
    
}
