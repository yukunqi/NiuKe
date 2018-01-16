/*
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
    TreeNode(int x) :
            val(x), left(NULL), right(NULL) {
    }
};*/

class CheckCompletion {
public:
    bool chk(TreeNode* root) {
       queue<TreeNode*>s;
       s.push(root);
       bool res=true;
       bool isleaf=false;
       while(!s.empty()){// 按层遍历来进行检索
           TreeNode *temp=s.front();
           s.pop();
           if(isleaf){// 当标志为true时 代表开始判断当前节点是否为叶子节点
               if(!(temp->left==NULL&&temp->right==NULL)){// 不是叶子节点 返回 false
		    res=false;
                    break;
               }
           }
           if(temp->right!=NULL&&temp->left==NULL){// 有右孩子没左孩子 不符合完全二叉树定义 返回false
		res=false;
               	break;
           }else if(temp->right!=NULL&&temp->left!=NULL){
		s.push(temp->left);
            	s.push(temp->right);
           }else{// 当不同时存在左右孩子时 此时就要求此节点以后的节点都要是叶子节点
               isleaf=true;
               if(temp->left!=NULL){
                   s.push(temp->left);
               }
               if(temp->right!=NULL){
                   s.push(temp->right);
               }
           }
       }
        return res;
    }
};