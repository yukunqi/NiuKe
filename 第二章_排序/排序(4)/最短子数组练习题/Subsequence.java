import java.util.*;
 
public class Subsequence {
    public int shortestSubsequence(int[] A, int n) {
        int min=A[n-1];
        int max=A[0];
        int p=0,q=n-1;
        for (int i=0;i<n;i++){
            if (max>A[i]){//如果第i个数比big大，更换big，直到有数比big小，记录下标。下标最终停留在最后一个比big小的数上。那么整个过程经历了从大到小再大，中间的未排序区间的末尾就是下标p
                p=i;
            }else {
                max=A[i];
            }
        }
        for (int i=n-1;i>=0;i--){
            if (min<A[i]){//如果第n-i-1个数比small小，更换small，直到有数比small大，记录下标。下标最终停留在最后一个比small大的数上，整个过程经历了从小到大再小，中间的未排序的开头就是下标q
                q=i;
            }else {
                min=A[i];
            }
        }
        if (p==0&&q==n-1)
            return 0;
 
        return p-q+1;
    }
}