import java.util.ArrayList;
import java.util.Stack;

public class TwoStack {

	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	public int[] twoStack(int[] ope, int n) {

		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (ope[i] > 0) {
				push(ope[i]);
			}
			if (ope[i] == 0) {
				res.add(pop());
			}
		}

		int[] arr = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			arr[i] = res.get(i);
		}

		return arr;
	}

	public void push(int node) {
		s1.push(node);
	}

	public int pop() {
		if (s2.isEmpty()) {// 如果弹出栈为空，当发生弹出操作时，就要把压入栈中的数据全部转到弹出栈中去
			while (!s1.empty()) {
				s2.push(s1.peek());
				s1.pop();
			}
		}
		int t = s2.peek();// 然后再弹出弹出栈中的数据，返回栈顶数据先
		s2.pop();
		return t;
	}

}