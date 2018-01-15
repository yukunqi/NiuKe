public class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class CountNodes {
	public int count(TreeNode root) {
		int res = 0;

		while (root.left != null && root.right != null) {
			int leftdepth = getDepth(root.left);
			int rightdepth = getDepth(root.right);

			if (leftdepth != rightdepth) {// 比较两个头节点的深度 若不一样 说明 右子树是一颗满二叉树
											// 直接用公式计算节点
				res += Math.pow(2, rightdepth) - 1;
				res += 1;// 加上头节点
				root = root.left;
			} else {// 若一样说明左子树是一颗满二叉树 直接用公式计算节点
				res += Math.pow(2, leftdepth) - 1;
				res += 1;// 加上头节点
				root = root.right;
			}
		}

		if (root.left != null && root.right == null) {// 当此时的头节点只有左子树的时候 就+2个节点
			res += 2;
		}
		if (root.left == null && root.right == null) {// 当只有根节点时 就+1个节点
			res += 1;
		}
		return res;
	}

	// 计算左子树最大深度
	public int getDepth(TreeNode head) {
		int res = 0;
		while (head != null) {
			head = head.left;
			res++;
		}
		return res;
	}
}