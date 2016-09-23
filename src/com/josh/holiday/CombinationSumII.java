package com.josh.holiday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

/*
 * 题意：给定一个数组和一个target整数，求数组中所有等于target的组合，要求组成target的组合不能有重复的
 * 分析：同I的思路，去重
 */
public class CombinationSumII {
	@Test
	public void test(){
		int[] candidates = {1,1};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = combinationSum2(candidates, 1);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates==null ||candidates.length==0) return res;
		Arrays.sort(candidates);
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		helper(candidates,0,target,new ArrayList<Integer>(),set);
		res.addAll(set);
		return res;
	}
	public void helper(int[] candidates,int start,int target,ArrayList<Integer> list,Set<List<Integer>> res){
		if(target<0) return;
		if(target==0){
			res.add(new ArrayList<Integer>(list));
		}else{
			for(int i=start;i<candidates.length;i++){
				list.add(candidates[i]);
				helper(candidates,i+1,target-candidates[i],list,res);
				list.remove(list.size()-1);
			}
		}
	}
}
