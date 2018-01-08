public class MaxTree {
	public int[] buildMaxTree(int[] A, int n) {
		int res[] = new int[n];
		for (int i = 0; i < n; i++) {// 遍历每个值去获取结果
			res[i] = getIndex(i, A, n);
		}
		return res;
	}

	public int getIndex(int target, int[] A, int n) {
		int left = -1;// 左边第一个比它大的数索引
		int right = n;// 右边第一个比它大的数索引

		for (int i = target + 1; i < n; i++) {// 更新右索引
			if (A[i] > A[target]) {
				right = i;
				break;
			}
		}

		for (int i = target - 1; i >= 0; i--) {// 更新左索引
			if (A[i] > A[target]) {
				left = i;
				break;
			}
		}

		if (left == -1 && right == n) {// 当两个索引都没变化，说明左右两边都没有比它大的数，根节点返回-1
			return -1;
		} else if (left != -1 && right != n) {// 两个索引都发生变化了，此时返回元素更小的那个索引
			return A[left] > A[right] ? right : left;
		} else if (left != -1 && right == n) {// 同理 返回左边
			return left;
		} else if (left == -1 && right != n) {// 右索引有变化，左索引没有。说明右边更小并返回
			return right;
		}

		return 0;
	}
}