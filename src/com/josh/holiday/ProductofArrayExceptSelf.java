package com.josh.holiday;

import org.junit.Test;

/*
 * 题意: 输出数组中除了位置i上的其他位置所有元素乘机，作为该位置的新元素
 * 分析: 一次遍历，计算所有元素乘机mul
 * 		二次遍历，位置i上的元素mul/nums[i]
 * 		注意0的情况
 */
public class ProductofArrayExceptSelf {
	@Test
	public void test(){
		int[] nums = {1,0};
		int[] res = new int[nums.length];
		res = productExceptSelf(nums);
		for(int i=0;i<nums.length;i++){
			System.out.println(res[i]);
		}
	}
	public int[] productExceptSelf(int[] nums) {
		int mul=1,count = 0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=0){
				mul*=nums[i];
			}else{
				count++;
			}
		}
		if(count==nums.length) return nums;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0){
				if(count==1)nums[i] = mul;
				else nums[i]=0;
			}else{
				if(count==0)nums[i]=mul/nums[i];
				else nums[i]=0;
			}
		}
		return nums;
    }
}
