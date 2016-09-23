package com.josh.holiday;

import org.junit.Test;

/*
 * 题意: 翻转一个整数的二进制bit，即01.
 * 分析: 1 求出32位上哪几位有1，然后2的32-i次幂相加 -- 越界！！
 *      2 利用位移运算，n&1判断当前位是否是1，若是，res|1，把Res对应位设置为1，然后n和res都>>右移1位
 */
public class ReverseBits {
	@Test
	public void test(){
		System.out.println(reverseBits(1));
	}
	public int reverseBits(int n) {
		int res=0;
		for(int i=0;i<31;i++){
			if((n&1)==1) res = res|1;
			n=n>>1;
			res=res<<1;
		}
		if((n&1)==1) res = res|1;
        return res;
    }
}
