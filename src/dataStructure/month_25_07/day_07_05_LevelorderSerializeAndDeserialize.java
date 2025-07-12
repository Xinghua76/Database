package dataStructure.month_25_07;

// 二叉树按层序列化和反序列化
// 测试链接 : https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
public class day_07_05_LevelorderSerializeAndDeserialize {
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        
        public TreeNode(int v){
            val = v;    
        }
    }

   public static int MAXN = 10001;

   public static TreeNode[] quque = new TreeNode[MAXN];

   public static int l, r;

   public String serialize (TreeNode node) {
        StringBuilder builder = new StringBuilder();
        if (node != null) {
            l = 0;
            r = 0;
            quque[r++] = node;
            while (l < r) {
                node = quque[l++];
                if (node.left != null) {
                    builder.append(node.left.val + ",");
                    quque[r++] = node.left;
                } else {
                    builder.append("#,");
                }

                if (node.right != null) {
                    builder.append(node.right.val + ",");
                    quque[r++] = node.right;
                } else {
                    builder.append("#,");
                }
            }
        }

        return builder.toString();
   }

   public TreeNode deSerialize(String data) {
        if (data.equals("")) {
            return null;
        }

        String[] vals = data.split(",");

        int index = 0;

        l = 0;
        r = 0;

        TreeNode root = generate(vals[index++]);

        quque[r++] = root;

        while (l < r) {
            TreeNode cur = quque[l++];
            cur.left = generate(vals[index++]);
            cur.right = generate(vals[index++]);
            if (cur.left != null) {
                quque[r++] = cur.left;
            }
            if (cur.right != null) {
                quque[r++] = cur.right;
            }
            
        }

        return root;

        
   }

   private TreeNode generate(String val){

        return val.equals("#") ?  null : new TreeNode(Integer.valueOf(val));

   }


}
