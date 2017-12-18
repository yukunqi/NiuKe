#include <iostream>
using namespace std;

const int N=100000;
const int MOD=1000000007;


//dp[i]=k 代表上i个台阶的方法数为k
int dp[N+1];

class GoUpstairs {
public:
    int countWays(int n) {
        dp[1]=1;//上一个台阶只有一种方法
		dp[2]=2;//上两个台阶有两种，一次上一级或者一次上两级

		for(int i=3;i<=n;i++){
			dp[i]=(dp[i-1]+dp[i-2])%MOD;
			/*那么其实上第i级台阶可以依赖于两种情况得到:
			  1.一种就是上了i-1级之后再上一级
			  2.一种就是上了i-2级之后再上二级

			  两种相加即可得到
			*/
		}

		return dp[n];
    }
};