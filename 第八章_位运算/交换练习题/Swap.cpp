class Swap {
public:
    vector<int> getSwap(vector<int> num) {
        swap(num[0],num[1]);
        return num;
    }
    /*
	 举例说明：
	 a=a^b
	 b=a^b  式子变化得: b=a^b^b 因为 b^b=0 所以 b=a^0=a;
	 a=a^b  式子变化得: a=a^b^a 所以a=b
    */
    void swap(int &a,int &b)
    {
        a=a^b;
        b=a^b;
        a=a^b;
    }
};