package com.josh.holiday;

import org.junit.Test;

/*
 * 题意: 寻找一个数组中连续几个最大值
 * 分析: DP - 动态规划
 * 		dp[0] = num[0]
 * 	    dp[i] = Max(num[i],dp[i-1]+num[i])
 */
public class MaximumSubarray {
	@Test
	public void test(){
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
	public int maxSubArray(int[] nums) {
        if(nums.length==0) return 0;
        int dp=nums[0],max=dp;
        for(int i=1;i<nums.length;i++){
        	dp=Math.max(nums[i], nums[i]+dp);
        	max=Math.max(max, dp);
        }
        return max;
    }
}
