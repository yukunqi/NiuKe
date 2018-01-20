class Robot {
public:
    int countWays(int x, int y) {// x行y列 则能向右走y-1步 向下走x-1步
        return C(x-1+y-1,x-1);
    }
    // 数字n的time次阶乘
    int jiecheng(int n,int time)
    {
        int res=1;
         
        for(int i=n;time>0;i--)
        {
            res*=i;
            time--;
        }
 
        return res;
    }
    // Cmn的排列组合 Cmn=m!/n!(m-n)!
    int C(int m,int n)
    {
        return jiecheng(m,n)/jiecheng(n,n);
    }
};