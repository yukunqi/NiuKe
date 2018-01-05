#include <iostream>
#include <stack>
#include <vector>
using namespace std;

class TwoStacks {
public:
    vector<int> twoStacksSort(vector<int> numbers) {
        	stack<int> s;// 原始数据栈,把数组变成栈
		stack<int> help;// 辅助栈
		
		for(int i=numbers.size()-1;i>=0;i--){// 初始化栈
			s.push(numbers[i]);
		}

		while(!s.empty()){// 当数据栈不空时 一直弹出元素
			int top=s.top();
			s.pop();

			if(help.empty()||top>=help.top()){// 此时辅助栈中栈顶元素小于数据栈顶元素时，压栈
				help.push(top);
				continue;
			}

			while(!help.empty()&&top<help.top()){// 若辅助栈顶元素一直大于数据栈顶元素则一直弹出辅助栈元素
				s.push(help.top());
				help.pop();
			}

			help.push(top);
		}

		vector<int> res;
		while(!help.empty()){
			res.push_back(help.top());
			help.pop();
		}

		return res;
    }
};
