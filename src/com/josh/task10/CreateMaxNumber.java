package com.josh.task10;

import java.util.Stack;

import org.junit.Test;

/*
 * 题意: 从长度为n的数组中选出长度为k的最大整数
 * 分析: 未完。。。。。。。。
 */
public class CreateMaxNumber {

	@Test
	public void test(){
		int[] nums = {9,1,2,5,8,3};
		int k=5;
		maxNum(nums, k);
	}
	public String maxNum(int[] nums,int k){
		StringBuilder max=new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(nums[0]);
		for(int i=1;i<nums.length;i++){
			if(!stack.isEmpty() && stack.peek()<nums[i]&&nums.length-i+1>=k){
				stack.pop();
			}
			if(stack.size()<k) stack.push(nums[i]);
		}
		while(!stack.isEmpty()){
			max.insert(0, stack.pop());
		}
		return max.toString();
	}
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] max={};
		
		return max;
	}
}
