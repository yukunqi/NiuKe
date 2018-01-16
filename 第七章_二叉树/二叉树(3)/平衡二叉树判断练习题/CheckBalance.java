/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class CheckBalance {
	public boolean check(TreeNode root) {
		return chk(root) >= 0;
	}

	public int chk(TreeNode root) {// 使用后序遍历
		if (root == null) {
			return 0;
		}
		int l = chk(root.left);// 左子树高度
		int r = chk(root.right);// 右子树高度

		if (l < 0 || r < 0) {// 若为-1 则说明其中子树为非平衡二叉树
			return -1;
		}

		if (Math.abs(l - r) > 1) {// 若左右子树不是非平衡二叉树 此时判断左右子树的高度差 大于1 则是非平衡二叉树 返回
			return -1;
		}

		return Math.max(l, r) + 1;// 返回子树高度
	}
}