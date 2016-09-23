package com.josh.holiday;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

/*
 * 题意: 数组中的每一个元素都出现两次，只有一个出现一次，找出这个出现一次的元素
 * 分析: 1 用map储存每个元素出现的次数，然后遍历map找到只出现一次的元素
 * 	    2  可以先排序，在查找
 *      3 利用位操作，异或，（二进制位相同为0不同为1），相同两个数异或一定是0，所以最后的异或结果就是那个出现一次的元素
 */
public class SingleNumber {
	@Test
	public void test(){
		int[] array = {2,2,1};
		quickSort(array,0,array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	public int singleNumber(int[] nums) {
		int res = 0;
		for(int i=0;i<nums.length;i++){
			res^=nums[i];
		}
		return res;
	}
	public int singleNumber2(int[] nums) {
		if(nums.length==1) return nums[0];
		quickSort(nums,0,nums.length-1);
		for(int i=1;i<nums.length;){
			if(nums[i]!=nums[i-1]) return nums[i-1];
			i=i+2;
		}
		return nums[nums.length-1];
    }
	public void quickSort(int[] nums,int left,int right){
		if(left<right){
			int mid = part(nums,left,right);
			quickSort(nums,left,mid-1);
			quickSort(nums,mid+1,right);
		}
	}
	public int part(int[] nums,int left,int right){
		int center = nums[left];
		while(left<right){
			while(left<right&&nums[right]>=center) right--;//从右侧开始寻找比center小的数
			nums[left]=nums[right];//把小于center的元素，移动到left位置
			while(left<right&&nums[left]<=center)
				left++;
			nums[right] = nums[left];
		}
		nums[left] = center;//把中间元素写入正确位置
		return left;
	}
	public int singleNumber1(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], 1);
			}else{
				map.put(nums[i], 2);
			}
		}
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()){
			int key = it.next();
			if(map.get(key)==1){
				return key;
			}
		}
		return 0;
    }
}
