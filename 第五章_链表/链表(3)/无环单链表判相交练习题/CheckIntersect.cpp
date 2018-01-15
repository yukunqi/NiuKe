/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};*/
class CheckIntersect {
public:
    bool chkIntersect(ListNode* headA, ListNode* headB) {
        // write code here
        int lena=0;
        int lenb=0;
         
        ListNode *p1=headA;
        ListNode *p2=headB;
 
        while(p1!=NULL)// 计算A链表的长度
        {
            lena++;
            p1=p1->next;
        }
 
        while(p2!=NULL)// 计算B链表的长度
        {
            lenb++;
            p2=p2->next;
        }
         
        p1=headA;
        p2=headB;
 
        if(lena>lenb)// 将较长的链表先遍历跳过长度差个节点 因为如果两个链表要相交 肯定会相交在短链表中  否则短链表就不是这个长度了
        {
            int t=lena-lenb;// 链表长度差
            while(t--)
            {
                p1=p1->next;
            }
        }
        else
        {
            int t=lenb-lena;
            while(t--)
            {
                p2=p2->next;
            }
        }
 
        while(p1!=NULL&&p2!=NULL)
        {
            if(p1==p2)//判断两个节点 而不是值 之前写成p1->val p2->val 结果出错
            {
                return true;
            }
            p1=p1->next;
            p2=p2->next;
        }
 
        return false;
 
    }
};