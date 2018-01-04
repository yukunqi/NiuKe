class Solution {//这里采用的和JAVA的实现方法有一点不一样，最小值栈中会插入和数据栈中一样多的元素
public:
    stack<int>stack_data;//数据栈
    stack<int>stack_min;//最小值栈
          
    void push(int value) {
        stack_data.push(value);
        if(stack_min.empty()||value<stack_min.top())//当前元素小于最小值栈顶元素时插入当前元素，否则插入最小值栈顶元素(这里有不同)
            {
            stack_min.push(value);
        }
        else stack_min.push(stack_min.top());
    }
    void pop() {
        if(!stack_data.empty()){//弹出元素，不同判断直接一起弹出(这里有不同)
            stack_data.pop();
            stack_min.pop();
        }
    }
    int top() {
        return stack_data.top();
    }
    int min() {
    return stack_min.top();
    }
};