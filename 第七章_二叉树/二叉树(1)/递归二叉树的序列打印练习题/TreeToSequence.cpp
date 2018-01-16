/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};*/
 
class TreeToSequence {
public:
    vector<vector<int> > convert(TreeNode* root) {
        TreeNode * root1=root;
        vector<int> list1;
        preOrder(root1,list1);
         
        TreeNode *root2=root;
        vector<int >list2;
        InOrder(root2,list2);
 
        TreeNode *root3=root;
        vector<int> list3;
        ReverseOrder(root3,list3);
 
        vector< vector<int> >  res;
         
        res.push_back(list1);
        res.push_back(list2);
        res.push_back(list3);
        return res;
    }
    // 二叉树前序遍历
    void preOrder(TreeNode * root,vector<int> &list)
    {
        if(root==NULL)
        {
            return ;
        }
         
        list.push_back(root->val);
        preOrder(root->left,list);
        preOrder(root->right,list);
 
    }
    // 二叉树中序遍历
    void InOrder(TreeNode * root,vector<int> &list)
    {
        if(root==NULL)
        {
            return ;
        }
         
        InOrder(root->left,list);
        list.push_back(root->val);
        InOrder(root->right,list);
    }
    // 二叉树后序遍历
    void ReverseOrder(TreeNode * root,vector<int> &list)
    {
                if(root==NULL)
        {
            return ;
        }
         
        ReverseOrder(root->left,list);
        ReverseOrder(root->right,list);
        list.push_back(root->val);
    }
     
};