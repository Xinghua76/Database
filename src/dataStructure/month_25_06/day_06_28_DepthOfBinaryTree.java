package dataStructure.month_25_06;

public class day_06_28_DepthOfBinaryTree {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public static  int maxDepth(TreeNode node){
        return node == null ? 0 : Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }



    public static int minDepth(TreeNode node){
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        int ldeep = Integer.MAX_VALUE;
        int rdeep = Integer.MAX_VALUE;

        if (node.left != null) {
            ldeep = minDepth(node.left);
        }

        if (node.right != null) {
            rdeep = minDepth(node.right);
        }

        return Math.min(ldeep, rdeep) + 1;
    }
}
