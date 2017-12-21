
class Transform {
public:
    bool chkTransform(string A, int lena, string B, int lenb) {
        
        int letter[256];//初始化数组，全部为0 数组用来计算字符出现的次数
        memset(letter,0,sizeof(letter));
        
        if(lena!=lenb){//长度不相等 ，直接返回false
			return false;
		}

		
		int i;
		for(i=0;i<lena;i++){//字符串A出现的字符，在相应的ascii码位置上加1
			letter[A.at(i)]++;
		}

		for(i=0;i<lenb;i++){//字符串B出现的字符，在相应的位置减1，若最终都是0，则true 有一个不是就为false
			if(letter[B.at(i)]--==0){
				return false;
			}
		}

		return true;
    }
};