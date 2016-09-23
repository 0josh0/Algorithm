package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺����һ������nums��һ������s����Ͳ�С��s�����������
 * ������˫ָ��+sum
 */
public class MinimumSizeSubarraySum {
	@Test
	public void test(){
		int[] nums = {5,1,3 ,5,10,7,4,9,2,8};
		System.out.println(minSubArrayLen(15, nums));
	}
	public int minSubArrayLen(int s, int[] nums) {
		int minLen=nums.length,left=0,right=0,sum=0;
		boolean flag=false;
		while(right<=nums.length){
			if(sum<s){
				if(right==nums.length) break;
				sum+=nums[right++];
			}else if(sum>=s){
				minLen=Math.min(minLen, right-left);
				flag=true;
				if(minLen==1) break;
				sum-=nums[left++];
			}
		}
		return flag?minLen:0;
    }
}
