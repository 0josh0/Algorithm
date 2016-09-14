package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：补丁数组，给定一个数组nums和一个整数n，数组nums中能构成1-n所有数字所需要添加几个数字，返回。
 * 分析：定义一个当前数组范围能表示的最大连续数列上界max，表示可以表示范围：[0,max)，max=1，然后遍历数组nums，
 *      当nums[i]<=max时，更新max=max+nums[i]
 *      当nums[i]>max时，说明当前数组无法表示max(也可能有比max大的数字)，所以需要向nums中添加max
 *                      同时更新max=max+max
 *      当max>n时，返回添加数字数
 */
public class PatchingArray {
	@Test
	public void test(){
		int [] nums = {1,2,31,33};
		System.out.println(minPatches( nums, 2147483647));
	}
	public int minPatches(int[] nums, int n) {
       int count = 0,i=0;
       long max=1;//必须用long型，否则越界，死循环，超时！大坑啊！！！！！！！！！
       while(max<=n){
    	   if(i<nums.length&&max>=nums[i]){
    		   max+=nums[i++];
    	   }else{
    		   max<<=1;
			   count++;
    	   }
       }
        return count;
    }
}
