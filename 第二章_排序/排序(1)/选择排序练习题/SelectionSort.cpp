#include <iostream>
using namespace std; 
 
  
class SelectionSort {
public:
    int* selectionSort(int* A, int n) {
         
        for(int i=0;i<n/2;i++)//优化版的选择排序 在每一次遍历的过程中把最大值和最小值同时调整 则节约一半的时间
        {
            int start=i;
            int end=n-i-1;
            int max,min;
            int s,e;
 
            max=start;
            min=start;
            s=start;
            e=end;
 
            for(;s<=e;s++)//选择这一次遍历过程中的最大和最小值
            {
                if(A[s]>A[max])
                {
                    max=s;
                }
 
                if(A[s]<A[min])
                {
                    min=s;
                }
            }
             
             
            if(max!=start&&min!=end){//最大值和最小值都不在各自位置上，调换两次
                 int temp=A[max];
                A[max]=A[end];
                A[end]=temp;
                 
                temp=A[min];
                A[min]=A[start];
                A[start]=temp;
            }
            else if(max==start&&min==end){//最大值和最小值刚好处于在对方的位置上 则只用这两者调换一次即可
                int temp=A[start];
                A[start]=A[end];
                A[end]=temp;
                   
            }else{//最大值或者最小值有一方是在对方的位置上，调换次序有要求 否则会导致刚把最大或最小值调整到相应位置上又被调走的情况发生
                if(max==start){
                    int temp=A[max];
                    A[max]=A[end];
                    A[end]=temp;
                 
                    temp=A[min];
                    A[min]=A[start];
                    A[start]=temp;
                }
                 
                if(min==end){
                    int temp=A[min];
                    A[min]=A[start];
                    A[start]=temp;
                     
                    temp=A[max];
                    A[max]=A[end];
                    A[end]=temp;
                }
            }
         
        }
 
        return A;
    }
};