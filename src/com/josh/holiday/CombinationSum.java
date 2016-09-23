package com.josh.holiday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
 * 题意：给一个正整数集合和一个target整数，求集合中的和等于target的组合
 * 分析：1、求set的全组合数，然后依次遍历验证和是否为target -- 超时
 * 	    2、回溯 - 递归
 * 
 */
public class CombinationSum {
	@Test
	public void test(){
		int[] nums= {48,22,49,24,26,47,33,40,37,39,31,46,36,43,45,34,28,20,29,25,41,32,23};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//res = comNum(nums.length,2,nums);
		res = combinationSum(nums, 69);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates.length==0||candidates==null) return res;
		Arrays.sort(candidates);
		helper(candidates,0,target,new ArrayList<Integer>(),res);
        return res;
    }
	//回溯，依次相加，
	//相等将list加入集合，同时list最后一个删除，继续向后加
	//小于0，list最后一个删除
	public void helper(int[] candidates,int start,int target,ArrayList<Integer>list,List<List<Integer>> res){
		if(target<0) return;
		if(target==0){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=start;i<candidates.length;i++){
//			if(i>0 && candidates[i]==candidates[i-1])  
//	            continue;
			list.add(candidates[i]);
			helper(candidates,i,target-candidates[i],list,res);
			list.remove(list.size()-1);
		}
	}
	
	//求数组的全部组合数
	public List<List<Integer>> comNum(int n,int k,int[] nums){
		if(k==n||k==0){
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<k;i++){
				list.add(nums[i]);
			}
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			res.add(list);
			return res;
		}
		List<List<Integer>> leftRes = new ArrayList<List<Integer>>();
		leftRes = comNum(n-1,k-1,nums);
		if(leftRes.size()==0){
			List<Integer> list = new ArrayList<Integer>();
			list.add(nums[n-1]);
			leftRes.add(list);
		}else{
			for(int i=0;i<leftRes.size();i++){
				leftRes.get(i).add(nums[n-1]);
			}
		}
		List<List<Integer>> rightRes = new ArrayList<List<Integer>>();
		rightRes = comNum(n-1,k,nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.addAll(leftRes);
		res.addAll(rightRes);
		return res;
	}
}
