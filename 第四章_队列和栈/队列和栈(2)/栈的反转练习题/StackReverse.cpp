class StackReverse {
public:
 
    stack<int> s1;
 
    vector<int> reverseStack(vector<int> A, int n) {// 因为这里使用数组代替栈，所以变成真正的栈的时候需要从末尾压栈
        int i;
 
        for(i=n-1;i>=0;i--)
        {
            s1.push(A.at(i));
        }
         
        rev(s1);// 倒序
        vector<int> res;
        while(!s1.empty())// 把元素返回给数组
        {
            res.push_back(s1.top());
            s1.pop();
        }
 
        return res;
    }
     
    void rev(stack<int> &s)// 倒序函数
    {
        if(s.empty())
        {
            return ;
        }
         
        int val=getBottomValue(s);// 每次递归获取当前栈中的栈底元素，然后回溯时依次压入栈中就完成倒序的操作了。
        rev(s);
        s.push(val);
         
    }
 
    int getBottomValue(stack<int> &s)// 递归函数，用来删除栈底元素并返回栈底元素
    {
        int res=s.top();
        s.pop();
        if(s.empty())
        {
            return res;
        }
        else
        {
            int val=getBottomValue(s);
            s.push(res);
            return val;
        }
    }
 
};