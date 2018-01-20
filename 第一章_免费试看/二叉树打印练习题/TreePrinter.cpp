/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};*/
 
class TreePrinter {
public:
    vector<vector<int> > printTree(TreeNode* root) {
        vector< vector<int> > v;
        vector<int> v1;
         
        queue<TreeNode *> q;
 
        q.push(root);
 
        TreeNode *last=NULL;
        TreeNode *nlast=NULL;
        last=root;
        while(!q.empty())
        {
            TreeNode *temp=q.front();
            q.pop();
            v1.push_back(temp->val);
 
            if(temp->left!=NULL)
            {
                q.push(temp->left);
                nlast=temp->left;
            }
 
            if(temp->right!=NULL)
            {
                q.push(temp->right);
                nlast=temp->right;
            }
 
            if(temp==last)
            {
                v.push_back(v1);
                v1.clear();
                last=nlast;
            }
        }
 
        return v;
    }
};