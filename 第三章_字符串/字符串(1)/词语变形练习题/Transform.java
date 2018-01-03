import java.util.*;
 
public class Transform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        if (A==null||B==null||lena!=lenb){//长度不相等 ，直接返回false
            return false;
        }
        int [] map=new int[256];//初始化数组，全部为0 数组用来计算字符出现的次数
        for (int i=0;i<A.length();i++){//字符串A出现的字符，在相应的ascii码位置上加1
            map[A.charAt(i)]++;
        }
        for (int i=0;i<B.length();i++){//字符串B出现的字符，在相应的位置减1，若最终都是0，则true 有一个不是就为false
            if (map[B.charAt(i)]--==0){
                return false;
            }
        }
        return true;
    }
}