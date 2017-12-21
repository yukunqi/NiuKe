class Gap {
public:
    int maxGap(vector<int> A, int n) {
        int max=A[0];
		int min=A[0];
		
		int i;
		for(i=0;i<n;i++){
			if(max<A[i]){
				max=A[i];
			}
			if(min>A[i]){
				min=A[i];
			}
		}

		if(max==min){
			return 0;
		}

		//因为我们最后进行操作的都是一个桶中的最大值和最小值，所以对于其他的元素我们就不需要记录
		vector<int> maxs(n,INT_MIN);//放i号桶中的最大值
		vector<int> mins(n,INT_MAX);//放i号桶中的最小值
		
		
		int len=max-min;

		for(i=0;i<n;i++){
			int bid=(double)(A[i]-min)/len*(n-1);//定位元素具体在几号桶中
			maxs[bid]=_max(maxs[bid],A[i]);//更新最大值
			mins[bid]=_min(mins[bid],A[i]);//更新最小值
		}
		
		int res=0;
		int pre=maxs[0];

		for(i=1;i<n;i++){
			if(mins[i]!=INT_MAX){//代表这个桶中有元素
				res=_max(res,mins[i]-pre);//后一个桶最小值-前一个桶最大值
				pre=maxs[i];//更新最大值为当前桶最大值，然后i+1那么就变成前一个桶啦
			}
		}
		return res;
    }

	int _max(int a,int b){
		return a>b?a:b;
	}

	int _min(int a,int b){
		return a>b?b:a;
	}
};
