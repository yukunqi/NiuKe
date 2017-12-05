package niuke;

// 01背包练习题
public class Backpack {
	public int maxValue(int[] w, int[] v, int n, int cap) {
		int dp[][] = new int[n][cap + 1];// 表示 dp[i][j] 使用0..i物品组成J承重的最大价值

		for (int i = 0; i <= cap; i++) {// 赋值第一行 使用第一个物品 只有当j大于第一个物品重量时才可以使用
			if (w[0] <= i) {
				dp[0][i] = v[0];
			} else {
				dp[0][i] = 0;
			}
		}

		for (int i = 0; i < n; i++) {// 承重为0时 无论如何价值都为0
			dp[i][0] = 0;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= cap; j++) {
				if (j >= w[i]) {// 遇到第i个物品时 选择装入或者不装入 取价值最大的那种 在背包承重允许的情况下
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
				} else {// 背包承重不允许装i物品 那直接赋值不装入
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n - 1][cap];
	}
}
