class LonelyA {
public:
    int getWays(int n, int A, int b, int c) {//先算整体的全排列 然后减去A分别于其中一个人的全排列 但是这时会重复多减一部分公共的排列，加上
        int total=jiecheng(n,n);
        int aa=jiecheng(n-1,n-1)*2;
        int bb=aa;
        int cc=jiecheng(n-2,n-2)*2;
         
        return total-aa-bb+cc;
    }
     
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
     
    int C(int m,int n)
    {
        return jiecheng(m,n)/jiecheng(n,n);
    }
};