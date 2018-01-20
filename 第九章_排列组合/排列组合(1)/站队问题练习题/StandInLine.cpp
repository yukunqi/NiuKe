class StandInLine {
public:
    vector<int> getWays(int n, int a, int b) {
        vector<int> res(2,0);
        res[0]=jiecheng(n,n)/2;// 全排列之后 因为a和b只有两种情况 要不a在b左边 要不a在b右边 所以取一半即可
        res[1]=jiecheng(n-1,n-1);// 要求相邻 则捆绑成一个人然后进行n-1全排列即可
         
        return res;
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
};