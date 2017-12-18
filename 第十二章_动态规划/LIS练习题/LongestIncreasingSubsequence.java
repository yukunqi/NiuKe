package niuke;

//LIS练习题
public class LongestIncreasingSubsequence {
	public int getLIS(int[] A, int n) {
		int dp[] = new int[n];// dp[i] 表示最后一个字符为A[i]时的最长上升子序列的长度

		dp[0] = 1;

		int res = 0;
		for (int i = 1; i < n; i++) {

			int j = i;
			int max = 0;
			for (; j >= 0; j--) {// 每次从i位置向前遍历找到比i小的位置 取这些位置中子序列长度最长的作为上一个序列
				if (A[j] < A[i] && dp[j] > max) {
					max = dp[j];
				}
			}
			dp[i] = max + 1;
			res = Math.max(dp[i], res);// 记录整个过程中最长的上升子序列
		}

		return res;
	}
}
