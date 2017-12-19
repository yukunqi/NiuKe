import java.util.*;
 
public class RadixSort {
    public int[] radixSort(int[] A, int n) {
        radix_sort(A,n,findMaxNumber_digits(A));
        return A;
    }
    /**
     * 找到这个数组中最大的数有多少位
     * 例如：数组中最大的为123，则返回3
     * @param A 数组
     * @return 位数
     */
    public int findMaxNumber_digits(int [] A){
        int max=A[0];
        for(int i=0;i<A.length;i++){
            max=Math.max(A[i],max);
        }
        return String.valueOf(max).length();
    }
 
    /**
     * 获取数字的第n位数
     * @param num 待获取的数字
     * @param n 第几位数
     * @return 位数
     */
    public int getNumberBydigit(int num,int n){
        int result=0;
        while (n>0){
            result=num%10;
            num=num/10;
            n--;
        }
        return result;
    }
    public int [] radix_sort(int [] A,int n,int radix){
        int [][] temp=new int[10][A.length];
        int [] count=new int[10];
        for (int i=1;i<=radix;i++){
            for (int j=0;j<A.length;j++){
                int numberBydigit = getNumberBydigit(A[j], i);
                temp[numberBydigit][count[numberBydigit]++]=A[j];
            }
            int k=0,m=0;
            for (int j=0;j<count.length;j++){
                while (count[j]!=0){
                    A[k++]=temp[j][m];
                    count[j]--;
                    m++;
                }
                m=0;
            }
        }
        return A;
    }
}