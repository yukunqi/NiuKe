import java.util.*;
 
public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        int[] ints = HeadSort(a, n);
        for (int i=1;i<n;i++){
            if (ints[i]==ints[i-1]){
                return true;
            }
        }
        return false;
    }
    public int [] HeadSort(int [] A,int n){
 
        for (int i=n/2;i>=0;i--){
            HeadAdjust(A,i,n);
        }
        for (int i=n-1;i>=0;i--){
            int temp=A[0];
            A[0]=A[i];
            A[i]=temp;
            HeadAdjust(A,0,i);
        }
        return A;
    }
 
    /**
     * ½¨Á¢´ó¶¥¶Ñ
     * @param A
     * @param parent
     * @param length
     */
    public void HeadAdjust(int A[],int parent,int length){
        int temp=A[parent];
        int child=parent*2+1;
        while (child<length){
            if (child+1<length&&A[child]<A[child+1]){
                child++;
            }
            if (temp>=A[child]){
                break;
            }
            A[parent]=A[child];
            parent=child;
            child=child*2+1;
        }
        A[parent]=temp;
    }
}