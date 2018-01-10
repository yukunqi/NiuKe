public class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class ClearValue {
	public ListNode clear(ListNode head, int val) {
		ListNode pListNode = head;
		ListNode node = new ListNode(0);// 创建一个指向head的指针
		node.next = pListNode;
		ListNode cur = node;
		while (pListNode != null) {// 遍历链表 删除目标值
			if (pListNode.val == val) {
				node.next = pListNode.next;
			} else {
				node = node.next;
			}
			pListNode = pListNode.next;
		}

		return cur.next;
	}
}