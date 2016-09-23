package com.josh.holiday;

import org.junit.Test;

/*
 * 题意: 数组中的每一个元素都出现两次，只有两个出现一次，找出这两个出现一次的元素
 * 分析: 位操作。全部异或，最后得到那两个不同数的异或结果
 * 		在两个数的异或结果中，从后向前找到第一个位上为1的位i，据此分析，
 *      这个1，一定是那两个不同的数字异或形成的，因为其他数字都是成对出现，
 *      异或后各个位上的结果必然为0，所以1一定是那两个不同的数字产生的。
 *      然后遍历nums中所有元素，根据第i位上是1或0，分成两部分，转化为SingleNumberI中的问题
 *      进而找到两个数字。
 */
public class SingleNumberIII {
	@Test
	public void test(){
		int[] array = {0,1,2,1};
		int[] a = new int[2];
		a=singleNumber(array);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		//System.out.println((-2)&(2));
	}
	public int[] singleNumber(int[] nums) {
		int res =0;
		int[] a = new int[2];
 		for(int i=0;i<nums.length;i++){
			res^=nums[i];
		}
 		
 		int firstIndex=1;//找到res第一个出现1的位
 		while((res&1)==0){
 			res = res>>1;
 			firstIndex++;
 		}
 		//根据第firstIndex位上是否为1分两种情况
		for(int i=0;i<nums.length;i++){
			if(((nums[i]>>(firstIndex-1))&1)==0){
				a[0]^= nums[i];
			}else{
				a[1]^= nums[i];
			}
		}
		return a;
    }
}
