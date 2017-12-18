#include <iostream>
using namespace std;


const int N=300;

//dp[i][j]=k 代表字符串A[0...i-1]和字符串B[0...j-1]的最长公共子序列长度为k
int dp[N+1][N+1];


class LCS {
public:
    int findLCS(string A, int n, string B, int m) {
        int i,j;
		int flag=0;
		for(i=0;i<n;i++){//初始化第一列，字符串A[0...n-1]和字符串B第0个字符的最长公共子序列长度
			if(flag==1||A.at(i)==B.at(0)){//当在对应位置字符相等后，则一直为1
				dp[i][0]=1;
				flag=1;
			}else{//否则为0
				dp[i][0]=0;
			}
		}

		flag=0;

		for(j=0;j<m;j++){//初始化第一行，原理同上。字符串调换了一下
			if(flag==1||A.at(0)==B.at(j)){
				dp[0][j]=1;
				flag=1;
			}else{
				dp[0][j]=0;
			}
		}

		for(i=1;i<n;i++){
			for(j=1;j<m;j++){
				if(A.at(i)==B.at(j)){//i位置字符和j位置字符相等，有3个可能值
					int val_1=dp[i-1][j-1]+1;//等于i-1和j-1的长度+1
					int val_2=dp[i-1][j];//等于i-1和j的长度，因为可能在i-1处就已经和j处有最长公共了，
					int val_3=dp[i][j-1];//等于i和j-1的长度，可能在j-1处就有和i最长的公共了

					dp[i][j]=max(val_1,val_2);
					dp[i][j]=max(dp[i][j],val_3);
				}else{//i位置字符和j位置字符不相等，有2个可能值，就少了第一种情况
					int val_1=dp[i-1][j];
					int val_2=dp[i][j-1];
					dp[i][j]=max(val_1,val_2);
				}
			}
		}

		return dp[n-1][m-1];
    }

	int max(int a,int b){
		return a>b?a:b;
	}
};