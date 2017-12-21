import java.util.*;
 
public class ThreeColor {
    public int[] sortThreeColor(int[] A, int n) {
        int font=0;//放置0的索引
        int back=n-1;//放置2的索引
        int temp;
        int i=0;
        while(i<=back){
            if(A[i]==0){//如果是0，交换到相应索引位置上，i后移
                temp=A[i];
                A[i]=A[font];
                A[font]=temp;
                font++;
                i++;
                continue;
            }
            if(A[i]==2){//如果是2,交换到相应的索引位置上，i不变，因为不知道交换过来的数字是否是0，若是还需要移动
                temp=A[i];
                A[i]=A[back];
                A[back]=temp;
                back--;
            }
            if(A[i]==1){//如果是1则不做操作
              i++; 
            }
            
        }
        return A;
    }
}