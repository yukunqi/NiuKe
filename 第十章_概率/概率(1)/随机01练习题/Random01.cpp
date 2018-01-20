#include <iostream>
#include <string>
using namespace std;


class RandomP {
public:
	static int f();
};

/**
 * 因为要等概率产生01 而p概率产生0 1-p产生1 那么若两者概率相乘就是相等的 所以01和10的出现的概率都是p*(1-p)
 * 此时生成函数生成01或者10即可
 * @author sony
 *
 */
class Random01 {
public:
    // 用RandomP::f()实现等概率的01返回
    int random01() {
        int n1;
        int n2;
        while(true){
            n1 = RandomP::f();
            n2 = RandomP::f();
            if(n1==n2)continue;
            else if(n1==1&&n2==0)return 1;
            else break;
        }
        return 0;
    }
     
};