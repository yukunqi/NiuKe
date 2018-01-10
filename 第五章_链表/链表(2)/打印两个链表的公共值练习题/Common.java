import java.util.ArrayList;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class Common {
	public int[] findCommonParts(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}

		ArrayList<Integer> res = new ArrayList<>();

		while (headA != null && headB != null) {
			if (headA.val > headB.val) {
				headB = headB.next;
			} else if (headA.val < headB.val) {
				headA = headA.next;
			} else {
				res.add(headA.val);
				headA = headA.next;
				headB = headB.next;
			}
		}

		int arr[] = new int[res.size()];

		for (int i = 0; i < res.size(); i++) {
			arr[i] = res.get(i);
		}

		return arr;
	}
}