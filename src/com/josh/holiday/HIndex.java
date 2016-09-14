package com.josh.holiday;
/*
 * 题意：h指数是指一名科研人员至多有h篇论文至少被引用了h次。给定一个无序数组，代表一个科研人员发表论文被引用的次数，求其H指数
 * 分析：1、排序
 */
public class HIndex {
	public int hIndex(int[] citations) {
		quickSort(citations,0,citations.length-1);
		int i=0;
		for(;i<citations.length;i++){
			if(citations[i]<(i+1)) return i;
		}
		return i;
    }
	//快排
	public void quickSort(int[] nums,int left,int right){
		if(left<right){
			int mid = helper(nums,left,right);
			quickSort(nums,left,mid-1);
			quickSort(nums,mid+1,right);
		}
	}
	public int helper(int[] nums,int left,int right){
		int provit = nums[left];
		while(left<right){
			while(left<right&&nums[right]<=provit) right--;
			nums[left] = nums[right];
			while(left<right&&nums[left]>=provit) left++;
			nums[right] = nums[left];
		}
		nums[left] = provit;
		return left;
	}
}
