package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：删除有序数组中重复元素，使每个元素都只出现一次，要求不能申请额外的数组空间，在原数组上操作
 * 分析：标记重复出现的元素，覆盖原数组
 */
public class RemoveDuplicatesSortedArray {
	@Test
	public void test(){
		int[] nums = {2,2,2,4,5};
		//int val = 2;
		System.out.println("新数组大小："+removeDuplicates(nums));
	}
    public int removeDuplicates(int[] nums) {
    	int temp = 0,count = 0;
    	for(int i=1,j=0;i<nums.length;i++){
    		temp = nums[i-1];
    		if(nums[i]!=temp){
    			nums[++j] = nums[i];
    		}else{
    			count++;
    		}
    	}
//    	for(int i=0;i<nums.length-count;i++){
//        	System.out.println(nums[i]);
//        }
        return nums.length-count; 
    }
}
