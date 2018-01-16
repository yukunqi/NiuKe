class FoldPaper {
public:
    vector<string> foldPaper(int n) {
        vector<string> res;
        Inorder(res,n,"down");
        return res;
    }
 
    void Inorder(vector<string> &res,int n,string val)
    {
        if(n==0)
        {
            return ;
        }
         
        Inorder(res,n-1,"down");
        res.push_back(val);
        Inorder(res,n-1,"up");
    }
};