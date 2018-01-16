/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class LongestDistance {
	public int findLongest(TreeNode root) {
		int l_maxdis[] = new int[1];// 左子树跨节点的最大长度
		int ld = getDepth(root.left, l_maxdis);// 左子树的最大深度
		int r_maxdis[] = new int[1];// 右子树跨节点的最大长度
		int rd = getDepth(root.right, r_maxdis);// 右子树的最大深度

		return Math.max(ld + rd + 1, Math.max(l_maxdis[0], r_maxdis[0]));
	}

	public int getDepth(TreeNode root, int maxDistance[]) {
		if (root == null) {
			return 0;
		}

		int l = getDepth(root.left, maxDistance);
		int r = getDepth(root.right, maxDistance);

		maxDistance[0] = l + r + 1;// 跨节点的最大长度

		return Math.max(l, r) + 1;
	}
}