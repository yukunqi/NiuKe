
//这道题需要注意的是 牛客OJ在判断的时候是按照老师的答案来的 所以在当出现可以向左右两边选择二分的时候 请参考这里代码的顺序
class Solution {
public:
    int getLessIndex(vector<int> arr) {
        if(arr.size()==0)
        {
            return -1;
        }
         
        int len=arr.size();
 
        if(arr.size()==1)
        {
            return 0;
        }
        else
        {
            if(arr[1]>arr[0])// 最左边判断局部最小
            {
                return 0;
            }
            if(arr[len-2]>arr[len-1])// 最右边判断局部最小
            {
                return  len-1;
            }
        }
 
        int low,high,middle;
         
        low=0;
        high=len-1;
        while(low<high)
        {
            middle=low+(high-low)/2;
 
            if(arr[middle-1]>arr[middle]&&arr[middle+1]>arr[middle])
            {
                return middle;
            }
 
            if(arr[middle]>arr[middle-1])// 优先选择缩小范围到左边半部分 若选择右边则可能OJ会判错
            {
                high=middle;
            }
            else if(arr[middle]>arr[middle+1])
            {
                low=middle;
            }
        }
 
        return -1;
    }
};