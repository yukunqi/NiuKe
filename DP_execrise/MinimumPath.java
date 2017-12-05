package niuke;

//矩阵最小路径和练习题
public class MinimumPath {
	public int getMin(int[][] map, int n, int m) {
		int dp[][] = new int[n][m];// dp[i][j] 代表走到i j位置的最小路径和

		for (int i = 0; i < n; i++) {// 初始化第一列
			dp[i][0] = i == 0 ? map[i][0] : map[i][0] + dp[i - 1][0];
		}

		for (int i = 0; i < m; i++) {// 初始化第一行
			dp[0][i] = i == 0 ? map[0][i] : map[0][i] + dp[0][i - 1];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				dp[i][j] = map[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);// 选择上方或者左方中小的一个
			}
		}

		return dp[n - 1][m - 1];
	}
}
