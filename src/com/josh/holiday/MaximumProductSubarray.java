package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺ �������г˻���������������
 * ������ά������״̬����ǰ�������ֵmax�͵�ǰ������Сֵmin�����յ��������˻�maxSum = Max(maxSum,max)
 * 	    maxΪ��ǰֵnums[i]*max��nums[i]*min��nums[i]����ֵ�е����ֵ
 *  	minΪ��ǰֵnums[i]*max��nums[i]*min��nums[i]����ֵ�е���Сֵ
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
