class TwoStack {
public:
 
    stack<int> s1;
    stack<int> s2;
 
    vector<int> twoStack(vector<int> ope, int n) {
        int i;
        vector<int> res;
        for(i=0;i<n;i++)
        {
            if(ope[i]>0)
            {
                push(ope[i]);
            }
 
            if(ope[i]==0)
            {
                res.push_back(pop());
            }
        }
 
        return res;
    }
 
    void push(int value)
    {
        s1.push(value);
    }
 
    int pop()
    {
        if(s2.empty())// 如果弹出栈为空，当发生弹出操作时，就要把压入栈中的数据全部转到弹出栈中去
        {
            while(!s1.empty())
            {
                s2.push(s1.top());
                s1.pop();
            }      
        }
        int t= s2.top();// 然后再弹出弹出栈中的数据，返回栈顶数据先
        s2.pop();
        return t;
    }
};