package com.josh.holiday;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * 题意：判断一个数组里是否有重复数字。若里面有重复的数返回true，否则返回false
 * 分析：1、传统做法，遍历.此方法-超时。O(n2)
 *      2、空间换时间，用一个list依次把nums中的数字存储起来，每次存储之前判断是否重复.此方法-超时。O(n)，因为用到contains方法，每次判断都要遍历数组
 *      3、空间换时间，用set，如果能set.add进去元素，表示不重复，若不能，有重复，返回true。O(n)
 */
public class ContainsDuplicate {
	@Test
	public void test(){
		int[] nums = {1,2,3,4,5,6};
		System.out.println(containsDuplicate(nums));
	}
    public boolean containsDuplicate1(int[] nums) {
        if(nums.length==0 || nums.length==1) return false;
    	for(int i=0;i<nums.length;i++){
    		for(int j=i+1;j<nums.length;j++){
    			if(nums[i]==nums[j]) return true;
    		}
    	}
        return false; 
    }
    public boolean containsDuplicate2(int[] nums) {
    	ArrayList<Integer> list = new ArrayList<>();
    	for(int i=0;i<nums.length;i++){
    		if(!list.contains(nums[i])) 
    			list.add(nums[i]);
    		else 
    			return true;
    	}
        return false;
    }
    public boolean containsDuplicate3(int[] nums) {
    	Set<Integer> list = new HashSet<>();
    	for(int i=0;i<nums.length;i++){
    		if(!list.contains(nums[i])) 
    			list.add(nums[i]);
    		else 
    			return true;
    	}
        return false;
    }
    public boolean containsDuplicate(int[] nums) {
    	if(nums.length==0) return false;
        Set<Integer> set = new HashSet<>();
    	for(int i=0;i<nums.length;i++){
    		if(!set.add(nums[i])) 
    			return true;
    	}
        return false;
    }
}
