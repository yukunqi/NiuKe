class Find {
public:
    int findPos(vector<int> arr, int n) {
        
        if(arr[0]>n-1||arr[n-1]<0)
        {
            return -1;
        }
 
        int res=-1;
 
        int low,high,middle;
 
        low=0;
        high=n-1;
 
        while(low<=high)// 二分搜索
        {
            middle=low+(high-low)/2;
 
            if(arr[middle]==middle)// 当i==arr[i]时记录 下标 继续左半部分搜索
            {
                res=middle;
                high=middle-1;
            }
            else if(arr[middle]>middle)// 因为是有序无重复元素数组 若此时元素大于下标 而下标的增加是1 元素最小的变化也是1索引不可能再出现相等的情况
            {
                high=middle-1;
            }
            else if(arr[middle]<middle)// 同理 缩小范围到右半部分
            {
                low=middle+1;
            }
        }
 
        return res;
    }
};