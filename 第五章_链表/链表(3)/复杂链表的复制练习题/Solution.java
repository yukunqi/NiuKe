import niuke.第五章_链表.链表(3).复杂链表的复制练习题.RandomListNode;

/*
public class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
}
*/

// 链表连接的时候若有不清楚的地方，可以画图理解。剑指offer原题 也可以参考剑指offer书上
public class Solution {
	public RandomListNode Clone(RandomListNode pHead) {
		pHead = createRandomNode(pHead);
		pHead = linkRandomNode(pHead);
		return split_twoList(pHead);
	}

	// 第一部分 创建新的链表 把原链表的每一个节点都复制一个同样的节点在当前节点后面
	public RandomListNode createRandomNode(RandomListNode phead) {
		RandomListNode pListNode = phead;
		while (pListNode != null) {
			RandomListNode node = new RandomListNode(pListNode.label);
			node.random = null;
			node.next = pListNode.next;
			pListNode.next = node;
			pListNode = node.next;
		}

		return phead;
	}

	// 把新节点的random指针进行赋值，random指向原指针的random的next节点
	public RandomListNode linkRandomNode(RandomListNode phead) {
		RandomListNode pListNode = phead;
		while (pListNode != null) {
			RandomListNode node = pListNode.next;
			if (pListNode.random != null) {// 要判断random指针是否为空，否则赋值就会报错
											// 为空就直接不用赋值了
				node.random = pListNode.random.next;
			}
			pListNode = node.next;
		}
		return phead;
	}

	// 用两个新的头结点把这两个链表分开
	public RandomListNode split_twoList(RandomListNode phead) {
		RandomListNode ranHead = null;
		RandomListNode p = phead;
		RandomListNode cur = null;

		if (p != null) {// 初始化random的头节点
			ranHead = cur = p.next;
			p.next = ranHead.next;
			p = p.next;
		}

		while (p != null) {
			cur.next = p.next;
			cur = cur.next;
			p.next = cur.next;
			p = p.next;
		}

		return ranHead;
	}
}