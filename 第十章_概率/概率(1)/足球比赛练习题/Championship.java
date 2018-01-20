public class Championship {
	public int[] calc(int k) {
		int fenmu = jishujiecheng(2 * k);
		int fenzi = C(k + 1, k - 1) * jiecheng(k - 1, k - 1);
		int yue = gcd(fenmu, fenzi);
		fenmu = fenmu / yue;
		fenzi = fenzi / yue;
		int[] res = new int[2];
		res[0] = fenmu - fenzi;
		res[1] = fenmu;
		return res;
	}

	// Cmn的排列组合 Cmn=m!/n!(m-n)!
	public int C(int m, int n) {
		return jiecheng(m, n) / jiecheng(n, n);
	}

	// 数字n的time次阶乘
	public int jiecheng(int n, int time) {
		int res = 1;
		for (int i = n; time > 0; i--) {
			res *= i;
			time--;
		}
		return res;
	}

	// n的奇数阶乘 1*3*5...2n-1
	public int jishujiecheng(int n) {
		int res = 1;
		for (int i = 1; i < n; i += 2) {
			res *= i;
		}
		return res;
	}

	// 辗转相除法求最大公约数 要求m>n
	public int gcd(int m, int n) {
		while (true) {
			if ((m = m % n) == 0) {
				return n;
			}
			if ((n = n % m) == 0) {
				return m;
			}
		}
	}
}