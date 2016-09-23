package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：根据给定一个丑陋数数组，求第n个超级丑陋数，超级丑陋数定义：只能是给定的丑陋数或者由丑陋数相乘得到的数
 * 分析：我们知道，新生成的丑陋数一定是，每个primes中的丑陋数，依次，和已找到排好序的丑陋数ugly中的，每一个相乘，中最小的一个
 *      这样，我们可以为primes中的每个丑陋数设置一个在已经找到的超级丑陋数ugly数组中建立索引，
 *      记录primes中的每个丑陋数乘到ugly中的位置，即第几个
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
        int[] pos = new int[k];//标记primes乘到ugly中的索引
        int[] ugly = new int[n];//已经排好序的丑陋数
        int[] val = new int[k];//存储primes[i]和ugly[j]的一次相乘，在其中求最小的
        ugly[0] = 1;
        for(int i=1;i<n;i++){
        	//int min = primes[0]*ugly[pos[0]];
        	for(int j=0;j<k;j++){
        		val[j] = primes[j]*ugly[pos[j]];
        	}
        	int min = findMin(val);
        	for(int p=0;p<k;p++){
        		if(primes[p]*ugly[pos[p]]==min) pos[p]++;//移动在ugly中的索引
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
