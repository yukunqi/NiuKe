import java.util.*;
 
public class Exchange {
   public int countWays(int[] penny, int n, int aim) {
        int dp[][] = new int[n][aim + 1];// dp[i][j] 代表 使用0..i种货币组成钱数j的方法数
 
        for (int i = 0; i < n; i++) {// 初始化第一列 组成钱数0的方法数为1
            dp[i][0] = 1;
        }
 
        for (int i = 0; i <= aim; i++) {// 初始化第一行 使用第0种货币组成钱数j的方法数
            if (i % penny[0] == 0) {
                dp[0][i] = 1;
            }
        }
 
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= aim; j++) {
                if (j >= penny[i]) {//当钱数大于第i个货币的面值时才有可能使用第i个货币
                    dp[i][j] = dp[i - 1][j] + dp[i][j - penny[i]];
		    /*这个公式是这样来的：
                    dp[i][j]的来源:
                      1.使用m张(m=0,1,2...)i货币组成j的方法数(使用0张dp[i-1][j-0*penny[i]],使用1张dp[i-1][j-1*penny[i]],使用2张dp[i-1][j-2*penny[i]].....)
                       
                      上面的公式其实就是把m=0和情况拆分了出来，后面的dp[i][j-penny[i]]表示m=1开始的情况
                      为什么dp[i][j-penny[i]]能表示m=1的情况呢？ 其实你看这个式子带回到上面就是使用m张i货币组成j-penny[i]的方法数
                    */	
                } else {//钱数小于penny[i]，不能使用i货币 只能使用i-1个货币去组成钱数J
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
 
        return dp[n - 1][aim];
    }
}