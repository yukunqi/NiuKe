class SlideWindow {
public:
    vector<int> slide(vector<int> arr, int n, int w) {
        vector<int> res;
        deque<int> dq;
        for(int i=0;i<n;i++){
            if(dq.empty()||arr[dq.back()]>arr[i])//当队列为空或者队尾索引下的元素大于数组元素，则入队索引
                dq.push_back(i);
            else{
                while(!dq.empty()&&arr[dq.back()]<arr[i]){//否则就一直出队
                    dq.pop_back();
                }
                dq.push_back(i);
            }
            if(i>=w-1){//赋值最大值数组
                while(!dq.empty() && i-dq.front()>w-1)
                    dq.pop_front();
                res.push_back(arr[dq.front()]);
            }
        }
        return res;
    }
};
