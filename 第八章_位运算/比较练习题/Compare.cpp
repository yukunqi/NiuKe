
/*
	  分情况来讨论好理解： a和b符号相同： diffab为0 sameab为1 此时看cs的符号 若a大于b cs为1 那么returnA为1
	  returnB为0 结果正确 a和b符号不相同： diffab为1 sameab为0 此时看as的符号 若a为正数b为负 那结果肯定为a大于b
	  看returnA为1 returnB为0 结果正确 a为负b为正 那肯定b大于a returnA为0 returnB为1 结果正确
*/
class Compare {
public:
    int getMax(int a, int b) {
        int sa=sign(a);//获取a的符号
        int sb=sign(b);//获取b的符号
        int sc=sign(a-b);//获取a-b的符号
        int difsab=sa^sb;// ab符号相同则为0 ab符号不同则为1
        int samesab=flip(difsab);//和difab相反
 
        int returnA=sa*difsab+sc*samesab;
        int returnB=flip(returnA);
 
        return b*returnA+a*returnB;
    }
 
    int sign(int n)
    {
        return (n>>31)&1;
    }
 
    int flip(int n)
    {
        return n^1;
    }
 
};