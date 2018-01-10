/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};*/
class Palindrome {
public:
    bool isPalindrome(ListNode* pHead) {
        // write code here
 
        ListNode *fast=pHead;
        ListNode *slow=pHead;
 
        while(fast!=NULL&&fast->next!=NULL)// 建立快慢指针 快指针一次走两个 慢指针一次走一个
        {
            fast=fast->next->next;
            slow=slow->next;
        }
 
        ListNode *prev=NULL;
 
        while(slow!=NULL)// 此时慢指针在中心，从中间开始反转剩下链表
        {
            ListNode *next=slow->next;
            slow->next=prev;
            prev=slow;
            slow=next;
        }
         
        ListNode *p=pHead;
        while(prev)// 判断从头开始到中间和从末尾开始到中间的这两个链表是否相等，若相等则说明是回文结构
        {
            if(prev->val==p->val)
            {
                prev=prev->next;
                p=p->next;
            }
            else
            {
                return false;
            }
        }
 
        return true;
    }
};