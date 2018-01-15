/*
struct RandomListNode {
    int label;
    struct RandomListNode *next, *random;
    RandomListNode(int x) :
            label(x), next(NULL), random(NULL) {
    }
};
*/

// 链表连接的时候若有不清楚的地方，可以画图理解。剑指offer原题 也可以参考剑指offer书上
class Solution {
public:
    RandomListNode* Clone(RandomListNode* pHead)
    {
        createNode(pHead);
        generateRandom(pHead);
        return turnToTwoList(pHead);
    }
    // 第一部分 创建新的链表 把原链表的每一个节点都复制一个同样的节点在当前节点后面
    void createNode(RandomListNode* pHead)
    {
        RandomListNode* p=pHead;
 
        while(p!=NULL)
        {
            RandomListNode* node=new RandomListNode(p->label);
            node->next=p->next;
            node->random=NULL;
            p->next=node;
            p=node->next;
        }
    }

    // 把新节点的random指针进行赋值，random指向原指针的random的next节点
    void generateRandom(RandomListNode* pHead)
    {
        RandomListNode* p=pHead;
        while(p!=NULL)
        {
            RandomListNode* cur=p->next;
            if(p->random!=NULL)// 要判断random指针是否为空，否则赋值就会报错
            {
                cur->random=p->random->next;
            }
            p=cur->next;
        }
    }
     // 用两个新的头结点把这两个链表分开
    RandomListNode* turnToTwoList(RandomListNode* pHead)
    {
        RandomListNode* p=pHead;
        RandomListNode* ranHead=NULL;
        RandomListNode* cur=NULL;
 
        if(p!=NULL)// 初始化random的头节点
        {
            ranHead=cur=p->next;
            p->next=ranHead->next;
            p=p->next;
        }
 
        while(p!=NULL)
        {
             
            cur->next=p->next;
            cur=cur->next;
            p->next=cur->next;
            p=p->next;
        }
 
        return ranHead;
    }
};