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
         
        queue<TreeNode *> q;// 创建一个队列 使用栈就不对了
 
        q.push(root);
 
        TreeNode *last=NULL;
        TreeNode *nlast=NULL;
        last=root;
        while(!q.empty())
        {
            TreeNode *temp=q.front();
            q.pop();
            v1.push_back(temp->val);
 
            if(temp->left!=NULL)// 把当前节点左节点加入队列中 注意队列是先进先出的数据结构 这里打印的要求是从左到右 所以要注意左右节点加入队列的顺
            {
                q.push(temp->left);
                nlast=temp->left;
            }
 
            if(temp->right!=NULL)// 把当前节点右节点加入队列中
            {
                q.push(temp->right);
                nlast=temp->right;
            }
 
            if(temp==last)// 到了一行的末尾
            {
                v.push_back(v1);
                v1.clear();
                last=nlast;// 更新last
            }
        }
 
        return v;
    }
};