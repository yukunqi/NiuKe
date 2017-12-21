import java.util.*;
 
public class QuickSort {
    public int[] quickSort(int[] A, int n) {
        quickSort_1(A,0,n-1);
        return A;
    }
 
    public int Partition(int []A,int low,int high){
        if (A==null||low<0||high>=A.length){
            return -1;
        }
        int random_index=(low+high)/2;//随机生成一个候选值
        int temp;
        //把候选值和最后一个数进行交换
        temp=A[random_index];
        A[random_index]=A[high];
        A[high]=temp;
 
        //初始化一个记录小于等于候选值的下标: 当遍历数组时 如果当前元素小于候选值 则和j位置元素替换
        //j的初始值为数组的起点 low 当遍历完数组后 把候选值和当前j位置的元素交换
        int j=low;
        for (int i=low;i<high;i++){
            if (A[i]<A[high]){
				swap(A,i,j);
                j++;
            }
        }
        swap(A,j,high);
        //此时的数组小于候选值的数在前面，大于的则在后面
        return j;//返回候选值的下标位置
    }
 
    public void quickSort_1(int []A,int low,int high){
        if (low==high){//如果相等则递归结束
            return;
        }
        if(high-low<=10){//元素个数小于一定量时，使用效率更高的插入排序
            InsertionSort(A,low,high);
			return ;
        }
        int partition = Partition(A, low, high);//以候选值为分界点递归调用函数进行快速排序
        if (partition>low){//候选值的前半部分递归
            quickSort_1(A,low,partition-1);
        }
        if (partition<high){//候选值的后半部分递归
            quickSort_1(A,partition+1,high);
        }
    }
    
    public void swap(int []A,int a,int b){
        int temp=A[a];
		A[a]=A[b];
		A[b]=temp;
    }
    public void InsertionSort(int []A,int start,int end){
        int j=0;
		int temp=0;
		for(int i=start+1;i<=end;i++){
			temp=A[i];
			j=i;
			while(j>start&&temp<A[j-1]){
				A[j]=A[j-1];
				j--;
			}
			A[j]=temp;
		}
    }
}