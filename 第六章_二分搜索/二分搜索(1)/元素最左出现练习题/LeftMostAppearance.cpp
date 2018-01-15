class LeftMostAppearance {
public:
    int findPos(vector<int> arr, int n, int num) {
         
 
        int res=-1;
 
        int low,high,middle;
 
        low=0;
        high=n-1;
 
        while(low<=high)// 二分搜索
        {
            middle=low+(high-low)/2;
 
            if(arr[middle]==num)// 当和目标值相等时 更新res下标
            {
                res=middle;
                high=middle-1;
            }
            else if(arr[middle]>num)
            {
                high=middle-1;
            }
            else if(arr[middle]<num)
            {
                low=middle+1;
            }
        }
 
        return res;
    }
};