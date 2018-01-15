public class QuickPower {
	public int getPower(int k, int N) {

		if (N == 0) {
			return 1;
		}
		long res = 1;
		long temp = k;
		for (int i = N; i > 0; i >>= 1) {// 右移一位
			if ((i & 1) != 0) {// 位运算 若不等于0 说明此时i的二进制末尾为1 要进行计算
				res *= temp;
			}
			temp = (temp * temp) % 1000000007;
			res = res % 1000000007;
		}

		return (int) res;
	}
}