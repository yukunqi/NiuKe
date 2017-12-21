import java.util.*;
 
public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        int min=A[0];
        int max=A[0];
 
        for (int i=0;i<A.length;i++){//找到最大值和最小值，用来确定数组大小
            min=Math.min(min,A[i]);
            max=Math.max(max,A[i]);
        }
 
        int []temp=new int[max-min+1];//开辟一块新的数组，大小为len
 
        for (int i=0;i<A.length;i++){//把数字赋值进入新数组
            temp[A[i]-min]++;
        }
        int k=0;
        for (int i=0;i<temp.length;i++){//按照顺序依次倒出数字
            while (temp[i]!=0){
                A[k]=i+min;
                k++;
                temp[i]--;
            }
        }
        return A;
    }
}