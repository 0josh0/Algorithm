package com.josh.holiday;
/*
 * 题意：寻找数组中的峰值点，即比相邻的数值都大的点，可能存在多个峰值点，返回一个即可
 * 分析：二分法查找
 * 		按序查找
 */
public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		if(nums.length==1) return nums[0];
		if(nums.length==2) return nums[0]>nums[1]?nums[0]:nums[1];
		boolean flag = false;
		for(int i=1;i<nums.length-1;i++){
			if(nums[i]>nums[i-1]&&nums[i]>nums[i+1]){
				return i;
			}
		}
		if(nums.length!=0&&flag==false) return nums[0]>nums[nums.length-1]?0:nums.length-1;
		return 0;
    }
	public int helper(int[] nums,int left,int right){
		if(left<right){
			int mid=(left+right)/2;
			if((mid>0&&nums[mid-1]<nums[mid])&&(mid<nums.length-1&&nums[mid+1]<nums[mid])){
				return mid;
			}
			//if(mid==0)
		}
		return 0;
	}
}
