import java.util.*;
 
public class ScaleSort {
    public int[] sortElement(int[] A, int n, int k) {
        int [] temp=Arrays.copyOf(A,k);//拷贝大小为k的数组
        for (int i=k/2;i>=0;i--){//建立初始堆
            HeadAdjust(temp,i,k);
        }
        for (int i=k;i<n;i++){//初始堆的堆顶为整个数组的最小值，因为每个元素移动距离不超过k即可完成排序，则0-k中一定包含最小值
            A[i-k]=temp[0];//把堆顶赋值给数组的第一个位置
            temp[0]=A[i];//把数组的后一个元素加入堆中，放置在堆顶
            HeadAdjust(temp,0,k);//调整堆
        }
 
        for (int i=n-k;i<n;i++){//剩下的最后这个k大小的堆内元素按照原始的堆排序进行输出,也就是把n-k到n这个范围的数组按照堆排序
            A[i]=temp[0];//堆顶元素赋值给数组
            //交换第一个位置和最后一个位置元素
            int t=temp[0];
            temp[0]=temp[k-1];
            temp[k-1]=t;
            HeadAdjust(temp,0,--k);//调整堆
        }
        return A;
    }
    public void HeadAdjust(int [] A,int parent,int length){
        int temp=A[parent];
        int child=parent*2+1;//左孩子
        while (child<length){
            if (child+1<length&&A[child]>A[child+1]){//看看是否存在右孩子，如果存在并且右孩子还小 则选取右孩子
                child++;
            }
            if (temp<=A[child]){//父子节点和孩子节点中最小的节点进行比较 如果父子节点还小 ，那么就符合父子节点大于任意子节点的规则 则直接break掉
                break;
            }
            A[parent]=A[child];//父子节点和最小的子节点交换
            parent=child;//向下筛选
            child=child*2+1;
        }
        A[parent]=temp;//最后一个节点和最初节点交换
    }
}