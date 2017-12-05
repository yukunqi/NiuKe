package niuke;

//×îÓÅ±à¼­Á·Ï°Ìâ
public class MinCost {
	public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
		int dp[][] = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = c1 * i;
		}

		for (int i = 0; i <= m; i++) {
			dp[0][i] = c0 * i;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (A.charAt(i - 1) == B.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
					dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j] + c1, dp[i][j - 1] + c0));
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1] + c2, Math.min(dp[i - 1][j] + c1, dp[i][j - 1] + c0));
				}
			}
		}

		return dp[n][m];
	}
}
