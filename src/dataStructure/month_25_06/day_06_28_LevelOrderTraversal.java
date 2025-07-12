package dataStructure.month_25_06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class day_06_28_LevelOrderTraversal {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static List<List<Integer>> levelOeder1(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();

        if (root != null) {
            Queue<TreeNode> quque = new LinkedList<>();
            HashMap<TreeNode, Integer> levels = new HashMap<>();
            quque.add(root);
            levels.put(root, 0);
            while (!quque.isEmpty()) {
                TreeNode cur = quque.poll();
                int level = levels.get(cur);
                if (level == ans.size()) {
                    ans.add(new ArrayList<>());
                }
                ans.get(level).add(cur.val);

                if (cur.left != null) {
                    quque.add(cur.left);
                    levels.put(cur.left, level + 1);
                }

                if (cur.right != null) {
                    quque.add(cur.right);
                    levels.put(cur.right, level + 1);
                }
            }

            return ans;
        }
    }

    public static int MAXN = 2001;
    
    public static TreeNode[] quque = new TreeNode[MAXN];

    public static int l, r;

    public static List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();

        if (root != null) {
            l = r = 0;
            quque[r++] = root;
            while (l < r) {
                int size = r - l;
                List<Integer> list = new ArrayList<Integer>();
                for (int i = 0; i < size; i++){
                    TreeNode cur = quque[l++];
                    list.add(cur.val);
                    if (cur.left != null) {
                        quque[r++] = cur.left;
                    }
                    if (cur.right != null) {
                        quque[r++] = cur.right;
                    }
                }
                
                ans.add(list);
            }
            
            
        }
    }
}
