/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};*/
 
class MaxSubtree {
public:
    TreeNode* getMax(TreeNode* root) {
         
        int max,min,nums;
 
        return MaxSearchNode(root, max,  min, nums);
    }
     
    int max(int a,int b)
    {
        return a>b?a:b;
    }
 
    int min(int a,int b)
    {
        return a>b?b:a;
    }
 
    TreeNode * MaxSearchNode(TreeNode * root,int &maxNode,int &minNode,int &totalNode)
    {
        if(root==NULL)
        {
            maxNode=-9999;
            minNode=9999;
            totalNode=0;
            return NULL;
        }
 
        int lmax,lmin,lnum;
        TreeNode * lnode=MaxSearchNode(root->left,lmax,lmin,lnum);// 左子树节点以及相关信息
 
        int rmax,rmin,rnum;
        TreeNode * rnode=MaxSearchNode(root->right,rmax,rmin,rnum);// 右子树节点以及相关信息

 
        maxNode=max(rmax,root->val);// 更新最大值
        minNode=min(lmin,root->val);// 更新最小值
 	// 如果当前节点大于左孩子的最大值 小于右孩子的最小值 则包含这个节点也是二叉搜索树
        if(lmax<root->val&&rmin>root->val&&lnode==root->left&&rnode==root->right)
        {
            totalNode=lnum+rnum+1;// 更新节点个数
            return root;// 返回头节点
        }
 
        if(lnum>rnum)// 说明不满足上面的条件 选择左右节点中较多节点的子树更新节点个数
        {
            totalNode=lnum;
            return lnode;
        }
        else
        {
            totalNode=rnum;
            return rnode;
        }
    }
};