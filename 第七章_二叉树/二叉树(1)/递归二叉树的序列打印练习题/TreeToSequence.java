import java.util.ArrayList;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class TreeToSequence {
	public int[][] convert(TreeNode root) {

		ArrayList<Integer> list1 = new ArrayList<>();
		preOrder(root, list1);
		ArrayList<Integer> list2 = new ArrayList<>();
		Inorder(root, list2);
		ArrayList<Integer> list3 = new ArrayList<>();
		RevOrder(root, list3);

		int[][] res = new int[3][list1.size()];

		for (int i = 0; i < list1.size(); i++) {
			res[0][i] = list1.get(i);
		}

		for (int i = 0; i < list2.size(); i++) {
			res[1][i] = list2.get(i);
		}

		for (int i = 0; i < list3.size(); i++) {
			res[2][i] = list3.get(i);
		}

		return res;
	}

	// 二叉树前序遍历
	public void preOrder(TreeNode root, ArrayList<Integer> res) {
		if (root == null) {
			return;
		} else {
			res.add(root.val);
			preOrder(root.left, res);
			preOrder(root.right, res);
		}
	}

	// 二叉树中序遍历
	public void Inorder(TreeNode root, ArrayList<Integer> res) {
		if (root == null) {
			return;
		} else {
			Inorder(root.left, res);
			res.add(root.val);
			Inorder(root.right, res);
		}
	}

	// 二叉树后序遍历
	public void RevOrder(TreeNode root, ArrayList<Integer> res) {
		if (root == null) {
			return;
		} else {
			RevOrder(root.left, res);
			RevOrder(root.right, res);
			res.add(root.val);
		}
	}
}