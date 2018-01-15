public class MinValue {
	public int getMin(int[] arr, int n) {
		int low = 0;
		int high = n - 1;
		int res = 0;

		while (low <= high) {
			if (arr[low] < arr[high]) {// 若high大于low 说明在low到high之间整体有序
										// 此时返回low的值则为最小值
				res = arr[low];
				break;
			} else {

				if (high - low == 1) {// 当数组中只有两个元素时 返回小的那个
					return Math.min(arr[low], arr[high]);
				}

				int mid = low + (high - low) / 2;
				if (arr[mid] > arr[high]) {// 当中间值大于最右边的值时 最小值出现在右边
					low = mid;
				} else if (arr[mid] < arr[low]) {// 当中间值小于最左边值的时候 最小值出现在左边
					high = mid;
				} else {// 若不满足以上的情况 则说明 low mid high 三者相等
						// 此时通过遍历low和high之间的值来获得最小值
					res = getMin(arr, low, high);
					break;
				}
			}
		}

		return res;

	}

	public int getMin(int[] arr, int low, int high) {
		int min = arr[low];
		for (int i = low; i <= high; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
}