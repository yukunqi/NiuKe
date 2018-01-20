public class StandInLine {
	public int[] getWays(int n, int a, int b) {
		int answer1 = jiecheng(n, n) / 2;// 全排列之后 因为a和b只有两种情况 要不a在b左边 要不a在b右边
											// 所以取一半即可
		int answer2 = jiecheng(n - 1, n - 1);// 要求相邻 则捆绑成一个人然后进行n-1全排列即可
		int[] res = new int[2];
		res[0] = answer1;
		res[1] = answer2;
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
}