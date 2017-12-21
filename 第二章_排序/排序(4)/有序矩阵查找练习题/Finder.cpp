class Finder {
public:
    bool findX(vector<vector<int> > mat, int n, int m, int x) {
        bool result=false;
		int col=m-1;//列索引
		int row=0;//行索引

		while(col>=0&&row<n){

			if(x==mat[row][col]){//若相等，则找到这个数
				result=true;
				break;
			}

			if(x>mat[row][col]){//这个数比当前数大，则这个数在下一行
				row++;
			}else{//否则在前一列
				col--;
			}
		}

		return result;
    }
};