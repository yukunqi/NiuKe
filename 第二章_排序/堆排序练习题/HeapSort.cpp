#include <iostream>
using namespace std;

class HeapSort {
public:
    int* heapSort(int* A, int n) {
		for(int i=n/2;i>=0;i--){//构建初始堆 从2/n开始调整二叉树
			head_adjust(A,i,n-1);
		}

		for(int i=n-1;i>=0;i--){//把堆顶元素也就是最大值放到最后，然后每次进行一次堆调整
			swap(A,0,i);
			head_adjust(A,0,i);
		}

		return A;
    }

	void head_adjust(int *A,int parent,int length){
		int temp=A[parent];//记录父节点值
		int child=parent*2+1;//取出子节点索引
		while(child<length){
			
			if(child+1<length&&A[child]<A[child+1]){//这里是构建大根堆
				child++;//取两个孩子节点中最大的那个
			}

			if(temp>A[child]){//如果父节点大于孩子节点 则退出 这三个节点满足条件
				break;
			}
			//循环向子节点进行
			A[parent]=A[child];
			parent=child;
			child=child*2+1;
		}

		A[parent]=temp;//把最初的父节点放回二叉树中
	}

	void swap(int *A,int a,int b){
		int temp=A[a];
		A[a]=A[b];
		A[b]=temp;
	}
};
