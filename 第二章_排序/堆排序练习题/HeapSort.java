import java.util.*;
 
public class HeapSort {
    public int[] heapSort(int[] A, int n) {
        headsort(A,n);
        return A;
    }
    public void headAdjust(int []A,int parent,int length){
        int temp=A[parent];
        int children=parent*2+1;
        while(children<length){
            if(children+1<length&&A[children+1]>A[children]){
                children++;
            }
            if(temp>A[children]){
                break;
            }
            A[parent]=A[children];
            parent=children;
            children=children*2+1;
        }
        A[parent]=temp;
    }
    public void headsort(int []A,int n){
        for(int i=n/2;i>=0;i--){
           headAdjust(A,i,A.length);
        }
        for(int i=n-1;i>0;i--){
            swap(A,0,i);
            headAdjust(A,0,i);
        }
    }
    public void swap(int []A,int a,int b){
        int temp=A[a];
        A[a]=A[b];
        A[b]=temp;
    }
}