import java.util.*;
 
public class MergeSort {
    public int[] mergeSort(int[] A, int n) {
         mergePass(A,0,n-1);
         return A;
    }
    public void mergePass(int [] A,int left,int right){
       if(right>left){
            
            
           if(right-left<10){//元素个数小于一定数量时采用插入排序 可以自己指定
               insertSort(A,left,right);
           }
            
           int middle=(left+right)/2;
           mergePass(A,left,middle);
           mergePass(A,middle+1,right);
            
            
           if(A[middle]<=A[middle+1]){//如果在中间数的前后两个数已经有序 则整体一定有序 不需要再次进行调整
               return;
           }
            
           merge(A,left,right,middle);
       }
    }
    public void insertSort(int []A,int start,int end){
        int temp;
        for(int i=start;i<end;i++){
            int  j=i;
            while(j>start&&A[j]<A[j-1]){
                temp=A[start];
                A[start]=A[end];
                A[end]=temp;
                j--;
            }
        }
    }
    public void merge(int []A,int low,int high,int mid){
        int []temp=new int [high-low+1];//建立一个临时空间存放排序好的元素
        int k=0;
        int i=low,j=mid+1;
        while(i<=mid&&j<=high){//将小的元素优先放到数组中
            if(A[i]>A[j]){
                temp[k++]=A[j++];
            }else{
                temp[k++]=A[i++];
            }
        }
        while(i<=mid){//将剩余的元素插入
            temp[k++]=A[i++];
        }
        while(j<=high){//同上
            temp[k++]=A[j++];
        }
        for( k=0,i=low;i<=high;i++,k++){//排序好后重新放回原数组中去
            A[i]=temp[k];
        }
    }
}