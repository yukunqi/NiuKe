#include <iostream>
using namespace std;

class MergeSort {
public:
    int* mergeSort(int* A, int n) {
        mergePass(A,0,n-1);
		return A;
    }

	void mergePass(int *A,int low,int high){
	
		if(low<high){
		
			if(high-low<=10){//元素个数小于一定数量时采用插入排序 可以自己指定
				InsertionSort(A,low,high);
				return ;
			}
			
			int middle=(low+high)/2;

			mergePass(A,low,middle);
			mergePass(A,middle+1,high);
            
			if(A[middle]<=A[middle+1]){//如果在中间数的前后两个数已经有序 则整体一定有序 不需要再次进行调整
               return;
           	}
            
			merge_func(A,low,high,middle);
		}
	}


	void merge_func(int *A,int low,int high,int mid){
	
		int *temp=new int [high-low+1];//建立一个临时空间存放排序好的元素
		int k=0;
		int i=low;
		int j=mid+1;

		while(i<=mid&&j<=high){//将小的元素优先放到数组中
			if(A[i]>A[j]){
				temp[k++]=A[j++];
			}else{
				temp[k++]=A[i++];
			}
		}

		while(i<=mid){//将剩余的元素插入
			temp[k++]=A[i++];
		}
		while(j<=high){//同上
			temp[k++]=A[j++];
		}

		for(i=low,k=0;i<=high;i++,k++){//排序好后重新放回原数组中去
			A[i]=temp[k];
		}
	}

	void InsertionSort(int *A,int start,int end){
		
		int temp=0;
		int j=0;
		for(int i=start+1;i<=end;i++){
			temp=A[i];
			j=i;
			while(j>start&&temp<A[j-1]){
				A[j]=A[j-1];
				j--;
			}
			A[j]=temp;
		}
	}
};