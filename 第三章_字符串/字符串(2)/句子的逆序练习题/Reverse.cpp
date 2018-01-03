class Reverse {
public:
    string reverseSentence(string A, int n) {
        reverse(A.begin(),A.end());//先将字符串整体反转
        int i,j;//两个下标索引，分别指向要反转字符串的前和后
        for(i=0;i<n;i++){
            j=i;
            while(j<n&&A[j]!=' '){//当遇到空格时，反转每一个单词
                j++;
            }
            reverse(A.begin()+i,A.begin()+j);
            i=j;
        }
        return A;
    }
};