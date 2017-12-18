#include <iostream>
using namespace std;


const int N=100;

int dp[N+1][N+1];

class MinimumPath {
public:
    int getMin(vector<vector<int> > map, int n, int m) {
        int i;

		for(i=0;i<m;i++){//初始化第一列 
			dp[0][i]=(i==0)?map[0][i]:dp[0][i-1]+map[0][i];
		}

		for(i=0;i<n;i++){//初始化第一行
			dp[i][0]=(i==0)?map[i][0]:dp[i-1][0]+map[i][0];
		}

		for(i=1;i<n;i++){
			for(int j=1;j<m;j++){
				if(dp[i-1][j]>dp[i][j-1]){//dp[i][j]可以由上一列向右走或者上一行向下走得到，选最小的即可
					dp[i][j]=dp[i][j-1]+map[i][j];
				}else{
					dp[i][j]=dp[i-1][j]+map[i][j];
				}
			}
		}

		return dp[n-1][m-1];
    }
};