package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：计算一个int型整数的二进制中有几个1
 * 分析：1、十进制转换二进制，计算1的个数
 *     2、先向右位移一位，再向左位移一位（即移动回来），比较移动前后数值大小变化，若有变化，此位置为1，否则为0
 *     e.g. 原数 0001101(13) -> 向右移动一位 0000110(6) -> 向左移动一位 0001100(12) -> 13-12!=0 -> 此位置是1
 */
public class NumberofBits {
	@Test
	public void test(){
		int n=13;
		//String s = Integer.toBinaryString(n);
		
		System.out.println(hammingWeight2(n));
		
	}
	//通过位移运算
	public int hammingWeight1(int n) {
		int count = 0,left=0,m=0;
		for(int i=0;i<32;i++){
			m=n;
			n = n>>>1;
			left = n<<1;
			if((m-left)==1) count++;
		}
        return count;  
    }
	//通过位运算&(与)，只有当两个对应位置都是1是，结果对应位置才为1，否则都为0
	public int hammingWeight2(int n) {
		int count = 0;
		while(n!=0){
			count = count + (n & 1);
			n = n>>>1;
		}
        return count;  
    }
	public int hammingWeight(int n) {
		String binaryString  = Integer.toBinaryString(n);
		int count=0;
		for(int i=0;i<binaryString.length();i++){
			if(binaryString.charAt(i)=='1')count++;
		}
        return count;  
    }
}
