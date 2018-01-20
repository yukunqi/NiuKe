class Rotation {
public:
    bool chkRotation(string A, int lena, string B, int lenb) {
        if(lena!=lenb)
        {
            return false;
        }
        A=A+A;
        int res=kmpSearch(A,lena+lena,B,lenb);
        return res!=-1;
    }
 
    int kmpSearch(string A,int lena,string B,int lenb){
        int i=0,j=0;
 
        int *next=generateNext(B,lenb);
 
        while(i<lena&&j<lenb)
        {
            if(j==-1||A.at(i)==B.at(j))
            {
                i++;
                j++;
            }
            else
            {
                j=next[j];
            }
        }
        if(j==lenb)
        {
            return i-j;
        }
        else
        {
            return -1;
        }
    }
 
    int * generateNext(string B,int lenb){
        int j,k;
        j=0;k=-1;
        int * next=new int [lenb];
        next[0]=-1;
         
        while(j<lenb-1)
        {
            if(k==-1||B.at(k)==B.at(j))
            {
                k++;
                j++;
                if(B.at(k)!=B.at(j))
                {
                    next[j]=k;
                }
                else
                {
                    next[j]=next[k];
                }
            }
            else
            {
                k=next[k];
            }
        }
 
        return next;
    }
};