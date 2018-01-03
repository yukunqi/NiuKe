import java.util.*;

public class Replacement {
	public String replaceSpace(String iniString, int length) {
		int numOfblank = 0;// 空格数量

		for (int i = 0; i < length; i++) {// 计算空格数量
			if (iniString.charAt(i) == ' ') {
				numOfblank++;
			}
		}

		int len = length + numOfblank * 2;// 新的字符串长度
		char str[] = new char[len];// 开辟新的空间
		int k = len - 1;
		for (int i = length - 1; i >= 0; i--) {// 倒序赋值
			if (iniString.charAt(i) == ' ') {
				str[k--] = '0';
				str[k--] = '2';
				str[k--] = '%';
			} else {
				str[k--] = iniString.charAt(i);
			}
		}

		return String.valueOf(str);
	}
}