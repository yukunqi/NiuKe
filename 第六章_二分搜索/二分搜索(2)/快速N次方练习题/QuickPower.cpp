const int MOD=1000000007;
  
class QuickPower {
public:
    int getPower(int k, int N) {
              
        long res=1;
        long temp=k;
        for(;N>0;N>>=1)// 右移一位
        {
            if(N&1==1)// 位运算 若不等于0 说明此时i的二进制末尾为1 要进行计算
            {
                res*=temp;
            }
            temp=(temp*temp)%MOD;
            res%=MOD;
        }
  
        return res;
    }
};