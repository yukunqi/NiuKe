import java.util.*;


/*
 * 这道题这样分析：正N边形的N个蚂蚁，每个蚂蚁可以有2种走法选择，所以一共有2的n次方的走法
 * 然后不碰头的的情况只有2种 就是大家都顺时针走和逆时针走 所以碰头的概率就是 总的走法-2/总的走法
 */
public class Ants {
    public int[] collision(int n) {
    	int fenmu=(int) Math.pow(2, n);
    	int fenzi=fenmu-2;
    	int yue=gcd(fenmu, fenzi);
    	fenmu=fenmu/yue;
    	fenzi=fenzi/yue;
    	int res[]=new int [2];
    	res[0]=fenzi;
    	res[1]=fenmu;
    	
    	return res;
    }
    


	// 辗转相除法求最大公约数 要求m>n
	public int gcd(int m, int n) {
		while (true) {
			if ((m = m % n) == 0) {
				return n;
			}
			if ((n = n % m) == 0) {
				return m;
			}
		}
	}
}