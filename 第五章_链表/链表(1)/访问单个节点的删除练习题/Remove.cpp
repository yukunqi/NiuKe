/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};*/
class Remove {
public:
    ListNode* removeNode(ListNode* pHead, int delVal) {
        ListNode * temp=pHead;

		if(pHead->val==delVal){//首先判断头节点是否为要被删除节点
			pHead=pHead->next;
			return pHead;
		}

		while(temp->next!=NULL){//当被删除节点存在中间部分时
			if(temp->next->val==delVal){
				temp->next=temp->next->next;
				return pHead;
			}
			temp=temp->next;
		}

		if(temp->next==NULL){//被删除节点为尾节点时
			temp=NULL;
		}

		return pHead;
    }
};