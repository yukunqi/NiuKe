import java.util.*;

/**
 * 首先有一个随机产生1-5的函数 然后利用5*函数+函数 生成一个随机数在1-30之间的随机函数
 * 然后若生成的数不在7-20的范围内就再次随机的方式来控制随机函数等概率的生成数字在7-20的范围内
 * 之后再%7+1就能等概率随机生成1-7的数字了
 * @author sony
 *
 */
public class Random7 {
    private static Random rand = new Random(123456);
    // 随机产生[1,5]
    private int rand5() {
        return 1 + rand.nextInt(5);
    }
    
    // 通过rand5实现rand7
    public int randomNumber() {
    	int num=rand5()*5+rand5();
    	while (num>20||num<7) {
			num=rand5()*5+rand5();
		}
    	return (num%7)+1;
    }
}