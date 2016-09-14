package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺�ж�һ�������Ƿ���2����
 * ������1 ����ͬpowerofthree
 * 	   2 λ���㡣��������2����ֻ��һλ��1.1��ֱ����java��ʮ����ת�����ƺ�����Ȼ������������1�ĸ���
 *   							  2��λ��������������1�ĸ���
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
