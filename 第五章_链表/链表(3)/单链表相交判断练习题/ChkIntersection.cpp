/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};*/
class ChkIntersection {
public:
    bool chkInter(ListNode* head1, ListNode* head2, int adjust0, int adjust1) {
        // write code here
        ListNode* head1circle=getCircleHead(head1);// 获得入环头结点
        ListNode* head2circle=getCircleHead(head2);// 获得入环头结点
 
        ListNode* p1=head1;
        ListNode* p2=head2;
 
        while(p1!=head1circle&&p2!=head2circle)// 可能是两个无环链表相交问题 也可能是两个有环链表在入环之前相交的问题
        {
            if(p1==p2)
            {
                return true;
            }
            p1=p1->next;
            p2=p2->next;
        }
         
        if(head1circle==head2circle)
        {
            return true;
        }
 
        p1=head1circle->next;
        while(p1!=head1circle)// 在入环之后相交 或者两者不相交
        {
            if(p1==head2circle)
            {
                return true;
            }
            p1=p1->next;
        }
 
        return false;
 
    }
    // 获得链表的入环头结点 若无环则返回空
    ListNode* getCircleHead(ListNode* head)
    {
        if(head==NULL)
        {
            return NULL;
        }
 
        ListNode* fast=head->next;
        ListNode* slow=head;
 
        while(fast!=slow)
        {
            if(fast==NULL||fast->next==NULL)
            {
                return NULL;
            }
            fast=fast->next->next;
            slow=slow->next;
        }
 
        fast=head;
        slow=slow->next;
 
        while(fast!=slow)
        {
            fast=fast->next;
            slow=slow->next;
        }
 
        return fast;
    }
};