package niuke;

//台阶问题练习题
public class GoUpstairs {
	public int countWays(int n) {
		int dp[] = new int[n + 1];// dp[i] 表示上i个台阶的方法数

		dp[1] = 1;// 初始化dp[1]上一个台阶就一种方法
		dp[2] = 2;// 上二个台阶就2种 一次上一个台阶或者一次上2个台阶

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
		}

		return dp[n];
	}
}
