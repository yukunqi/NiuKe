import java.util.*;
 
public class SelectionSort {
    public int[] selectionSort(int[] A, int n) {
       int temp;
       for(int i=0;i<n/2;i++){//优化版的选择排序 在每一次遍历的过程中把最大值和最小值同时调整 则节约一半的时间
           int start=i;
           int end=n-i-1;
           int min_index=start;
           int max_index=start;
           
           for(int j=start;j<=end;j++){//选择这一次遍历过程中的最大和最小值
               if(A[min_index]>A[j]){
                   min_index=j;
               }
               if(A[max_index]<A[j]){
                   max_index=j;
               }
           }
           
           if(min_index!=end&&max_index!=start){//最大值和最小值都不在各自位置上，调换两次
               swap(A,min_index,start);
               swap(A,max_index,end);
           }else if(min_index==end&&max_index==start){//最大值和最小值刚好处于在对方的位置上 则只用这两者调换一次即可
               swap(A,start,end);
           }else{//最大值或者最小值有一方是在对方的位置上，调换次序有要求 否则会导致刚把最大或最小值调整到相应位置上又被调走的情况发生
               if(min_index==end){
                   swap(A,min_index,start);
                   swap(A,max_index,end);
               }
               if(max_index==start){
                   swap(A,max_index,end);
                   swap(A,min_index,start);
               }
           }
       }
       return A;
    }
    
    public void swap(int []A,int a,int b){
        int temp=A[a];
        A[a]=A[b];
        A[b]=temp;
    }
}