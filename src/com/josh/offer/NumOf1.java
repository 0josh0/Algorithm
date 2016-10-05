package com.josh.offer;

import org.junit.Test;

/*
 * 二进制中1的个数
 * 位移运算，与&
 * n=(n-1)&n
 */
public class NumOf1 {

	@Test
	public void test(){
		System.out.println(solu2(3));
	}
	public int solu1(int n){
		int count=0;
		while(n>0){
			if((n&1)==1){
				count++;
			}
			n=n>>1;
		}
		return count;
	}
	public int solu2(int n){
		int count=0;
		while(n>0){
			count++;
			n=(n-1)&n;
		}
		return count;
	}
}
