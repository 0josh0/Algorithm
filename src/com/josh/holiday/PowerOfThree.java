package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：判断一个整数是否是3的幂
 * 分析：1 用循环或者递归 --- 超时
 *      2 利用java的Math函数，先求以3为低的对数,切记结果取整！然后在乘方，看结果是否相等
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
//    	if(n==0) return false;
//    	double up = Math.log10(n);
//    	double down = Math.log10(3);
//    	int m = (int)(up/down);
//    	double nn = Math.pow(3, m);
//    	if(n==nn) return true;
    	return n==0?false:Math.pow(3, (int)((Math.log10(n))/(Math.log10(3))))==n;
    }
    public boolean isPowerOfThree1(int n) {
    	if(n==1) return true;
    	int i=3;
    	while(i<=n){
    		if(i==n) return true;
    		else i=i*3;
    	}
    	return false;
    }
    @Test
    public void test(){
    	System.out.println(isPowerOfThree(177148));
    }
}
