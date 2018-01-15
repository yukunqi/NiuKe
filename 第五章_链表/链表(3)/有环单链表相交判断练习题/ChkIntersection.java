public class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class ChkIntersection {
	public boolean chkInter(ListNode head1, ListNode head2, int adjust0, int adjust1) {
		ListNode circle1 = getCircleHeadNode(head1);// 获得入环头结点
		ListNode circle2 = getCircleHeadNode(head2);// 获得入环头结点

		if (circle1 != null && circle2 != null) {// 因为题目规定是两个有环单链表了，所以不用考虑else的情况
			if (circle1 == circle2) {// 在入环之前已经相交 问题变成两个无环单链表的相交问题
				return NocircleListIntersection(head1, head2, circle1);
			} else {// 在入环之后相交 或者两者不相交
				ListNode cur = circle1.next;
				while (cur != circle1) {
					if (cur == circle2) {
						return true;
					}
					cur = cur.next;
				}
				return false;
			}
		}

		return false;
	}

	// 获得链表的入环头结点 若无环则返回空
	public ListNode getCircleHeadNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != slow) {
			if (fast == null || fast.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		}

		fast = head;
		slow = slow.next;

		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}

		return fast;
	}

	// 和无环单链表相交问题类似 只是判断终止的标志是到达入环头结点 而不是节点为空
	public boolean NocircleListIntersection(ListNode headA, ListNode headB, ListNode circle) {
		int lena = 0;
		int lenb = 0;

		ListNode pa = headA;
		ListNode pb = headB;

		while (pa != circle) {// 注意这里终止条件
			lena++;
			pa = pa.next;
		}

		while (pb != circle) {// 注意这里终止条件
			lenb++;
			pb = pb.next;
		}

		pa = headA;
		pb = headB;
		if (lena > lenb) {
			int count = lena - lenb;
			while (count != 0) {
				pa = pa.next;
				count--;
			}
		} else {
			int count = lenb - lena;
			while (count != 0) {
				pb = pb.next;
				count--;
			}
		}

		while (pa != circle && pb != circle) {// 注意这里终止条件
			if (pa == pb) {
				return true;
			}
			pa = pa.next;
			pb = pb.next;
		}

		return false;
	}
}