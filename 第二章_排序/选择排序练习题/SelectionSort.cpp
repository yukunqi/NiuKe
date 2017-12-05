#include <iostream>
using namespace std; 
 
  
class SelectionSort {
public:
    int* selectionSort(int* A, int n) {
         
        for(int i=0;i<n/2;i++)
        {
            int start=i;
            int end=n-i-1;
            int max,min;
            int s,e;
 
            max=start;
            min=start;
            s=start;
            e=end;
 
            for(;s<=e;s++)
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
             
             
            if(max!=start&&min!=end){
                 int temp=A[max];
                A[max]=A[end];
                A[end]=temp;
                 
                temp=A[min];
                A[min]=A[start];
                A[start]=temp;
            }
            else if(max==start&&min==end){
                int temp=A[start];
                A[start]=A[end];
                A[end]=temp;
                   
            }else{
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