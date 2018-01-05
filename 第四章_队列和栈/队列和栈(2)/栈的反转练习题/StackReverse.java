import java.util.Stack;

public class StackReverse {

	public Stack<Integer> stack = new Stack<>();

	public int[] reverseStack(int[] A, int n) {// 因为这里使用数组代替栈，所以变成真正的栈的时候需要从末尾压栈
		for (int i = n - 1; i >= 0; i--) {
			stack.push(A[i]);
		}

		reverse(stack);// 倒序

		for (int i = 0; i < n; i++) {// 把元素返回给数组
			A[i] = stack.peek();
			stack.pop();
		}

		return A;
	}

	public int get(Stack<Integer> s) {// 递归函数，用来删除栈底元素并返回栈底元素
		int result = s.pop();
		if (s.isEmpty()) {
			return result;
		} else {
			int last = get(s);
			s.push(result);
			return last;
		}
	}

	public void reverse(Stack<Integer> s) {// 倒序函数
		if (s.empty()) {
			return;
		}
		int last = get(s);// 每次递归获取当前栈中的栈底元素，然后回溯时依次压入栈中就完成倒序的操作了。
		reverse(s);
		s.push(last);
	}
}