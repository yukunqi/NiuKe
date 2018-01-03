class Parenthesis {
public:
    bool chkParenthesis(string A, int n) {
        int i;
        int num=0;
        for(i=0;i<n;i++)
        {
            if(A[i]=='(')
            {
                num++;
            }
            if(A[i]==')')
            {
                num--;
            }
            if(num<0)
            {
                return false;
            }
        }
 
        return num==0;
    }
};