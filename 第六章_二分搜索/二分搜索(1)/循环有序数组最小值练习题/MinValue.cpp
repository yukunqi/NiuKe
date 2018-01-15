int min(int a,int b)
{
    return a>b?b:a;
}
 
 
 
class MinValue {
public:
    int getMin(vector<int> arr, int n) {
        
        if(n==1)
        {
            return arr[0];
        }
 
        int low,high,middle;
         
        low=0;
        high=n-1;
 
        if(arr[low]<arr[high])// 若high大于low 说明在low到high之间整体有序 此时返回low的值则为最小值
        {
            return arr[low];
        }
 
        int res=0;
        while(low<=high)
        {
            middle=low+(high-low)/2;
 
            if(high-low==1)// 当数组中只有两个元素时 返回小的那个
            {
               res=min(arr[high],arr[low]);
               break;
            }
             
            if(arr[middle]<arr[low])// 当中间值小于最左边值的时候 最小值出现在左边
            {
                high=middle;
            }
            else if(arr[middle]>arr[high])// 当中间值大于最右边的值时 最小值出现在右边
            {
                low=middle;
            }
            else if(arr[middle]>=arr[low]&&arr[middle]<=arr[high])//若不满足以上的情况 则说明 low mid high 三者相等 此时通过遍历low和high之间的值来获得最小值
            {
                res=arr[low];
                for(int j=low;j<=high;j++)
                {
                    if(arr[j]<res)
                    {
                        res=arr[j];
                    }
                }
                break;
            }
        }
 
        return res;
    }
};