import java.util.*;

/**
 * 当行和列都走偶数步时 B获胜 否则A获胜
 * @author sony
 *
 */
public class Game {
    public char getWinner(int n, int m) {
    	if ((n-1)%2==0&&(m-1)%2==0) {
			return 'B';
		}else {
			return 'A';
		}
    }
}