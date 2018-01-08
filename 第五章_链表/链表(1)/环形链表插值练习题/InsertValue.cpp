#include <iostream>
#include <vector>
using namespace std;


struct ListNode {
    int val;
    struct ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};


class InsertValue {
public:
    ListNode* insert(vector<int> A, vector<int> nxt, int val) {
        ListNode *root=createList(A,nxt);
 
        ListNode * pre=root;
        ListNode * cur=root->next;
         
        ListNode * node=NULL;
        while(cur!=NULL){
            if(val>=pre->val&&val<=cur->val){//val在pre和cur的val之间的话 就插入新的节点
                node=new ListNode(val);
                pre->next=node;
                node->next=cur;
                break;
            }
            pre=pre->next;
            cur=cur->next;
        }
 
        if(node==NULL){//说明val可能是最大值或者最小值
            node=new ListNode(val);
            if(pre->val<=node->val){//最大值的情况
                pre->next=node;
                node->next=NULL;
                return root;
            }else if(node->val<=root->val){//最小值的情况
                node->next=root;
                pre->next=NULL;
                return node;
            }
        }
 
        return root;//普通的情况
    }
	//构造初始环形链表 牛客网这道题好像有问题 所以构造环形链表会过不了OJ
    ListNode * createList(vector<int> A, vector<int> nxt){
        ListNode *root=new ListNode(A[0]);
        ListNode * temp=root;
        for(int i=1;i<A.size();i++)
        {
            root->next=new ListNode(A[i]);
            root=root->next;
        }
          
        return temp;
    }
};