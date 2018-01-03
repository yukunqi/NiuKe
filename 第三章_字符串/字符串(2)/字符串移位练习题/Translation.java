import java.util.*;
 
public class Translation {
	public String stringTranslation(String A, int n, int len) {
		String result = "";
		result = reverseString(A, 0, len - 1);//在0和len-1之间反转
		result = reverseString(result, len, n - 1);//在len和n-1之间反转
		result = reverseString(result, 0, n - 1);//整体字符串反转
		return result;
	}
	//字符串反转函数 在begin 和 end之间进行反转
	public String reverseString(String str, int begin, int end) {

		char[] chars = str.toCharArray();
		while (begin < end) {
			char temp = chars[begin];
			chars[begin] = chars[end];
			chars[end] = temp;
			end--;
			begin++;
		}
		return String.valueOf(chars);
	}
}