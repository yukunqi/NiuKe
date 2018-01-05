import java.util.ArrayList;
import java.util.Stack;

public class TwoStacks {
	public ArrayList<Integer> twoStacksSort(int[] numbers) {
		Stack<Integer> stack = new Stack<>();// 原始数据栈,把数组变成栈
		Stack<Integer> help = new Stack<>();// 辅助栈

		for (int i = numbers.length - 1; i >= 0; i--) {// 初始化栈
			stack.push(numbers[i]);
		}

		while (!stack.empty()) {// 当数据栈不空时 一直弹出元素
			int top = stack.peek();
			stack.pop();

			if (help.isEmpty() || top >= help.peek()) {// 此时辅助栈中栈顶元素小于数据栈顶元素时，压栈
				help.push(top);
				continue;
			}

			while (!help.empty() && help.peek() > top) {// 若辅助栈顶元素一直大于数据栈顶元素则一直弹出辅助栈元素
				stack.push(help.peek());
				help.pop();
			}

			help.push(top);
		}

		ArrayList<Integer> res = new ArrayList<>();
		while (!help.empty()) {
			res.add(help.peek());
			help.pop();
		}

		return res;
	}
}