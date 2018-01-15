public class Find {
	public int findPos(int[] arr, int n) {
		int low = 0;
		int high = n - 1;
		int res = -1;
		while (low <= high) {// 二分搜索
			int mid = low + (high - low) / 2;

			if (arr[mid] == mid) {// 当i==arr[i]时记录 下标 继续左半部分搜索
				res = mid;
				high = mid - 1;
			} else if (arr[mid] > mid) {// 因为是有序无重复元素数组 若此时元素大于下标 而下标的增加是1
										// 元素最小的变化也是1索引不可能再出现相等的情况
				high = mid - 1;
			} else {// 同理 缩小范围到右半部分
				low = mid + 1;
			}
		}
		return res;
	}
}