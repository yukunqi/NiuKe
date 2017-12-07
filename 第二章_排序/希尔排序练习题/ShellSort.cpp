class ShellSort {
public:
    int* shellSort(int* A, int n) {
        int gap=n/2;//间隔为gap 每次gap除以2
		int temp=0;
		int j=0;
		while(gap>=1){//参考插入排序 只是这里gap不是1 把gap换成1就和插入排序很像了
		
			for(int i=gap;i<n;i++){
				temp=A[i];
				j=i;
				while(j>=gap&&temp<A[j-gap]){
					A[j]=A[j-gap];
					j-=gap;
				}
				A[j]=temp;
			}
			gap=gap/2;
		}
		return A;
    }
};