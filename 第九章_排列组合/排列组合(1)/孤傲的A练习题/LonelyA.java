public class LonelyA {
	public int getWays(int n, int A, int b, int c) {
		int count1 = C(n - 3, 1) * jiecheng(n - 2, n - 2) * 2;//当A在开头和末尾时的排列情况 当A开头时 因为不和另外两个相邻 就在n-3个人中选一个然后剩下的n-2人全排列 在末尾也是一样
		int count2 = C(n - 3, 2) * jiecheng(n - 3, n - 3) * (n - 2) * 2;//当A在中间的时候 要从n-3个人中选2个和A相邻 然后剩下的人全排列 这两个人又可以调换位置所以要乘以2 然后再乘上中间剩下的n-2的位置 因为每个位置都一样
		return count1 + count2;
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
}