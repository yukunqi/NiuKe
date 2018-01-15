/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};*/
 
class CountNodes {
public:
    int count(TreeNode* root) {
        TreeNode *temp=root;
 
        TreeNode *left=NULL;
        TreeNode *right=NULL;
        int l_node=0;
        int r_node=0;
 
        int res=1;
        while(temp->left!=NULL||temp->right!=NULL)
        {
            left=temp->left;
             
            l_node=0;
            r_node=0;
 
            while(left!=NULL)
            {
                l_node++;
                left=left->left;
            }
 
            right=temp->right;
 
            while(right!=NULL)
            {
                r_node++;
                right=right->left;
            }
 
            if(r_node==l_node)// 比较两个头节点的深度 若一样说明左子树是一颗满二叉树 直接用公式计算节点
            {
                res+=pow(2,l_node);
                temp=temp->right;
            }
            else// 比较两个头节点的深度 若不一样说明右子树是一颗满二叉树 直接用公式计算节点
            {
                res+=pow(2,r_node);
                temp=temp->left;
            }
        }
 
        return res;
    }
};