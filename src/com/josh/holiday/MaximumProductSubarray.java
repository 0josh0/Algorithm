package com.josh.holiday;

import org.junit.Test;

/*
 * 题意： 求数组中乘积最大的连续子数组
 * 分析：维护两个状态，当前连续最大值max和当前连续最小值min，最终的连续最大乘积maxSum = Max(maxSum,max)
 * 	    max为当前值nums[i]*max、nums[i]*min和nums[i]三个值中的最大值
 *  	min为当前值nums[i]*max、nums[i]*min和nums[i]三个值中的最小值
 * 
 */
public class MaximumProductSubarray {
	@Test
	public void test(){
		int[] nums={-1,-2,-9,-6};
		System.out.println(maxProduct(nums));
	}
	public int maxProduct(int[] nums) {
		if(nums.length==0) return 0;
		int max = nums[0];
		int min = nums[0];
		int maxSum = nums[0];
		for(int i=1;i<nums.length;i++){
			int cMax = max;
			max = Math.max(Math.max(nums[i]*max,nums[i]*min),nums[i]);
			min = Math.min(Math.min(nums[i]*cMax,nums[i]*min),nums[i]);
			maxSum = Math.max(maxSum, max);
		}
		return maxSum;
    }
}
