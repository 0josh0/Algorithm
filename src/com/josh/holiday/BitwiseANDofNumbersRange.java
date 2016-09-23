package com.josh.holiday;
/*
 * 题意：从给的整数范围内求所有数字AND&的和
 * 分析：&操作-只要有一个数的位上是0，即为0.
 * 		分析发现，最后结果各个位上的数字等于：所有数各个位上相同的数字(0/1)，不同的位全部为0；
 * 		所以，位操作，比较m和n即可(最大值和最小值)，按位比较，相等继续向后比较，直到不相等，取相等部分，后面不等部分全部为0
 */
public class BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
        int bitCount=0;
        while(m!=n){
        	m=m>>1;
        	n=n>>1;
        	bitCount++;
        }
        return m<<bitCount;
    }
}
