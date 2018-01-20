/**
 * 首先有一个随机产生1-5的函数 然后利用5*函数+函数 生成一个随机数在1-30之间的随机函数
 * 然后若生成的数不在7-20的范围内就再次随机的方式来控制随机函数等概率的生成数字在7-20的范围内
 * 之后再%7+1就能等概率随机生成1-7的数字了
 * @author sony
 *
 */
// 以下内容请不要修改
class Random5 {
public:
	static int randomNumber();
};

class Random7 {
public:
    int rand5() {
        return Random5::randomNumber();
    }
    // 以上内容请不要修改
    

    int randomNumber() {
        int num=rand5()*5+rand5();
		while(num>20||num<7){
			num=rand5()*5+rand5();
		}
		return (num%7)+1;
	}
};