import java.util.ArrayList;

public class SlideWindow {
	public int[] slide(int[] arr, int n, int w) {
		ArrayList<Integer> list = new ArrayList<>();// 双端队列 保存数组下标索引
		int[] res = new int[n - w + 1];// 存放最大值结果数组

		for (int i = 0; i < n; i++) {
			if (!list.isEmpty() && list.get(0) <= i - w) {// 当队列的头元素超出了当前滑动窗口的范围时，就移除。
				list.remove(0);
			}

			while (!list.isEmpty() && arr[list.get(list.size() - 1)] < arr[i]) {// 当前队列的队尾元素的值小于数组值，移除队尾元素
				list.remove(list.size() - 1);
			}

			if (list.isEmpty() || arr[list.get(list.size() - 1)] > arr[i]) {// 队尾元素大于数组元素，加入当前索引
				list.add(i);
			}

			if (i >= w - 1) {// 赋值最大值
				res[i - w + 1] = arr[list.get(0)];
			}
		}

		return res;
	}
}