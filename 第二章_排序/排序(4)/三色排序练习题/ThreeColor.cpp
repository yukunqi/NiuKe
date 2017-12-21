class ThreeColor {
public:
    vector<int> sortThreeColor(vector<int> A, int n) {
        int index_0=0;//放置0的索引
		int index_2=n-1;//放置2的索引
		int i=0;

		while(i<=index_2){
			if(A[i]==1){//如果是1则不做操作
				i++;
			}else if(A[i]==0){//如果是0，交换到相应索引位置上，i后移
				swap(A,index_0,i);
				index_0++;
				i++;
			}else if(A[i]==2){//如果是2,交换到相应的索引位置上，i不变，因为不知道交换过来的数字是否是0，若是还需要移动
				swap(A,index_2,i);
				index_2--;
			}
		}

		return A;
    }

	void swap(vector<int> &A,int a,int b){
		int t=A[a];
		A[a]=A[b];
		A[b]=t;
	}
};