/*
struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};*/
class ClearValue {
public:
    ListNode* clear(ListNode* head, int val) {
        
       ListNode *node=new ListNode(0);// 创建一个指向head的指针
       node->next=head;
       ListNode *p=node;
        ListNode *cur=head;
       while(cur!=NULL)// 遍历链表 删除目标值
       {
           if(cur->val==val)
           {
              p->next=cur->next;
           }
           else
           {
               p=p->next;
           }
           cur=cur->next;
       }
 
       return node->next;
        
    }
}