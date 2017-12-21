class Merge {
public:
    int* mergeAB(int* A, int* B, int n, int m) {
        int end=n+m-1;
		int j=m-1;
		int i=n-1;
		while(j>=0&&i>=0){
			if(A[i]>B[j]){
				A[end--]=A[i--];
			}else{
				A[end--]=B[j--];
			}
		}

		while(j>=0){
			A[end--]=B[j--];
		}

		return A;
    }
};