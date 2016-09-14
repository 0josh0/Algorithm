package com.josh.holiday;

import org.junit.Test;

/*
 * 题意: 删除数组中与给定元素相等的元素，返回新数组长度
 * 分析: 用不重复的元素覆盖原数组
 */
public class RemoveElements {
	@Test
	public void test(){
		int[] nums = {1,2,3,4,5};
		int val = 2;
		System.out.println(removeElement(nums, val));
	}
    public int removeElement(int[] nums, int val) {
    	int count = 0;
        for(int i=0,j=0;i<nums.length;i++){
        	if(nums[i]!=val){
        		nums[j++] = nums[i];
        	}else{
        		count++;
        	}
        }
//        for(int i=0;i<nums.length-count;i++){
//        	System.out.println(nums[i]);
//        }
    	return nums.length-count;
    }
}
