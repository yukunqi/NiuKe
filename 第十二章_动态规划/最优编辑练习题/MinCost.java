package niuke;

//最优编辑练习题
public class MinCost {
	public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
		int dp[][] = new int[n + 1][m + 1];//dp[i][j]=k 代表字符串A[0..i-1]变成字符串B[0...j-1]需要的最小代价为k

		for (int i = 0; i <= n; i++) {//初始化第一列，字符串A[0..i-1]变成空串的代价就是删除i个字符
			dp[i][0] = c1 * i;
		}

		for (int i = 0; i <= m; i++) {//初始化第一行，空串A变成字符串B[0...i-1]的代价就是插入i个字符
			dp[0][i] = c0 * i;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {//当i位置和j位置字符相等时，有3个可能值
					dp[i][j] = dp[i - 1][j - 1];
					dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j] + c1, dp[i][j - 1] + c0));
				} else {//当i位置和j位置字符不相等时，有3个可能值
					dp[i][j] = Math.min(dp[i - 1][j - 1] + c2, Math.min(dp[i - 1][j] + c1, dp[i][j - 1] + c0));
				}
			}
		}

		return dp[n][m];
	}
}
