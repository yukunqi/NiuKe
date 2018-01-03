class Rotation {
public:
    bool chkRotation(string A, int lena, string B, int lenb) {
        if(lena!=lenb)
        {
            return false;
        }
        A=A+A;//A字符串自身拼接
        int res=kmpSearch(A,lena+lena,B,lenb);//查找大字符串中是否存在B字符串
        return res!=-1;
    }

    //KMP算法 查找A字符串中是否包含B字符串 若存在返回第一个字符的索引位置，若不存则返回-1  具体详解请看http://www.jianshu.com/p/826480d851ee
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
    //生成next数组
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