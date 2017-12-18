#include <iostream>
using namespace std;


const int N=300;

//dp[i][j]=k 代表字符串A[0..i-1]变成字符串B[0...j-1]需要的最小代价为k
int dp[N+1][N+1];


class MinCost {
public:
    int findMinCost(string A, int n, string B, int m, int c0, int c1, int c2) {
		int i,j;
		
		for(i=0;i<=n;i++){//初始化第一列，字符串A[0..i-1]变成空串的代价就是删除i个字符
			dp[i][0]=i*c1;
		}

		for(i=0;i<=m;i++){//初始化第一行，空串A变成字符串B[0...i-1]的代价就是插入i个字符
			dp[0][i]=i*c0;
		}

		for(i=1;i<=n;i++){
			for(j=1;j<=m;j++){
				if(A.at(i-1)==B.at(j-1)){//当i位置和j位置字符相等时，有3个可能值
					int val_1=dp[i-1][j-1];//就等于i-1变成j-1的代价
					int val_2=dp[i-1][j]+c1;//等于i-1变成j串，然后删除一个i字符
					int val_3=dp[i][j-1]+c0;//等于i变成j-1串，插入一个j字符

					dp[i][j]=min(val_1,val_2);
					dp[i][j]=min(dp[i][j],val_3);
				}else{//当i位置和j位置字符不相等时，有3个可能值
					int val_1=dp[i-1][j]+c1;//等于i-1变成j串，然后删除一个i字符
					int val_2=dp[i][j-1]+c0;//等于i变成j-1串，插入一个j字符
					int val_3=dp[i-1][j-1]+c2;//等于i-1变成j-1串，然后替换i字符变成j字符
					
				    dp[i][j]=min(val_1,val_2);
					dp[i][j]=min(dp[i][j],val_3);
				}
			}
		}

		return dp[n][m];
    }

	int min(int a,int b){
		return a>b?b:a;
	}
};