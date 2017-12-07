class QuickSort {
public:
    int* quickSort(int* A, int n) {
        quickPass(A,0,n-1,n);
        return A;
    }

	void quickPass(int *A,int low,int high,int n){
	
		if(low==high){
			return ;
		}

		if(high-low<=10){//元素个数小于一定量时，使用效率更高的插入排序
			InsertionSort(A,low,high);
			return ;
		}

		int j=Partition(A,low,high,n);
        
		//递归进行
		if(j>low){
			quickPass(A,low,j-1,n);
		}

		if(j<high){
			quickPass(A,j+1,high,n);
		}
	}


	int Partition(int *A,int low,int high,int n){
		if(A==NULL||low<0||high>n){//安全边界检查
			return -1;
		}

		int mid_index=(low+high)/2;//这里假设使用中间值作为标准值
		swap(A,mid_index,high);

		int j=low;
		for(int i=low;i<=high;i++){//把比标准值小的移到前面，大的移到它的后面
			if(A[i]<A[high]){
				swap(A,i,j);
				j++;
			}
		}
		swap(A,j,high);
		return j;//返回标准值此时下标索引
	}

	void swap(int *A,int a,int b){
		int temp=A[a];
		A[a]=A[b];
		A[b]=temp;
	}

	void InsertionSort(int *A,int start,int end){
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
};