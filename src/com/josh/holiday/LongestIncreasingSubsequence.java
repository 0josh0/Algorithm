package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：寻找数组中最大增长子序列
 * 分析：1 动态规划求解：dp[i]=max[dp[j]+1] j<i && nums[i]>nums[j]，O(n2)
 * 		  整体思想，当前位置为i，遍历i之前的所有dp[j],注意不是num[j]，若nums[i]>nums[j] dp[i]=dp[j]+1
 * 	   2 优化查找dp[j]
 */
public class LongestIncreasingSubsequence {
	@Test
	public void test(){
		int[] nums={1,3,6,7,9,4,10,5,6};
		System.out.println(lengthOfLIS(nums));
	}
	public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int[] dp = new int[nums.length];
        for(int i=0;i<dp.length;i++){
        	dp[i] = 1;
        }
        int max = 1;
        for(int i=1;i<nums.length;i++){
        	for(int j=0;j<i;j++){
        		if(nums[i]>nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
        	}
        	max = Math.max(max, dp[i]);
        }
		return max;
    }
}
