import java.util.Random;

/**
 * 因为要等概率产生01 而p概率产生0 1-p产生1 那么若两者概率相乘就是相等的 所以01和10的出现的概率都是p*(1-p)
 * 此时生成函数生成01或者10即可
 * @author sony
 *
 */
public class Random01 {
	private static double p = new Random().nextFloat();

	// 随机概率p
	public static int f() {
		return new Random().nextFloat() < p ? 0 : 1;
	}

	public int random01() {
		// 通过f函数实现01等概率返回
		StringBuilder builder = new StringBuilder();
		while (true) {
			String string = builder.append(f()).append(f()).toString();
			if (string.equals("01")) {
				return 0;
			}
			if (string.equals("10")) {
				return 1;
			}
			builder = new StringBuilder();
		}
	}
}