import java.util.LinkedList;
import java.util.Queue;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class CheckCompletion {
	public boolean chk(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean res = true;
		boolean isleaf = false;
		while (!queue.isEmpty()) {// 按层遍历来进行检索
			TreeNode cur = queue.poll();

			if (isleaf) {// 当标志为true时 代表开始判断当前节点是否为叶子节点
				if (!(cur.right == null && cur.left == null)) {// 不是叶子节点 返回
																// false
					res = false;
					break;
				}
			}

			if (cur.right != null && cur.left == null) {// 有右孩子没左孩子 不符合完全二叉树定义
														// 返回false
				res = false;
				break;
			} else if (cur.right != null && cur.left != null) {
				queue.add(cur.left);
				queue.add(cur.right);
			} else {// 当不同时存在左右孩子时 此时就要求此节点以后的节点都要是叶子节点
				isleaf = true;
				if (cur.left != null) {
					queue.add(cur.left);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
			}

		}

		return res;
	}
}