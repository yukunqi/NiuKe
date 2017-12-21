import java.util.*;
 
public class Finder {
   public boolean findX(int[][] mat, int n, int m, int x) {
        int num=mat[0][m-1];
        int i=0;//行索引
	int j=m-1;//列索引
        while (i<n&&j>=0){
            num=mat[i][j];
            if (x>num){//这个数比当前数大，则这个数在下一行
                i++;
            }
            if (x<num){//否则在前一列
                j--;
            }
            if (x==num){//若相等，则找到这个数
                return true;
            }
        }
        return false;
    }
}