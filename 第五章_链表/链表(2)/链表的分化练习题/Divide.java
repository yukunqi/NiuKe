class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

// 这道题 牛客网的题目没有解释清楚 导致可能会读题产生误解然后通不过OJ 能通过OJ的理解是 按 等于 小于 大于的顺序组成链表
public class Divide {
	public ListNode listDivide(ListNode head, int val) {
		ListNode smallHead = new ListNode(-1);// 分别创建大于 等于 小于三个头结点
		ListNode equalHead = new ListNode(-1);
		ListNode bigHead = new ListNode(-1);

		ListNode smalltemp = smallHead;// 创建三个节点的变换节点
		ListNode equaltemp = equalHead;
		ListNode bigtemp = bigHead;
		ListNode temp = null;
		while (head != null) {

			temp = head;// 这里使用一个temp来复制head，并让temp的next指针为空
						// 是因为如果直接赋值head，会把head的next一起影响进去
			head = head.next;
			temp.next = null;

			if (temp.val < val) {
				smalltemp.next = temp;
				smalltemp = smalltemp.next;
			} else if (temp.val == val) {
				equaltemp.next = temp;
				equaltemp = equaltemp.next;
			} else {
				bigtemp.next = temp;
				bigtemp = bigtemp.next;
			}
		}

		if (smallHead.next == null) {// 当链表中没有小于目标值的节点时
			equaltemp.next = bigHead.next;

		} else {
			equaltemp.next = smallHead.next;
			smalltemp.next = bigHead.next;

		}
		return equalHead.next;
	}
}