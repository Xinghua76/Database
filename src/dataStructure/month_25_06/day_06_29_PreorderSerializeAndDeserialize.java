package dataStructure.month_25_06;

// 二叉树先序序列化和反序列化
// 测试链接 : https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
public class day_06_29_PreorderSerializeAndDeserialize {
    public static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int v) {
			val = v;
		}
	}

    public class code {
		public String serialize(TreeNode root){
			StringBuilder builder = new StringBuilder();
			f(root, builder);
			return builder.toString();
		}

		void f(TreeNode root, StringBuilder builder){
			if (root == null) {
				builder.append("#,");
			} else {
				builder.append(root.val + ",");
				f(root.left, builder);
				f(root.right, builder);
			}
		}


	}
	
	public static int cnt;
	
	public TreeNode deserialize(String data){
		String[] vals = data.split(data);
		cnt = 0;
		return g(vals);
	}

	TreeNode g(String[] vals){
		String cur = vals[cnt++];
		if (cur.equals("#")) {
			return null;
		} else {
			TreeNode head = new TreeNode(Integer.valueOf(cur));
			head.left = g(vals);
			head.right = g(vals);
			return head;
		}
	}
}
