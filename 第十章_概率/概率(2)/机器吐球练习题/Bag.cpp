/**
 * 蓄水池抽样算法：
 * 1.处理1-k号球时，直接放入袋子中
 * 2.处理第i号球(此时i大于k)的时候，以k/i的概率决定是否把i号球放入袋中，若放入还要在袋子中随机扔掉一个
 * @author sony
 *
 */
class Bag {
public:
	vector<int> ret;
    // 每次拿一个球都会调用这个函数，N表示第i次调用
    vector<int> carryBalls(int N, int k) {
        if(N<=k){
            ret.push_back(N);
		}
        else{
            int r=rand()%N;
            //压入概率k/N
            if(r<k)//随机等概率吐出球
                ret[r]=N;
        }
        return ret;
    }
};