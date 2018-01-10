/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};*/
class Common {
public:
    vector<int> findCommonParts(ListNode* headA, ListNode* headB) {
        // write code here
        vector<int> res;
        if(headA==NULL||headB==NULL)
        {
            return res;
        }
 
        while(headA!=NULL&&headB!=NULL)
        {
            if(headA->val>headB->val)
            {
                headB=headB->next;
            }
            else if(headA->val<headB->val)
            {
                headA=headA->next;
            }
            else
            {
                res.push_back(headA->val);
                headA=headA->next;
                headB=headB->next;
            }
        }
 
        return res;
    }
};