/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};*/
class KInverse {
public:
    ListNode* inverse(ListNode* head, int k) {
        
        ListNode *p=head;
        int i,j;
        for( i=0;i<k;i++)//先检测一下整个链表如果不够k就可以直接返回了
        {
            if(p==NULL)
            {
                return head;
            }
            p=p->next;
        }
         
        int count=0;
        p=head;
        while(p!=NULL)//计算链表的长度count
        {
            p=p->next;
            count++;
        }
        //这部分是重点 你必须画图去理解 才知道这个指针连接的过程
        ListNode *node=new ListNode(0);
        node->next=head;
        ListNode *pre=node;
        ListNode *cur=head;
        ListNode *temp=head->next;
         
        for(i=0;i<count/k;i++)//总共需要反转的次数
        {
            for(j=0;j<k-1;j++)//反转过程
            {
                cur->next=temp->next;
                temp->next=pre->next;
                pre->next=temp;
                temp=cur->next;
            }
            pre=cur;
            cur=cur->next;
            temp=cur->next;
        }
 
        return node->next;
    }
 
};