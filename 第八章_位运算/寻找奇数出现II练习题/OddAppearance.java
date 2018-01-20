import java.util.Arrays;

public class OddAppearance {
	public int[] findOdds(int[] arr, int n) {
		int e = 0;
		for (int i = 0; i < n; i++) {// 经过一次遍历得到两个出现奇数次数的异或值
			e = e ^ arr[i];
		}
		int flag = kpos(e);// 获得第k位上是1的数其余位为0
		int res[] = new int[2];
		res[0] = 0;
		res[1] = 0;
		for (int i = 0; i < n; i++) {
			if ((arr[i] & flag) == flag) {// 同样是第k位为1的数
				res[0] = res[0] ^ arr[i];
			} else {// 第k位为0的数
				res[1] = res[1] ^ arr[i];
			}
		}
		Arrays.sort(res);
		return res;
	}

	// 返回和num与操作后第i位上是1的数
	public int kpos(int num) {
		int pos = 0;
		for (int i = 0; i < 32; i++) {
			pos = (1 << i);
			if ((pos & num) != 0) {
				break;
			}
		}
		return pos;
	}
}