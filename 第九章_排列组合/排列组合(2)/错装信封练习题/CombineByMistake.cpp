#include <iostream>
using namespace std;

/*
 * 这是一个动态规划问题：
 * 假设n封信不装回回来信封的装法有f(n)种
 * 那么如果第n封信装入第i个信封：出现两种情况：
 * 1.第i封信装第n个信封(相当于两者互换) 则还有n-2封信f(n-2)种装法
 * 2.第i封信不装第n个信封(两者不互换) 则还有n-1封信要装 f(n-1)
 * 然后每一封信都是这样的一个情况 那么f(n)=(n-1)*(f(n-1)+f(n-2))
 */
class CombineByMistake {
public:
    int countWays(int n) {
		if(n<=1){
			return 0;
		}else if (n==2){
			return 1;
		}else{
			long *dp=new long [300+1];
			dp[0]=0;
			dp[1]=0;
			dp[2]=1;

			for(int i=3;i<=n;i++){
				dp[i]=(i-1)*(dp[i-2]+dp[i-1])%1000000007;
			}

			return (int)dp[n];
		}
    }
};