package com.josh.holiday;

import java.util.HashMap;

import org.junit.Test;

/*
 * 题意: 寻找数组中是否有唯一一对重复的数字，且这两个数字的下标之差不能超过k
 * 分析: 用hashMap存储每个数字和下标，当重复出现时，设置一个计数器和判断k的标识，最后用count和lessK判断是否满足k和唯一性两个条件
 */
public class ContainsDuplicateII {
	@Test
	public void test(){
		int[] nums={1,0,1};
		System.out.println(containsNearbyDuplicate(nums, 1));
	}
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	HashMap<Integer,Integer> map = new HashMap<>();
    	int count = 0;
    	boolean lessK = false;
    	for(int i=0;i<nums.length;i++){
    		if(map.containsKey(nums[i])){
    			int index = map.get(nums[i]);
    			if(i-index<=k){
    				lessK = true;
    				count++;
    			}
    		}
    		map.put(nums[i], i);
    	}
    	if(count==1 && lessK==true) return true;
    	return false;  
    }
}
