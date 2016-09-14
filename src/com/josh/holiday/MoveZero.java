package com.josh.holiday;
/*
 * 题意：把数组中的0全部移动到数组末尾，不改变数组中其他元素的相对位置，不能使用额外的空间
 * 分析：遍历找到第一个为0的元素，继续遍历直到下一个元素不为0，移动这个区间的所有元素（即全部连续为0），交换0与非0位置的元素
 */

import org.junit.Test;

public class MoveZero {
    public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==0){
        		int end=i+1;
        		while(end<nums.length && nums[end]==0){
        			end++;
        		}
        		if(end==nums.length) return;
        		nums[i] = nums[end];
        		nums[end] = 0;
        	}
        }
    }
    public void moveZeroes2(int[] nums) {
    	int pos=0;
    	//遍历数组把所有非零元素一次填入原数组中
        for(int i=0;i<nums.length;i++){
        	if(nums[i]!=0){
        		nums[pos]=nums[i];
        		pos++;
        	}
        }
        //其他后面的所有元素用0填充
        while(pos<nums.length){
        	nums[pos]=0;
        	pos++;
        }
    }
    @Test
    public void test(){
    	int[] nums = {0,1,0,3,12};
    	moveZeroes2(nums);
    	for(int i=0;i<nums.length;i++){
    		System.out.println(nums[i]);
    	}
    }
}
