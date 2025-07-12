package dataStructure.month_25_07;

import java.util.HashMap;

// 利用先序与中序遍历序列构造二叉树
// 测试链接 : https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class day_07_08_PreorderInorderBuildBinaryTree {

	public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int v) {
			val = v;
		}
	}

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
			return null;
		}

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < preorder.length; i++) {
			map.put(inorder[i], i);
		}

		return f(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

	public TreeNode f(int[] pre, int l1, int r1, int[] in, int l2, int r2, HashMap<Integer, Integer> map) {
		if (l1 > r1) {
			return null;
		}
		
		TreeNode head = new TreeNode(pre[l1]);
		
		if (l1 == r1) {
			return head;
		}
		
		int k = map.get(pre[l1]);
		
		head.left = f(pre, l1 + 1, l1 + k -l2, in, l2, k - 1, map);
		head.right = f(pre, l1 + k -l2 + 1, r1, in, k + 1, r2, map);

		return head;
	}
}
