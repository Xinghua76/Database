package dataStructure.month_25_06;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class day_06_28_ZigzagLevelOrderTraversal {
    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public static int l, r;
    public static int MAXN = 2001;
    public static TreeNode[] quque = new TreeNode[MAXN];

    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            l = r = 0;
            quque[r++] = root;
            boolean reverse = false;
            //false为从左往右
            //true为从右往左
            while (l < r) {
                int size = r - l;
                List<Integer> list = new ArrayList<Integer>();
                for (int i = reverse ? r -1 : l, j = reverse ? -1 : 1, k = 0; k < size; i += j, k++ ){
                    TreeNode cur = quque[i];
                    list.add(cur.val);
                }

                for( int i = 0; i < size; i++){
                    TreeNode cur = quque[l++];
                    if (cur.left != null) {
                        quque[r++] = cur.left;
                    }
                    if (cur.right != null) {
                        quque[r++] = cur.right;
                    }
                }

                ans.add(list);
                reverse = !reverse;
            }

        }
        return ans;
    }
}
