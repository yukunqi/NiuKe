/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};*/
 
class FindErrorNode {
public:
    vector<int> findError(TreeNode* root) {
        vector<int> res;
        InOrderFindError(root,res);
        int i;
        int pos1=0;// 位置1
        int pos2=0;// 位置2
        int t=0;
        for(i=1;i<res.size();i++)
        {
            if(res[i]<res[i-1]&&t==0)// 当出现第一次降序过程的时候
            {
                pos1=i-1;// 取较大的那个元素
                t++;
            }
            else if(res[i]<res[i-1]&&t==1)// 当第二次出现降序过程的时候
            {
                pos2=i;// 取较小的那个元素
                t++;
            }
        }
 
        vector<int> arr;// 值的大小顺序是升序
        if(t==1)// 有1次降序过程 对应出错只在一个位置
        {
            arr.push_back(res[pos1+1]);
            arr.push_back(res[pos1]);
        }
        else if(t==2)// 有2次降序过程 对应有2个位置出错
        {
            arr.push_back(res[pos2]);
            arr.push_back(res[pos1]);
        }
 
        return arr;
    }
    // 中序遍历获得元素的数组
    void InOrderFindError(TreeNode * root,vector<int> &res)
    {
        if(root==NULL)
        {
            return ;
        }
 
        InOrderFindError(root->left,res);
        res.push_back(root->val);
        InOrderFindError(root->right,res);
    }
};