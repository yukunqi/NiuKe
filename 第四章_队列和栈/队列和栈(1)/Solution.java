import java.util.Stack;

public class Solution {

	Stack<Integer> stack_data = new Stack<>();// 存放数据的栈
	Stack<Integer> stack_min = new Stack<>();// 存放最小值的栈

	public void push(int node) {
		stack_data.push(node);
		if (stack_min.isEmpty() || node < stack_min.peek()) {// 当要插入的元素小于最小值栈顶元素时才执行插入或者栈为空
			stack_min.push(node);
		}
	}

	public void pop() {
		if (!stack_data.empty()) {// 当栈不为空时
			int node = stack_data.peek();
			if (node <= stack_min.peek()) {// 若弹出的元素小于等于最小值栈顶元素时，弹出最小值栈顶元素。
				stack_min.pop();
			}
			stack_data.pop();
		}
	}

	public int top() {
		return stack_data.peek();
	}

	public int min() {
		return stack_min.peek();
	}
}