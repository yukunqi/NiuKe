import java.util.*;
 
public class HeapSort {
    public int[] heapSort(int[] A, int n) {
        headsort(A,n);
        return A;
    }
    public void headAdjust(int []A,int parent,int length){
        int temp=A[parent];//记录父节点值
        int children=parent*2+1;//取出子节点索引
        while(children<length){
            if(children+1<length&&A[children+1]>A[children]){//这里是构建大根堆
                children++;//取两个孩子节点中最大的那个
            }
            if(temp>A[children]){//如果父节点大于孩子节点 则退出 这三个节点满足条件
                break;
            }
	    //循环向子节点进行
            A[parent]=A[children];
            parent=children;
            children=children*2+1;
        }
        A[parent]=temp;//把最初的父节点放回二叉树中
    }
    public void headsort(int []A,int n){
        for(int i=n/2;i>=0;i--){//构建初始堆 从2/n开始调整二叉树
           headAdjust(A,i,A.length);
        }
        for(int i=n-1;i>0;i--){//把堆顶元素也就是最大值放到最后，然后每次进行一次堆调整
            swap(A,0,i);
            headAdjust(A,0,i);
        }
    }
    public void swap(int []A,int a,int b){
        int temp=A[a];
        A[a]=A[b];
        A[b]=temp;
    }
}