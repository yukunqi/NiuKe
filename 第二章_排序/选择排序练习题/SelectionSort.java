import java.util.*;
 
public class SelectionSort {
    public int[] selectionSort(int[] A, int n) {
       int temp;
       for(int i=1;i<=n/2;i++){
           int min_index=i;
           int max_index=i;
           for(int j=i-1;j<=n-i;j++){
               if(A[min_index]>A[j]){
                   min_index=j;
                    
               }
               if(A[max_index]<A[j]){
                   max_index=j;
               }
           }
           if(min_index!=i-1){
               temp=A[min_index];
               A[min_index]=A[i-1];
               A[i-1]=temp;
               if(max_index==i-1){
                   max_index=min_index;
               }
           }
           if(max_index!=n-i){
               temp=A[max_index];
               A[max_index]=A[n-i];
               A[n-i]=temp;
           }
       }
       return A;
    }
}