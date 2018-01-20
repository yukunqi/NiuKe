class Clear {
public:
    int getWinner(vector<int> A, int n) {
        sort(A.begin(),A.end());
        int res=0;
        int j;
        for(int i=0;i<n;){
            int num=0;
            j=i;
            while(j<n&&A[i]==A[j]){
                j++;
                num++;
            }
            i=j;
            res^=num;
        }
        return res!=0;
    }
};