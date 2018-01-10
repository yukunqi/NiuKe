/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};*/
class Divide {
public:
    ListNode* listDivide(ListNode* head, int val) {
        // write code here
        ListNode *small=new ListNode(0);// 分别创建大于 等于 小于三个头结点
        ListNode *big=new ListNode(0);
        ListNode *cur=head;
        ListNode *bighead=big;
        ListNode *smallhead=small;
        while(cur!=NULL)
        {
            if(cur->val<=val)
            {
                small->next=cur;
                small=small->next;
            }
 
            if(cur->val>val)
            {
                big->next=cur;
                big=big->next;
            }
 
            cur=cur->next;
        }
         
        small->next=bighead->next;
        big->next=NULL;
 
        return smallhead->next;
 
    }
};