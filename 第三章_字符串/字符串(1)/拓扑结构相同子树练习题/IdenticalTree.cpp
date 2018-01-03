/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};*/

class IdenticalTree {
public:
    bool chkIdentical(TreeNode* A, TreeNode* B) {
        string strA;
        Serialization(A,strA);
        string strB;
        Serialization(B,strB);
 		//判断在A串中是否有B串存在
        int res=kmpSearch(strA,strA.size(),strB,strB.size());
 
        return res!=-1;
    }
	//序列化字符串
	string Serialization(TreeNode *A,string &s){
		if(A==NULL){
			s+="#!";
			return s;
		}

		char ch=A->val+'0';
		s+=ch;
		s+='!';
		
		Serialization(A->left,s);
		Serialization(A->right,s);

		return s;
	}
	
	//kmp算法 具体详解请看http://www.jianshu.com/p/826480d851ee
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
	int * generateNext(string B,int lenb)
    {
        int j,k;
        j=0;
        k=-1;
        int * next=new int [lenb];
        next[0]=-1;
        while(j<lenb-1)
        {
            if(k==-1||B.at(k)==B.at(j))
            {
                j++;
                k++;
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