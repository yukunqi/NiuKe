class Translation {
public:
    string stringTranslation(string A, int n, int len) {
        reverse(A.begin()+0,A.begin()+len);//先反转0-len长度字符串
		reverse(A.begin()+len,A.end());//再反转len到末尾字符串
		reverse(A.begin(),A.end());//最后反转整体字符串
		return A;
    }
};