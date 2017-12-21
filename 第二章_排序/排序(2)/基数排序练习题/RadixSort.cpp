#include <iostream>
#include <queue>
using namespace std;


class RadixSort {
public:

	queue<int> g[10];

    int* radixSort(int* A, int n) {
        int radix=getMaxNumlength(A,n);//先获取最大数的位数

		for(int i=1;i<=radix;i++){//每一位都做一次比较重新排序然后放入数组中
			for(int j=0;j<n;j++){
				g[getIndexOfnum(A[j],i)].push(A[j]);
			}
			
			for(int m=0,k=0;m<10;m++){//将0-9号桶的元素重新放回到数组中
				while(!g[m].empty()){
					A[k++]=g[m].front();
					g[m].pop();
				}
			}
		}

		return A;
    }
	
	//获取整个数组最大数一共有多少位
	int getMaxNumlength(int *A,int n){
		int max=A[0];
		for(int i=0;i<n;i++){
			if(A[i]>max){
				max=A[i];
			}
		}
		return lengthOfnum(max);
	}
	
	//获取num一共有多少位
	int lengthOfnum(int num){
		int res=0;
		while(num>0){
			num/=10;
			res++;
		}
		return res;
	}
	//获取num的第n位的数字是多少
	int getIndexOfnum(int num,int n){
		int res=0;
		while(n>0){
			res=num%10;
			num/=10;
			n--;
		}

		return res;
	}
};

int main()
{

	int a[]={8,12,14};
	int n=3;
	RadixSort r;
	int *arr=r.radixSort(a,n);
	for(int i=0;i<n;i++){
		cout<<arr[i]<<" ";
	}
	cout<<endl;
	return 0;
}
