public class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Palindrome {
	public boolean isPalindrome(ListNode pHead) {
		ListNode pfast = pHead;
		ListNode pslow = pHead;

		while (pfast != null && pfast.next != null) {// 建立快慢指针 快指针一次走两个 慢指针一次走一个
			pfast = pfast.next.next;
			pslow = pslow.next;
		}

		ListNode prev = null;

		while (pslow != null) {// 此时慢指针在中心，从中间开始反转剩下链表
			ListNode next = pslow.next;
			pslow.next = prev;
			prev = pslow;
			pslow = next;
		}

		ListNode pNode = pHead;
		while (prev != null) {// 判断从头开始到中间和从末尾开始到中间的这两个链表是否相等，若相等则说明是回文结构
			if (pNode.val == prev.val) {
				pNode = pNode.next;
				prev = prev.next;
			} else {
				return false;
			}
		}

		return true;
	}
}