package com.josh.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * /用集合存储所有子集合/
 * 把int数组转化成string字符串
 * 然后查找string的任意长度的子串，放入set中
 */


public class SubsetsII {

	@Test
	public void test(){
		int[] nums = {4,1,0};
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res = subsetsWithDup(nums);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	list.add(new ArrayList<Integer>());
    	if(nums.length == 0 || nums == null) return list;
    	Arrays.sort(nums);
    	for(int i=0;i<nums.length;i++){
    		int size=list.size();
    		for(int j=0;j<size;j++){
    			List<Integer> item = new ArrayList<Integer>(list.get(j));
    			item.add(nums[i]);
    			if(!list.contains(item)) list.add(item);
    		}
    	}
		return list;
    }
}
