#include <iostream>
#include <vector>
using namespace std;
 
 
class Backpack {
public:
 
     
    int max(int a,int b)
    {
        return a>b?a:b;
    }
 
    int maxValue(vector<int> w, vector<int> v, int n, int cap) {
         
        int **dp=new int *[n+1];
        int i,j;
        for(i=0;i<n;i++)
        {
            dp[i]=new int [cap+1];
        }
        
	//dp[i][j]=k 表示在最大承重j下使用0..i件物品组成的最大总价值为k 
        for(i=0;i<=cap;i++)//初始化第一行，当背包容量大于w[0]时，可以放入
        {
            if(i>=w[0])
            {
                dp[0][i]=v[0];
            }
            else
            {
                dp[0][i]=0;
            }
        }
 
        for(i=1;i<n;i++)
        {
            for(j=0;j<=cap;j++)
            {
                if(j-w[i]>=0)//比较使用第i件物品和不使用第i件物品的总价值，取大的那个，前提是当前背包承重能放入第i件物品的重量
                {
                    dp[i][j]=max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }
                else//当前背包承重不能放入第i件物品，所以只能默认不使用第i件物品
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
         
        return dp[n-1][cap];
    }
};