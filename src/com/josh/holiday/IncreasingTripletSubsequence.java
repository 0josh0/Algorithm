package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺��һ���������飬�ж������Ƿ���ڳ���Ϊ3�ĵ���������
 * ������1��˫��ѭ�� O(n2)
 * 		2��DP
 */
public class IncreasingTripletSubsequence {
	@Test
	public void test(){
		int[] nums={1,3,6,7,9,4,10,5,6};
		System.out.println(increasingTriplet(nums));
	}
	public boolean increasingTriplet(int[] nums) {
		if(nums.length==0) return false;
		int[]dp=new int[nums.length];
		int max=1;
		for(int i=0;i<nums.length;i++){
			dp[i]=1;
		}
		for(int i=1;i<nums.length;i++){
			for(int j=0;j<i;j++){
        		if(nums[i]>nums[j]) dp[i] = Math.max(dp[i], dp[j]+1);
        	}
			max=Math.max(max, dp[i]);
			//System.out.println(dp[i]);
		}
		return max>2; 
    }
}
