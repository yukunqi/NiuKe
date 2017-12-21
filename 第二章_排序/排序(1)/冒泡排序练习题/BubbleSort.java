import java.util.*;
 
public class BubbleSort {
    public int[] bubbleSort(int[] A, int n) {
       int i=n-1;
         
        while(i>0){
            int pos=0;//记录每次交换的最后一个位置
             
            for(int j=0;j<i;j++){//只需要检查i之前的值
                if(A[j]>A[j+1]){
                    int temp=A[j];
                    A[j]=A[j+1];
                    A[j+1]=temp;
                    pos=j;
                }
            }
             
            i=pos;//i更新成pos
        }
         
        return A;
    }
}