/**
 * 随机打印M个数 每次打印一个数之后就把这个数放到末尾，主要作用就是使得下一次打印时不会再有机会出现，这样每次
 * 打印的过程中的每一个数的概率都是相等的
 * @author sony
 *
 */
class RandomPrint {
public:
    vector<int> print(vector<int> arr, int N, int M) {
        vector<int> res;
		for(int i=0;i<M;i++){
			int r=rand()%(N);
			res.push_back(arr[r]);
			swap(arr[r],arr[N-1]);
			N--;
		}
		return res;
    }

};