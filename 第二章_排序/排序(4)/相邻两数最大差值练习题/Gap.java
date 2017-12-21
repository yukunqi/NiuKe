import java.util.*;
 
public class Gap {
 public int maxGap(int[] A, int n) {
        int max=A[0];
        int min=A[0];
        for (int i=0;i<n;i++){
            max=Math.max(A[i],max);
            min=Math.min(A[i],min);
        }
        if (max==min){
            return 0;
        }
 
        boolean [] hasnum=new boolean[n+1];//用来标记第i号桶中是否有元素
        int [] maxs=new int[n+1];//放i号桶中的最大值
        int [] mins=new int[n+1];//放i号桶中的最小值
        for (int i=0;i<n;i++){
            int bid=locationBucketIndex(A[i],n,min,max);//定位元素具体在几号桶中
            maxs[bid]=hasnum[bid]?Math.max(maxs[bid],A[i]):A[i];//更新最大值
            mins[bid]=hasnum[bid]?Math.min(mins[bid],A[i]):A[i];//更新最小值
            hasnum[bid]=true;
        }
        int result=0;
        int i=0;
        int first_max=0;//第一个非空桶的最大值
        while (i<=n){//遍历寻找第一个有元素的桶的最大值
            if (hasnum[i]){
                first_max=maxs[i];
                break;
            }
            i++;
        }
        for (i=i+1;i<=n;i++){
            if (hasnum[i]){//代表这个桶中有元素
                result=Math.max(result,mins[i]-first_max);//后一个桶最小值-前一个桶最大值
                first_max=maxs[i];//更新最大值为当前桶最大值，然后i+1那么就变成前一个桶啦
            }
        }
 
        return result;
    }
     
    private int locationBucketIndex(long num,long length,long min,long max){
        return (int) ((num-min)*length/(max-min));
    }
}