public class Compare {

	/*
	 * 分情况来讨论好理解： a和b符号相同： diffab为0 sameab为1 此时看cs的符号 若a大于b cs为1 那么returnA为1
	 * returnB为0 结果正确 a和b符号不相同： diffab为1 sameab为0 此时看as的符号 若a为正数b为负 那结果肯定为a大于b
	 * 看returnA为1 returnB为0 结果正确 a为负b为正 那肯定b大于a returnA为0 returnB为1 结果正确
	 */
	public int getMax(int a, int b) {
		int c = a - b;
		int as = sign(a);// a的符号位 1为正 0为负
		int bs = sign(b);// b的符号位 1为正 0为负
		int cs = sign(c);// 差值c的符号位 1为正 0为负

		int diffab = as ^ bs;// 判断a和b两个数的符号位是否相同 相同为0 不相同为1
		int sameab = flip(diffab);// 判断a和b两个数的符号位是否相同 相同为1不相同为0

		int returnA = diffab * as + sameab * cs;
		int returnB = flip(returnA);

		return a * returnA + b * returnB;
	}

	// 获取符号位后和1与操作再和1异或操作
	public int sign(int num) {
		return flip(num >> 31 & 1);
	}

	// 和1进行异或操作
	public int flip(int n) {
		return (n ^ 1);
	}

	// 方法二 更简单的判断
	public int getMax1(int a, int b) {
		int c = a - b;
		int sca = sign(c);// 若a-b大于0 sca为1 scb为0
		int scb = flip(sca);

		return sca * a + scb * b;
	}
}