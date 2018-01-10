public class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class KInverse {
	public ListNode inverse(ListNode head, int k) {
		ListNode cur = head;
		int count = 0;
		while (cur != null && count != k) {
			cur = cur.next;
			count++;
		}
		// 此时cur为第k+1个节点
		if (count == k) {
			cur = inverse(cur, k);// 递归函数 每次返回上一次的头结点
			while (count-- > 0) {// 画图好理解整个反转过程
				ListNode tmp = head.next;
				head.next = cur;
				cur = head;
				head = tmp;
			}
			// cur为翻转后的第一个节点
			head = cur;
		}
		return head;
	}
}