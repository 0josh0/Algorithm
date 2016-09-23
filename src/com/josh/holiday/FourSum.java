package com.josh.holiday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
 * 题意：给定一个数组和一个整数target，求所有四个元素等于target的情况，要求四个元素要递增排序
 * 分析：1、先排序，回溯,---果然，超时了！！
 *      2、借助twoSum和threeSum
 * 
 */
public class FourSum {
	@Test
	public void test(){
		int[] nums = {1,0,-1,0,-2,2};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = fourSum(nums,0);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums.length<4) return res;
    	Arrays.sort(nums);
    	for(int i=nums.length-1;i>=3;i--){
    		if(i<nums.length-1&&nums[i]==nums[i+1]) continue;//去重
			List<List<Integer>> twoRes = threeSum(nums,i-1,target-nums[i]);
			for(int j=0;j<twoRes.size();j++){
				twoRes.get(j).add(nums[i]);
			}
			res.addAll(twoRes);
    	}
    	return res;
    }
	public List<List<Integer>> threeSum(int[] nums,int end,int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i=end;i>=2;i--){
			if(i<end&&nums[i]==nums[i+1]) continue;//去重
			List<List<Integer>> twoRes = twoSum(nums,i-1,target-nums[i]);
			for(int j=0;j<twoRes.size();j++){
				twoRes.get(j).add(nums[i]);
			}
			res.addAll(twoRes);
		}
		return res;
	}
	public List<List<Integer>> twoSum(int[] nums,int right,int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int start=0,end=right;
		while(start<end){
			if(nums[start]+nums[end]==target){
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums[start]);
				list.add(nums[end]);
				res.add(list);
				start++;
				end--;
				while(start<end&&nums[start]==nums[start-1]) start++;
				while(start<end&&nums[end]==nums[end+1]) end--;//去重
			}else if(nums[start]+nums[end]>target){
				end--;
			}else{
				start++;
			}
		}
		return res;
	}
	
    public List<List<Integer>> fourSum1(int[] nums, int target) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(nums.length<4) return res;
    	Arrays.sort(nums);
        helper(nums,0,target,res,new ArrayList<Integer>());
    	return res;
    }
    public void helper(int[] nums,int start,int target,List<List<Integer>> res,ArrayList<Integer> list){
    	if(target<0) return;
    	else if(target==0&&list.size()==4)
    		res.add(new ArrayList<Integer>(list));
    	else{
    		for(int i=start;i<nums.length;i++){
    			list.add(nums[i]);
    			helper(nums,i+1,target-nums[i],res,list);
    			list.remove(list.size()-1);
    		}
    	}
    }
}
