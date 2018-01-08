public class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Remove {
	public ListNode removeNode(ListNode pNode, int delVal) {
		ListNode temp = pNode;

		if (pNode.val == delVal) {// 首先判断头节点是否为要被删除节点
			pNode = pNode.next;
			return pNode;
		}

		while (temp.next != null) {// 当被删除节点存在中间部分时
			if (temp.next.val == delVal) {
				temp.next = temp.next.next;
				return pNode;
			}
			temp = temp.next;
		}

		if (temp.next == null) {// 被删除节点为尾节点时
			temp = null;
		}
		return pNode;
	}
}