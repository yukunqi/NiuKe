
/*
public class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}
*/

public class ChkLoop {
	public int chkLoop(ListNode head, int adjust) {
		ListNode slow = head;// 慢指针
		ListNode fast = head.next;// 快指针

		while (fast != slow) {// 快指针一次走2格，慢指针一次走一格
			if (fast == null || fast.next == null) {// 若快指针为空 说明不是有环指针 返回-1
				return -1;
			}
			fast = fast.next.next;
			slow = slow.next;
		}

		// 重新赋值快慢指针
		fast = head;
		slow = slow.next;

		while (fast != slow) {// 当快慢指针再次相遇时就是入环的头节点
			fast = fast.next;
			slow = slow.next;
		}

		return fast.val;
	}
}