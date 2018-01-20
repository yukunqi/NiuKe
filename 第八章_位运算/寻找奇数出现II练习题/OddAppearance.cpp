class OddAppearance {
public:
    vector<int> findOdds(vector<int> arr, int n) {
        int e=0;
        int i;
        for(i=0;i<n;i++)//将整个数组和0进行异或 得到的结果为2个出现奇数次的数的异或结果
        {
            e=e^arr[i];
        }
 
        int flag=0;
 
        for(i=0;i<32;i++)//寻找2个出现奇数次的数在第几位上不同 假设为第i位
        {
            flag=(1<<i);
            if((e&flag)!=0)
            {
                break;
            }
        }
 
        vector<int > res(2,0);
 
        for(i=0;i<n;i++)
        {
            if((arr[i]&flag)==flag)//说明和flag在第i位上相同 则将这些相同的数进行异或  这里会存在一个出现奇数次的数
            {
                res[0]=res[0]^arr[i];
            }
            else//这里会出现另一个奇数次的数
            {
                res[1]=res[1]^arr[i];
            }
        }
         
        sort(res.begin(),res.end());
 
        return res;
    }
};