/*
public class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}
*/

public class CheckIntersect {
	public boolean chkIntersect(ListNode headA, ListNode headB) {
		int lena = 0;
		int lenb = 0;

		ListNode pa = headA;
		ListNode pb = headB;

		while (pa != null) {// 计算A链表的长度
			lena++;
			pa = pa.next;
		}

		while (pb != null) {// 计算B链表的长度
			lenb++;
			pb = pb.next;
		}

		if (lena > lenb) {// 将较长的链表先遍历跳过长度差个节点 因为如果两个链表要相交 肯定会相交在短链表中
							// 否则短链表就不是这个长度了
			pa = headA;
			pb = headB;
			int count = lena - lenb;// 链表长度差
			while (count != 0) {
				pa = pa.next;
				count--;
			}
		} else {
			pa = headA;
			pb = headB;
			int count = lenb - lena;
			while (count != 0) {
				pb = pb.next;
				count--;
			}

		}

		while (pa != null && pb != null) {
			if (pa == pb) {
				return true;
			}
			pa = pa.next;
			pb = pb.next;
		}
		return false;
	}
}