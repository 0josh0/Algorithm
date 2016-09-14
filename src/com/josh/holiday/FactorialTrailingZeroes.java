package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：求给定数阶乘末尾零的个数
 * 分析: 1 先求阶乘，在计算0的个数 - 超时
 *      2 n!末尾形成0的个数是由n!的因子中的2和5的个数决定的，一对2和5形成一个0，而2和5个数=5的个数，所以只要求出n!所有相乘因子中5的个数即可。
 *      
 */
public class FactorialTrailingZeroes {
	@Test
	public void test(){
		int n=20;
		//System.out.println(Math.)
		System.out.println(trailingZeroes(n));
	}
    public int trailingZeroes(int n) {
    	int count=0;
    	while(n/5>0){
    		n=n/5;
    		count=count+n;
    	}
		return count;
    }
    public int trailingZeroes1(int n) {
    	int i=2,res=1,count=0;
    	while(i<=n){
    		res=res*i;
    		i++;
    	}
    	while(res%10==0){
    		count++;
    		res=res/10;
    	}
		return count;
    }
}
