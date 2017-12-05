import java.util.*;
 
public class ShellSort {
    public int[] shellSort(int[] A, int n) {
       int gap=n/2;//分隔的间隔长度 每次都取一半
        while (gap>=1){
            for (int i=gap;i<A.length;i++){
                int temp=A[i];
                int j;
                for (j=i-gap;j>=0&&temp<A[j];j=j-gap){
                    A[j+gap]=A[j];
                }
                A[j+gap]=temp;
            }
            gap=gap/2;
        }
        return A;
    }
}