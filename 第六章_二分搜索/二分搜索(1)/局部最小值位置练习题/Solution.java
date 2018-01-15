
//这道题需要注意的是 牛客OJ在判断的时候是按照老师的答案来的 所以在当出现可以向左右两边选择二分的时候 请参考这里代码的顺序
public class Solution {
	public int getLessIndex(int[] arr) {

		int res = -1;

		if (arr == null || arr.length == 0) {
			return res;
		}

		if (arr.length == 1) {
			return 0;
		}

		int low = 0;
		int high = arr.length - 1;
		if (low == 0 && arr[low] < arr[low + 1]) {// 最左边判断局部最小
			return 0;
		}

		if (high == arr.length - 1 && arr[high - 1] > arr[high]) {// 最右边判断局部最小
			return arr.length - 1;
		}

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
				res = mid;
				break;
			}

			if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
				high = mid;
			} else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
				low = mid;
			} else {// 当mid值大于两边时，缩小范围到左边半部分 若选择右边则可能OJ会判错
				high = mid;
			}
		}

		return res;
	}
}