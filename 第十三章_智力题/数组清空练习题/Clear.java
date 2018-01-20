import java.util.*;

public class Clear {
    public int getWinner(int[] A, int n) {
        // write code here
        int[] count=new int[n+1];
        for(int i=0;i<n;i++){
            count[A[i]]++;
        }
        int res=0;
        for(int i=1;i<=n;i++){
            res^=count[i];
        }
        return res!=0?1:0;
    }
}