
class Subsequence {
public:
    int shortestSubsequence(vector<int> A, int n) {
        int big=A[0];
		int small=A[n-1];
		int p=0;
		int q=n-1;
		for(int i=0;i<n;i++){
			if(big>A[i]){//如果第i个数比big大，更换big，直到有数比big小，记录下标。下标最终停留在最后一个比big小的数上。那么整个过程经历了从大到小再大，中间的未排序区间的末尾就是下标p
				p=i;
			}else{
				big=A[i];
			}

			if(small<A[n-i-1]){//如果第n-i-1个数比small小，更换small，直到有数比small大，记录下标。下标最终停留在最后一个比small大的数上，整个过程经历了从小到大再小，中间的未排序的开头就是下标q
				q=n-i-1;
			}else{
				small=A[n-i-1];
			}
		}

		if(p==0&&q==n-1){
			return 0;
		}

		return p-q+1;
    }
};