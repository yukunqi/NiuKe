/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};*/

class CheckBalance {
public:
    bool check(TreeNode* root) {
       return chk(root)>=0;
    }
    int chk(TreeNode * root){// 使用后序遍历
        if(root==NULL){
            return 0; 
        }
        int l=chk(root->left);// 左子树高度
        int r=chk(root->right);// 右子树高度
        
        if(l<0||r<0){// 若为-1 则说明其中子树为非平衡二叉树
            return -1;
        }
        
        if(abs(l-r)>1){// 若左右子树不是非平衡二叉树 此时判断左右子树的高度差 大于1 则是非平衡二叉树 返回
            return -1;
        }
        
        return l>r?l+1:r+1;// 返回子树高度
    }
};