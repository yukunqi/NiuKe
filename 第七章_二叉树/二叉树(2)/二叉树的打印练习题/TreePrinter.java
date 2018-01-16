import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
		if (root == null) {
			return null;
		}
		TreeNode last = root;
		TreeNode nlast = null;
		List<ArrayList<Integer>> list = new ArrayList();// 创建一个装载Arraylist的集合list
		ArrayList<Integer> int_list = new ArrayList();// 创建一个装载整型数字的数组
		Queue<TreeNode> queue = new LinkedList();// 创建一个队列 使用栈就不对了
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			int_list.add(temp.val);
			if (temp.left != null) {// 把当前节点左节点加入队列中 注意队列是先进先出的数据结构 这里打印的要求是从左到右
									// 所以要注意左右节点加入队列的顺序
				queue.offer(temp.left);
				nlast = temp.left;
			}
			if (temp.right != null) {// 把当前节点右节点加入队列中
				queue.offer(temp.right);
				nlast = temp.right;
			}
			if (last == temp) {// 到了一行的末尾
				list.add(int_list);
				int_list = new ArrayList();
				last = nlast;// 更新last
			}
		}
		int[][] result = new int[list.size()][];
		int count = 0;
		for (int i = 0; i < list.size(); i++) {// 赋值保存结果并返回
			int_list = list.get(i);
			result[i] = new int[int_list.size()];
			for (int j = 0; j < int_list.size(); j++) {
				if (count <= 500) {
					result[i][j] = int_list.get(j);
					count++;
				}

			}
		}
		return result;
	}
}