class ScaleSort {
public:
    vector<int> sortElement(vector<int> A, int n, int k) {
        
		int i;

		vector<int> minheap(k);//创建一个k大小的小根堆
		
		for(i=0;i<k;i++){//利用数组A的前K个值初始化小根堆
            minheap[i] = A[i];
        }

		for(i=k/2;i>=0;i--){//调整初始堆
			head_and_just(minheap,i,k);
		}

		for(i=0;i<n-k;i++){//将数组A的值和小根堆堆顶替换，然后做堆调整。
			A[i]=minheap[0];
			minheap[0]=A[i+k];
			head_and_just(minheap,0,k);
		}

		for(i=n-k;i<n;i++){//剩下最后k个数，每次调整小根堆，把堆顶元素赋值给A数组后，就缩小小根堆的大小
			A[i]=minheap[0];
			minheap[0]=minheap[k-1];
			head_and_just(minheap,0,k--);
		}

		return A;
    }
	//调整小根堆的函数
	void head_and_just(vector<int> &A,int start,int end){
		int temp=A[start];
		int child=start*2+1;

		while(child<end){
			if(child+1<end&&A[child+1]<A[child]){
				child++;
			}

			if(temp<A[child]){
				break;
			}

			A[start]=A[child];
			start=child;
			child=child*2+1;
		}

		A[start]=temp;
	}
};