package com.josh.holiday;
/*
 * 题意: 寻找丢失的数字 Given nums = [0, 1, 3] return 2
 * 分析: 第一次遍历，找到最大值，并累计求和
 * 		利用最大值，求连续整数之和，若相等，丢失的最大值+1，若不相等，做差即为丢失的数
 * 		注意0的情况
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
    	if(nums.length==0) return 0;
    	int sum=0,max=nums[0];
    	boolean hasZero = false;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==0) hasZero=true;
    		if(nums[i]>max) max = nums[i];
    		sum+=nums[i];
    	}
    	int res = max*(max+1)/2 - sum;
    	if(res==0){
    		if(hasZero) return max+1;
    		else return 0;
    	}else{
    		return res;
    	}
        
    }
}
