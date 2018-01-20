import java.util.Random;

/**
 * 随机打印M个数 每次打印一个数之后就把这个数放到末尾，主要作用就是使得下一次打印时不会再有机会出现，这样每次
 * 打印的过程中的每一个数的概率都是相等的
 * @author sony
 *
 */
public class RandomPrint {
	public int[] print(int[] arr, int N, int M) {
		int[] res = new int[M];
		Random random = new Random();
		for (int i = 0; i < M; i++) {
			int r = random.nextInt(N);
			res[i] = arr[r];
			swap(arr, r, N - 1);
			N--;
		}
		return res;
	}

	public void swap(int[] A, int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
}