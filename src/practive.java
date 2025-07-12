import java.util.HashMap;

public class practive {

    // 定义二叉树节点类
    public static class TreeNode {
        public int val;         // 节点值
        public TreeNode left;    // 左子节点
        public TreeNode right;   // 右子节点
    }

	public static int MAXN = 101;

	public static TreeNode[] queue = new TreeNode[MAXN];

	public static int l, r;

	public boolean isisCompleteTree(TreeNode root) {
		if (root == null) {
			return true;
		}

		l = r = 0;

		boolean leaf = false;

		queue[r++] = root;

		while (l < r) {
			root = queue[l++];

			if ((root.left == null && root.right != null) || (leaf && (root.left != null || root.right != null))) {
				return false;
			}

			if (root.left == null) {
				queue[r++] = root.left;
			}

			if (root.right == null) {
				queue[r++] = root.right;
			}

			if (root.left == null || root.right == null) {
				leaf = true;
			}
		}

		return true;
	}

}


