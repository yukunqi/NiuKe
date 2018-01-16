    /*
    struct TreeNode {
        int val;
        struct TreeNode *left;
        struct TreeNode *right;
        TreeNode(int x) :
                val(x), left(NULL), right(NULL) {
        }
    };*/
 
class TreeToString {
public:
    string toString(TreeNode* root) {
        string s;
        return PreOrderSerize(root,s);
    }
    //ÕûĞÍ×ª×Ö·û´®
    string int_tostring(int n)
    {
        string s;
        char a='0';
        while(n>0)
        {
            char ch=a+n%10;
            s=ch+s;
            n/=10;
        }
        return s;
    }
    //µİ¹éÏÈĞò±éÀú¶ş²æÊ÷
    string PreOrderSerize(TreeNode* root,string &s)
    {
        if(root==NULL)
        {
            s+="#!";
            return s;
        }
        string val=int_tostring(root->val);
        s+=val;
        s+="!";
        PreOrderSerize(root->left,s);
        PreOrderSerize(root->right,s);
 
        return s;
    }
};