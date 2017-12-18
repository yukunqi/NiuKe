#include <iostream>
using namespace std;

const int N=500;

//dp[i]=k代表以数组i索引位置结尾的最长上升子序列长度为k 
int dp[N+1];

class LongestIncreasingSubsequence {
public:
    int getLIS(vector<int> A, int n) {
        dp[0]=1;//数组第一个数的最长上升子序列就是本身，所以为1
		int temp;
		int max=0;
		for(int i=1;i<n;i++){
			temp=0;
			for(int j=i-1;j>=0;j--){//从第i个数往前寻找比第i个数小的作为上升子序列，然后在这个过程中找到已知序列最长的那个。这样再加上第i个数本身使得最长子序列最长
				if(A[i]>A[j]&&dp[j]>temp){
					temp=dp[j];
				}
			}
			dp[i]=temp+1;
			if(dp[i]>max){
				max=dp[i];
			}
		}

		return max;
    }
};