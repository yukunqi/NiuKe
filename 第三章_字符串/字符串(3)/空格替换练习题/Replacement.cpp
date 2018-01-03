class Replacement {//剑指offer原题 替换空格
public:
    string replaceSpace(string iniString, int length) {
        int numOfblank=0;
		int i;
		for(i=0;i<length;i++){//计算空格的数量
			if(iniString[i]==' '){
				numOfblank++;
			}
		}

		int len=length+numOfblank*2;//新字符串长度
		char *str=new char [len];//开辟新的字符数组
		str[len]='\0';
		int k=len-1;
		for(i=length-1;i>=0;i--){//倒序赋值 遇到空格赋值%20
			if(iniString[i]==' '){
				str[k--]='0';
				str[k--]='2';
				str[k--]='%';
			}else{
				str[k--]=iniString[i];
			}
		}

		return str;
    }
};
