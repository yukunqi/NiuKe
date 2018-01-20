class Parenthesis {
public:
    int countLegalWays(int n) {
        return C(2*n,n)/(n+1);
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