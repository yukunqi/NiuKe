#include <iostream>
using namespace std;


class CountingSort {
public:
    int* countingSort(int* A, int n) {
        int i;
		int max=A[0];
		int min=A[0];

		for(i=0;i<n;i++){//找到最大值和最小值，用来确定数组大小
			if(A[i]>max){
				max=A[i];
			}

			if(A[i]<min){
				min=A[i];
			}
		}
		int len=max-min+1;
		int *arr=new int [len];//开辟一块新的数组，大小为len


		
		for(i=0;i<len;i++){
			arr[i]=0;
		}

		for(i=0;i<n;i++){//把数字赋值进入新数组
			arr[A[i]-min]++;
		}

		int k=0;

		for(i=0;i<len;i++){//按照顺序依次倒出数字
			while(arr[i]>0){
				A[k++]=i+min;
				arr[i]--;
			}
		}

		return A;
    }
};

