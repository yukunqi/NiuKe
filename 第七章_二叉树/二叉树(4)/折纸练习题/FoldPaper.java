import java.util.ArrayList;

public class FoldPaper {
	public String[] foldPaper(int n) {
		ArrayList<String> list = new ArrayList<>();
		Inorder(list, n, "down");
		String[] arr = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			arr[i] = list.get(i);
		}
		return arr;
	}

	// ÀàËÆÖÐÐò±éÀú
	public void Inorder(ArrayList<String> list, int n, String val) {
		if (n == 0) {
			return;
		}
		Inorder(list, n - 1, "down");
		list.add(val);
		Inorder(list, n - 1, "up");
	}
}