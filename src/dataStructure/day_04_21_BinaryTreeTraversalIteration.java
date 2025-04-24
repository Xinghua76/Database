package dataStructure;

import java.util.Stack;

// 不用递归，用迭代的方式实现二叉树的三序遍历
public class day_04_21_BinaryTreeTraversalIteration {

    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int v){
            val = v;
        }
    }


    // 先序打印所有节点，非递归版
    public static void preOrder(TreeNode head){
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.val + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
    }

    // 中序打印所有节点，非递归版
    public static void inOrder(TreeNode head) {
        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.println(head.val + " ");
                    head = head.right;
                }
            }

        }
    
        
    }
    // 后序打印所有节点，非递归版
	// 这是用两个栈的方法
    public static void posOrderTwoStacks(TreeNode root){
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            Stack<TreeNode> collect = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                collect.push(root);
                if (root.left != null) {
                    stack.push(root.left);
                }
                if (root.right != null) {
                    stack.push(root.right);
                }
            }

            while (!collect.isEmpty()) {
                System.out.println(collect.pop().val + " ");
            }
        }
    }

    // 后序打印所有节点，非递归版
	// 这是用一个栈的方法
    public static void posOrderOneStack(TreeNode root){
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.peek();        
                if (cur.left != null && root != cur.left && root != cur.right) {
                    stack.push(cur.left);
                }else if (cur.right != null && root.right != cur.right) {
                    stack.push(cur.right);
                }else {
                    System.out.println(cur.val + " ");
                    root = stack.pop();
                }
            }
        }
    }


    public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(5);
		head.right.left = new TreeNode(6);
		head.right.right = new TreeNode(7);
		preOrder(head);
		System.out.println("先序遍历非递归版");
		inOrder(head);
		System.out.println("中序遍历非递归版");
		posOrderTwoStacks(head);
		System.out.println("后序遍历非递归版 - 2个栈实现");
		posOrderOneStack(head);
		System.out.println("后序遍历非递归版 - 1个栈实现");
	}

}
