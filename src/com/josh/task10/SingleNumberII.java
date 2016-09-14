package com.josh.task10;

import org.junit.Test;

/*
 * 题意: 在一个数组中每一个元素都出现三次，只有一个出现一次，找到那个出现一次的元素。要求时间复杂度O(N)，空间复杂度O(1)
 * 分析: 用一个32大小的数组记录每一位上出现1的次数，最后统计每一位上1的次数，对3取模，为1的位就是那个出现一次的数产生的
 */
public class SingleNumberII {
	@Test
	public void test(){
		int [] nums = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
		System.out.println(singleNumber(nums));
	}
    public int singleNumber(int[] nums) {
    	int[] num=new int[32];
    	int singleNum=0;
    	for(int i=0;i<32;i++){//统计第i位上的1的个数
    		for(int j=0;j<nums.length;j++){
    			if(((nums[j]>>i) & 1)==1) num[i]++;
    		}
    		//num[i] = num[i]%3;
    		//singleNum +=num[i]*Math.pow(2, i);
    		singleNum |= ((num[i] % 3) << i);
    	}
		return singleNum;
        
    }
}
