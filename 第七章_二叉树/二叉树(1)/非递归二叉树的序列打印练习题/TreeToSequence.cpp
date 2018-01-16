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
       vector<int> res1=PreOrder(root1);
 
       TreeNode * root2=root;
       vector<int> res2=InOrder(root2);
 
       TreeNode * root3=root;
       vector<int> res3=ReverseOrder1(root3);
        
        
       vector<vector<int> >res;
 
       res.push_back(res1);
       res.push_back(res2);
       res.push_back(res3);
 
       return res;
    }
    // 非递归前序遍历二叉树
    vector<int> PreOrder(TreeNode *root)
    {
        stack<TreeNode*>s;// 用一个栈存储节点
 
        TreeNode * cur;
 
        s.push(root);
        vector<int> res;
        while(!s.empty())
        {
            cur=s.top();
            s.pop();
            res.push_back(cur->val);
 
            if(cur->right!=NULL)// 先加入右节点 因为栈是先进后出的数据结构 这样才满足先序遍历的输出顺序
            {
                s.push(cur->right);
            }
            if(cur->left!=NULL)
            {
                s.push(cur->left);
            }
        }
 
        return res;
    }
     // 非递归中序遍历二叉树
    vector<int> InOrder(TreeNode * root)
    {
        stack<TreeNode *> s;
 
        TreeNode * cur=root;
        vector<int > res;
        while(!s.empty()||cur!=NULL)
        {
            while(cur!=NULL)
            {
                s.push(cur);
                cur=cur->left;
            }
 
            if(!s.empty())
            {
                TreeNode * temp=s.top();// 弹出栈顶节点
                s.pop();
                res.push_back(temp->val);
                cur=temp->right;// 指向当前节点的右节点
            }
        }
 
        return res;
    }
     
    //两个栈
    vector<int> ReverseOrder(TreeNode *root)
    {
        stack<TreeNode * >s1;
        stack<TreeNode * >s2;
        TreeNode * cur;
        s1.push(root);
 
        vector<int >res;
        while(!s1.empty())
        {
            cur=s1.top();
            s1.pop();
            s2.push(cur);
 
            if(cur->left!=NULL)
            {
                s1.push(cur->left);
            }
            if(cur->right!=NULL)
            {
                s1.push(cur->right);
            }
        }
 
        while(!s2.empty())
        {
            cur=s2.top();
            s2.pop();
            res.push_back(cur->val);
        }
 
        return res;
    }
 
    //一个栈
    vector<int> ReverseOrder1(TreeNode * root)
    {  
        TreeNode *h;// 代表最近一次打印输出的节点
        TreeNode *c;
 
        stack<TreeNode *>s;
        vector<int> res;
        h=root;
        c=NULL;
 
        s.push(root);
 
        while(!s.empty())
        {
            c=s.top();
 
            if(h!=c->left&&c->left!=NULL&&h!=c->right)// 当前节点c的左右节点都不等于h同时左子树不为空，说明左孩子还没有打印 则左子树入栈
            {
                s.push(c->left);
            }
            else if(h!=c->right&&c->right!=NULL)// 当前节点c的右节点不等于h同时右节点不为空，说明右节点还没有打印过 所以把右节点加入栈中
            {
                s.push(c->right);
            }
            else
            {// 都不满足上面的情况的话 说明要打印当前节点了 同时令h=c 因为c刚刚完成输出
                res.push_back(c->val);
                s.pop();
                h=c;
            }
        }
 
        return res;
    }
}; 