import java.util.*;

/**
 * 蓄水池抽样算法：
 * 1.处理1-k号球时，直接放入袋子中
 * 2.处理第i号球(此时i大于k)的时候，以k/i的概率决定是否把i号球放入袋中，若放入还要在袋子中随机扔掉一个
 * @author sony
 *
 */
public class Bag {
    private int [] selected = null;
    private static Random rand = new Random(12345);
    // 每次拿一个球都会调用这个函数，N表示第i次调用
    public int[] carryBalls(int N, int k) {
    	selected=new int [k];
    	if (N<=k) {
			selected[N-1]=N;
		}else {
		    int i=rand.nextInt(k);
            
            if(rand.nextInt(N)<k){//决定放入的概率是k/i
            selected[i]=N;
            }
		}
        return selected;
    }
}