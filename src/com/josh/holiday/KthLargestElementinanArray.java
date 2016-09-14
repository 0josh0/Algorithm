package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：求无序数组中第k大的数
 * 分析：直观求法，先排序，然后get
 * 
 */
public class KthLargestElementinanArray {
	@Test
	public void test(){
		int[] nums = {3,5,7,2,1,3};
//		quickSosrt(nums, 0, 5);
//		for(Integer i:nums){
//			System.out.println(i);
//		}
		System.out.println(findKthLargest(nums,2));
	}
	public int findKthLargest(int[] nums, int k) {
		quickSosrt(nums, 0, nums.length-1);
		return nums[nums.length-k]; 
    }
	//快排-排第一个
	public int helper(int[] nums,int left,int right){
		int tmp = nums[left];
		while(left<right){
			while(left<right&&nums[right]>=tmp) right--;
			nums[left] = nums[right];
			while(left<right&&nums[left]<=tmp) left++;
			nums[right] = nums[left];
		}
		nums[left] = tmp;
		return left;
	}
	public void quickSosrt(int[] nums,int left,int right){
		if(left<right){
			int mid = helper(nums,left,right);
			quickSosrt(nums,left,mid-1);
			quickSosrt(nums,mid+1,right);
		}
	}
}
