import java.util.ArrayList;
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
}
*/
public class TreePrinter {
	public int[][] printTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		ArrayList<Integer> value = new ArrayList<>();
		TreeNode last = root;
		TreeNode nlast = null;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			value.add(cur.val);
			if (cur.left != null) {
				queue.add(cur.left);
				nlast = cur.left;
			}
			if (cur.right != null) {
				queue.add(cur.right);
				nlast = cur.right;
			}
			if (last == cur) {
				list.add(value);
				value = new ArrayList<>();
				last = nlast;
			}
		}

		int[][] res = new int[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			ArrayList<Integer> t = list.get(i);
			res[i] = new int[t.size()];
			for (int j = 0; j < t.size(); j++) {
				res[i][j] = t.get(j);
			}
		}
		return res;
	}
}