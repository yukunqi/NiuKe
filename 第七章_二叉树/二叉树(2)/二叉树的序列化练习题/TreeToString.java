import java.util.Stack;

public class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class TreeToString {
	public String toString(TreeNode root) {

		if (root == null) {
			return "#!";
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		StringBuilder builder = new StringBuilder();

		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			stack.pop();
			if (cur == null) {
				builder.append("#!");
				continue;
			} else {
				builder.append(cur.val);
				builder.append("!");
			}

			stack.push(cur.right);

			stack.push(cur.left);

		}

		return builder.toString();
	}
}