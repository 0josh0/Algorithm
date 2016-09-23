package com.josh.holiday;

import java.util.HashMap;

import org.junit.Test;

/*
 * 题意：在数组中寻找众数，即出现次数大于n/2的数
 * 分析：1、遍历一次，用map存每个数出现的次数，寻找众数.O(n) O(n)
 *      2、抵消的思想。根据条件：出现次数多于总数一半，用不同的数字与之抵消，最后剩下的就是众数。O(n) O(1)
 */
public class MajorityElement {
	@Test
	public void test(){
		int[] nums={1,2,3,4,2,2,2,2};
		System.out.println(majorityElement2(nums));
	}
	public int majorityElement(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(!map.containsKey(nums[i])){//如果第一次直接加入，计数1
				map.put(nums[i], 1);
			}else{//map中已经有这个数了，改变计数+1
				int count = map.get(nums[i]);
				map.put(nums[i],++count);
			}
			if(map.get(nums[i])>(nums.length)/2) return nums[i];
		}
		//遍历map，寻找众数
//		for(Integer value:map.values()){
//			if(value>(nums.length)/2) return value;
//		}
		return 0; 
    }
	public int majorityElement2(int[] nums) {
		int majority = nums[0],count=1;
		for(int i=1;i<nums.length;i++){
			if(majority==nums[i]) count++;//若重复，+1
			else if(count==0){//若抵消完毕，初始化新数字
				majority = nums[i];
				count++;
			}else count--;//抵消重复出现的数字
		}
		return majority;
	}
}
