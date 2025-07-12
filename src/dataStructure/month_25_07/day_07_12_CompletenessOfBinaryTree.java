package dataStructure.month_25_07;

public class day_07_12_CompletenessOfBinaryTree {

    // 定义二叉树节点类
    public static class TreeNode {
        public int val;         // 节点值
        public TreeNode left;    // 左子节点
        public TreeNode right;   // 右子节点
    }

    // 定义队列的最大容量
    public static int MAXN = 101;

    // 用数组实现的队列，用于层序遍历
    public static TreeNode[] queue = new TreeNode[MAXN];

    // 队列的头部和尾部指针
    public static int l, r;

    /**
     * 判断二叉树是否是完全二叉树
     * @param root 二叉树的根节点
     * @return 如果是完全二叉树返回true，否则返回false
     */
    public boolean isCompleteTree(TreeNode root) {
        // 如果根节点为空，认为是完全二叉树
        if (root == null) {
            return true;
        }

        // 初始化队列
        l = r = 0;
        queue[r++] = root;

        // 标记是否遇到过左右孩子不双全的节点
        boolean leaf = false;
        
        // 开始层序遍历
        while (l < r) {
            // 从队列中取出当前节点
            root = queue[l++];

            /* 判断是否违反完全二叉树的性质：
               1. 如果左孩子为空但右孩子不为空，违反
               2. 如果已经遇到过不双全的节点，后面又出现有孩子的节点，违反
            */
            if ((root.left == null && root.right != null) || 
                (leaf && (root.left != null || root.right != null))) {
                return false;
            }

            // 将左孩子加入队列
            if (root.left != null) {
                queue[r++] = root.left;
            }

            // 将右孩子加入队列
            if (root.right != null) {
                queue[r++] = root.right;
            }

            // 如果当前节点的左右孩子不双全，标记leaf为true
            if (root.left == null || root.right == null) {
                leaf = true;
            }
        }

        // 遍历结束没有发现违反性质的情况，是完全二叉树
        return true;
    }
}