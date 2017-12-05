import java.util.*;
 
public class BubbleSort {
    public int[] bubbleSort(int[] A, int n) {
       int i=n-1;
         
        while(i>0){
            int pos=0;
             
            for(int j=0;j<i;j++){
                if(A[j]>A[j+1]){
                    int temp=A[j];
                    A[j]=A[j+1];
                    A[j+1]=temp;
                    pos=j;
                }
            }
             
            i=pos;
        }
         
        return A;
    }
}