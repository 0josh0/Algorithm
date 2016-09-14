package com.josh.holiday;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

/*
 * 题意：返回数组中等于target的两个数的索引
 * 分析：1、O(n2)
 * 		2、hashtable 注：数组中没有重复的数字。
 * 		3、双指针逼近
 */
public class TwoSum {
	@Test
	public void test(){
		int[] nums = {3,2,4};
		twoSum(nums,6);
	}
	public int[] twoSum(int[] nums, int target) {
		if(nums.length<2) return null;
		int[] res = new int[2];
		Arrays.sort(nums);
		int start=0,end=nums.length-1;
		while(start<end){
			if(nums[start]+nums[end]==target){
				res[0]=nums[start];
				res[1]=nums[end];
				return res;
			}else if(nums[start]+nums[end]>target){
				end--;
			}else{
				start++;
			}
		}
		return null;
	}
    public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
        	if(map.containsKey(target-nums[i])){
        		res[0]=i;
        		res[1]=map.get(target-nums[i]);
        		return res;
        	}
        	map.put(nums[i],i);
        }
        return null;
    }
}
