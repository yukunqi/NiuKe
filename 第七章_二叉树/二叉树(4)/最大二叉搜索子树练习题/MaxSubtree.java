/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class MaxSubtree {
	public TreeNode getMax(TreeNode root) {
		int[] value = new int[3];
		return RevOrder(root, value);
	}

	public TreeNode RevOrder(TreeNode root, int[] value) {
		if (root == null) {
			value[0] = Integer.MIN_VALUE;// 0存放最大值，1存放最小值，2存放总结点数
			value[1] = Integer.MAX_VALUE;
			value[2] = 0;

			return null;
		}

		TreeNode l_Node = RevOrder(root.left, value);// 左子树节点以及相关信息
		int l_max = value[0];
		int l_min = value[1];
		int l_num = value[2];
		TreeNode r_Node = RevOrder(root.right, value);// 右子树节点以及相关信息
		int r_max = value[0];
		int r_min = value[1];
		int r_num = value[2];

		int cur_val = root.val;// 当前节点值

		value[0] = Math.max(r_max, cur_val);// 更新最大值
		value[1] = Math.min(l_min, cur_val);// 更新最小值

		// 如果当前节点大于左孩子的最大值 小于右孩子的最小值 则包含这个节点也是二叉搜索树
		if (l_Node == root.left && r_Node == root.right && l_max < root.val && r_min > root.val) {
			value[2] = r_num + l_num + 1;// 更新节点个数
			return root;// 返回头节点
		}

		value[2] = Math.max(r_num, l_num);// 说明不满足上面的条件 选择左右节点中较多节点的子树更新节点个数

		return r_num >= l_num ? r_Node : l_Node;// 返回节点数更多的子树的头节点
	}
}