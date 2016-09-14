package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：和问题1条件类似，不能同是访问相邻的两个数，求最大间隔子序列，比问题1多一个要求：首位不能相邻
 * 分析：动态规划 dp[i] = max(dp[i-1],dp[i-2]+nums[i],dp[i-3]+nums[i])
 */
public class HouseRobberII {
	@Test
	public void test(){
		int[] nums = {1,1,3,6,7,10,7,1,8,5,9,1,4,4,3};
		System.out.println(helper(nums, 0, nums.length-2));
		System.out.println(helper(nums, 1, nums.length-1));
		//System.out.println(rob(nums));
	}
	public int rob(int[] nums) {
		if(nums.length==0) return 0;
        if(nums.length<3){
        	return nums.length==1?nums[0]:Math.max(nums[0], nums[1]);
        }
        if(nums.length==3) return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        return Math.max(helper(nums, 0, nums.length-2), helper(nums,1,nums.length-1));
    }
	 public int helper(int[] nums,int start,int end) {
		 int len = end-start+1;
	 		if(len==0) return 0;
	        if(len<3){
	        	return len==1?nums[start]:Math.max(nums[start], nums[end]);
	        }
	        if(len==3) return Math.max(nums[start]+nums[start+2],nums[start+1]);
	        int pre1 = nums[start],pre2=nums[start+1],pre3=nums[start+2]+nums[start],pre4 = Math.max(Math.max(pre3, pre2+nums[start+3]),pre1+nums[start+3]);
	        for(int i=start+4;i<end+1;i++){
	        	pre1 = pre2;
	        	pre2 = pre3;
	        	pre3 = pre4;
	        	pre4=Math.max(Math.max(pre3, pre2+nums[i]),pre1+nums[i]);
	        }
	        return pre4;
	   }
}
