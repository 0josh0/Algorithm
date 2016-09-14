package com.josh.holiday;

import java.util.SortedSet;
import java.util.TreeSet;

/*
 * 题意：判断数组中是否存在| nums[i] - nums[j] | <= t 并且 | i - j | <= k
 * 分析1：确定一个k长度的窗口，求窗口内是否有满足的条件，时间复杂度O（n*K）
 *      ---------------------我琢磨会超时，果然吧，超时了！！
 * 分析2：估计得用啥数据结构，空间换时间嘛,，果然，要用到TreeSet
 * 	           用到TreeSet的sunSet函数，返回set中指定范围的元素
 *      注意越界的问题，以及k、t的合法性判断
 * 
 * 
 */
public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(k<1||t<0||nums.length<2||nums==null) return false;
		SortedSet<Long> windows = new TreeSet<Long>();//定义一个长度不大于k的滑动窗口
		for(int i=0;i<nums.length;i++){
			//求当前数字nums[i]在窗口内是否有满足条件(即在nums[i]-t, nums[i]+t+1范围内的数)的数字
			SortedSet<Long> set = windows.subSet((long)(nums[i]-t), (long)nums[i]+t+1);
			if(!set.isEmpty()) return true;//如果存在直接返回true
			if(i>=k){//判断窗口长度是否超过k,如果超过，删除窗口中数组先加入的元素
				windows.remove(nums[i-k]);
			}
			windows.add((long)nums[i]);
		}
		return false;
	}
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
       for(int i=0;i<nums.length;i++){
    	   for(int j=i+1;j<nums.length&&j<=i+k;j++){
    		   if(Math.abs(nums[i]-nums[j])<=t) return true;
    	   }
       }
       return false;
    }
}
