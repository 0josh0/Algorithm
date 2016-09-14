package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：判断一个整数是否是2的幂
 * 分析：1 方法同powerofthree
 * 	   2 位运算。二进制中2的幂只有一位是1.1）直接用java的十进制转二进制函数，然后计算二进制中1的个数
 *   							  2）位运算计算二进制中1的个数
 */
public class PowerOfTwo {

	public boolean isPowerOfTwo(int n){
		if(n<=0) return false;
		int num = 1;
		for(int i=0;i<32;i++){
			if(n==num) return true;
			num=num<<1;
		}
		return false;
	}
	public boolean isPowerOfTwo2(int n){
		String binary = Integer.toBinaryString(n);
		int count = 0;
		for(int i=0;i<binary.length();i++){
			if(binary.charAt(i)=='1') count++;
		}
		return n<0?false:count==1;
	}
	public boolean isPowerOfTwo1(int n){
		return n==0?false:Math.pow(2,(int)((Math.log10(n))/(Math.log10(2))))==n;
	}
	@Test
	public void test(){
		System.out.println(isPowerOfTwo(16));
	}
}
