package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺���ݸ���һ����ª�����飬���n��������ª����������ª�����壺ֻ���Ǹ����ĳ�ª�������ɳ�ª����˵õ�����
 * ����������֪���������ɵĳ�ª��һ���ǣ�ÿ��primes�еĳ�ª�������Σ������ҵ��ź���ĳ�ª��ugly�еģ�ÿһ����ˣ�����С��һ��
 *      ���������ǿ���Ϊprimes�е�ÿ����ª������һ�����Ѿ��ҵ��ĳ�����ª��ugly�����н���������
 *      ��¼primes�е�ÿ����ª���˵�ugly�е�λ�ã����ڼ���
 */
public class SuperUglyNumber {
	@Test
	public void test(){
		int[] primes = {2, 3, 5};
		nthSuperUglyNumber(2, primes);
		//System.out.println(nthSuperUglyNumber(12, primes));
	}
	public int nthSuperUglyNumber(int n, int[] primes) {
        int k=primes.length;
        int[] pos = new int[k];//���primes�˵�ugly�е�����
        int[] ugly = new int[n];//�Ѿ��ź���ĳ�ª��
        int[] val = new int[k];//�洢primes[i]��ugly[j]��һ����ˣ�����������С��
        ugly[0] = 1;
        for(int i=1;i<n;i++){
        	//int min = primes[0]*ugly[pos[0]];
        	for(int j=0;j<k;j++){
        		val[j] = primes[j]*ugly[pos[j]];
        	}
        	int min = findMin(val);
        	for(int p=0;p<k;p++){
        		if(primes[p]*ugly[pos[p]]==min) pos[p]++;//�ƶ���ugly�е�����
        	}
        	ugly[i] = min;
        	//System.out.println(ugly[i]);
        }
		return ugly[n-1];
    }
	public int findMin(int[] val){
		int min = val[0];
		for(int i=1;i<val.length;i++){
			if(val[i]<min) min=val[i];
		}
		return min;
	}
}
