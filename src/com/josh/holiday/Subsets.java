package com.josh.holiday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/*
 * 题意：给定一个整数，求该整数的所有子集合，子集合有序，递增
 * 分析：求全部组合数,公式：Cnk = C(n-1)(k-1)+C(n-1)(k)
 */
public class Subsets {

	@Test
	public void test(){
		int[] nums = {4,1,0};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = subsets(nums);
//		res = combine(nums.length,5,nums);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	public List<List<Integer>> subsets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		res.add(list);
		int n = nums.length;
		for(int i=1;i<=nums.length;i++){
			List<List<Integer>> subRes = new ArrayList<List<Integer>>();
			subRes = combine(n,i,nums);
			res.addAll(subRes);
		}
		return res;
    }
	public List<List<Integer>> combine(int n,int k,int[] nums){
		if(n==k||k==0){
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<k;i++){
				list.add(nums[i]);
			}
			List<List<Integer>> res = new ArrayList<List<Integer>>();
			res.add(list);
			return res;
		}
		List<List<Integer>> leftRes = new ArrayList<List<Integer>>();
		leftRes = combine(n-1,k-1,nums);
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
		rightRes = combine(n-1,k,nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i=0;i<leftRes.size();i++){
			res.add(leftRes.get(i));
		}
		for(int i=0;i<rightRes.size();i++){
			res.add(rightRes.get(i));
		}
		return res;
	}
}
