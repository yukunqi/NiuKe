class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class InsertValue {
	public ListNode insert(int[] A, int[] nxt, int val) {
		ListNode root = createList(A, nxt);
		ListNode pre = root;
		ListNode cur = root.next;

		ListNode node = null;
		while (cur != null) {
			if (pre.val <= val && val <= cur.val) {// val在pre和cur的val之间的话
													// 就插入新的节点
				node = new ListNode(val);
				pre.next = node;
				node.next = cur;
				break;
			}
			pre = pre.next;
			cur = cur.next;
		}

		if (node == null) {// 说明val可能是最大值或者最小值
			node = new ListNode(val);
			if (pre.val <= node.val) {// 最大值的情况
				pre.next = node;
				node.next = null;
				return root;
			} else if (node.val <= root.val) {// 最小值的情况
				pre.next = null;
				node.next = root;
				return node;
			}
		}

		return root;// 普通的情况
	}

	// 构造初始环形链表 牛客网这道题好像有问题 所以构造环形链表会过不了OJ
	public ListNode createList(int[] A, int[] nxt) {
		ListNode root = new ListNode(A[0]);
		ListNode temp = root;
		for (int i = 1; i < A.length; i++) {
			root.next = new ListNode(A[i]);
			root = root.next;
		}
		return temp;
	}
}