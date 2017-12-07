class InsertionSort {
public:
    int* insertionSort(int* A, int n) {
        int temp=0;
        int j=0;
        for(int i=1;i<n;i++){
            j=i;
            temp=A[j];//记录当前节点值
            while(j>0&&temp<A[j-1]){//从当前节点开始，向前进行一次插入排序过程并赋值元素
                A[j]=A[j-1];
                j--;
            }
            A[j]=temp;//最后把节点值放回进入数组中
        }
         
        return A;
    }
};