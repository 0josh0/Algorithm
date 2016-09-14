package com.josh.holiday;
/*
 * 题意: 一个有序数组，给定一个target value，返回其在数组中的index，如果不存在，返回她应该插入的位置的index
 * 分析：遍历
 */
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		int i=0;
		for(;i<nums.length;i++){
			if(nums[i]>=target) return i;
		}
		return i;
        
    }
}
