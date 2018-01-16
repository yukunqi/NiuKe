import java.util.ArrayList;
import java.util.Stack;

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
		int[] pre = preOrder(root);
		int[] in = Inorder(root);
		int[] rev = RevOrder(root);

		int[][] res = new int[3][pre.length];
		res[0] = pre;
		res[1] = in;
		res[2] = rev;

		return res;
	}

	// 非递归前序遍历二叉树
	public int[] preOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();// 用一个栈存储节点
		stack.push(root);

		ArrayList<Integer> value = new ArrayList<>();
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();
			stack.pop();

			value.add(cur.val);

			if (cur.right != null) {// 先加入右节点 因为栈是先进后出的数据结构 这样才满足先序遍历的输出顺序
				stack.push(cur.right);
			}

			if (cur.left != null) {
				stack.push(cur.left);
			}
		}

		int[] res = new int[value.size()];

		for (int i = 0; i < res.length; i++) {
			res[i] = value.get(i);
		}

		return res;
	}

	// 非递归中序遍历二叉树
	public int[] Inorder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;

		ArrayList<Integer> value = new ArrayList<>();

		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {// 不断的将当前节点的左节点加入栈中
				stack.push(cur);
				cur = cur.left;
			}

			if (!stack.isEmpty()) {
				TreeNode temp = stack.peek();// 弹出栈顶节点
				stack.pop();
				value.add(temp.val);
				cur = temp.right;// 指向当前节点的右节点
			}
		}

		int[] res = new int[value.size()];

		for (int i = 0; i < res.length; i++) {
			res[i] = value.get(i);
		}

		return res;
	}

	// 非递归后序遍历二叉树
	public int[] RevOrder(TreeNode root) {
		TreeNode h = root;// 代表最近一次打印输出的节点
		TreeNode c = null;
		Stack<TreeNode> stack = new Stack<>();

		stack.push(root);
		ArrayList<Integer> value = new ArrayList<>();
		while (!stack.isEmpty()) {
			c = stack.peek();

			if (c.left != h && c.right != h && c.left != null) {// 当前节点c的左右节点都不等于h同时左子树不为空，说明左孩子还没有打印
																// 则左子树入栈
				stack.push(c.left);
			} else if (c.right != h && c.right != null) {// 当前节点c的右节点不等于h同时右节点不为空，说明右节点还没有打印过
															// 所以把右节点加入栈中
				stack.push(c.right);
			} else {// 都不满足上面的情况的话 说明要打印当前节点了 同时令h=c 因为c刚刚完成输出
				value.add(c.val);
				stack.pop();
				h = c;
			}
		}

		int[] res = new int[value.size()];

		for (int i = 0; i < res.length; i++) {
			res[i] = value.get(i);
		}

		return res;
	}
}