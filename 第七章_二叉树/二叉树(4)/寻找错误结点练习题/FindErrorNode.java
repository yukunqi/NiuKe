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
public class FindErrorNode {
	public int[] findError(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<>();
		Inorder(root, list);
		int time = 0;
		int pos1 = 0;// 位置1
		int pos2 = 0;// 位置2
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) < list.get(i - 1) && time == 0) {// 当出现第一次降序过程的时候
				pos1 = i - 1;// 取较大的那个元素
				time++;
			} else if (list.get(i) < list.get(i - 1) && time == 1) {// 当第二次出现降序过程的时候
				pos2 = i;// 取较小的那个元素
				time++;
			}
		}
		int[] res = new int[2];// 值的大小顺序是升序

		if (time == 2) {// 有2次降序过程 对应有2个位置出错
			res[0] = list.get(pos2);
			res[1] = list.get(pos1);
		} else if (time == 1) {// 有1次降序过程 对应出错只在一个位置
			res[0] = list.get(pos1 + 1);
			res[1] = list.get(pos1);
		}
		return res;
	}

	// 中序遍历获得元素的数组
	public void Inorder(TreeNode root, ArrayList<Integer> res) {
		if (root == null) {
			return;
		}

		Inorder(root.left, res);
		res.add(root.val);
		Inorder(root.right, res);
	}
}