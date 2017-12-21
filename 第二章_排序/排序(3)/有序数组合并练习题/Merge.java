import java.util.*;
 
public class Merge {
    public int[] mergeAB(int[] A, int[] B, int n, int m) {
        int k=n+m-1;
        int i=n-1,j=m-1;
        while (i>=0&&j>=0){
            if (A[i]>B[j]){
                A[k--]=A[i--];
            }else {
                A[k--]=B[j--];
            }
        }
        while(j>=0){
            A[k--]=B[j--];
        }
        return A;
    }
}