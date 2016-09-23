package com.josh.holiday;

import java.util.Arrays;

import org.junit.Test;

/*
 * 题意：求一个数字序列的下一个排列
 * 关于下一排列的解释：一个数字序列的全排列是有顺序的，按“值”递增。	比如：1 2 3、1 3 2、2 1 3、2 3 1、3 1 2、3 2 1
 * 分析：因为是递增的，所以就变成寻找当前数字序列的下一个较大序列       							
 * 	   1）从当前序列最后开始向前找，找到第一个减小的数字									
 * 		  如果一直到第一个元素都没找到，表示当前序列是最后的排列情况，返回第一种排列情况，即从小到大的序列
 * 	            如果最后一个元素就是最大元素，即开始就是第一种排列情况，则交换后两个数字，返回结果
 *     2）从前面找过的有序数字序列中找到比当前值大的最小数字，并交换两个数字的位置
 *     3）将后面的降序数列重新排列成升序	
 * 																					
 */
public class NextPermutation {
	@Test
	public void test(){
		int[] nums = {5,4,7,5,3,2};
		nextPermutation(nums);
	}
    public void nextPermutation(int[] nums) {
        if(nums.length==1||nums.length==0) return;
        if(nums[nums.length-1]>nums[nums.length-2]){//当前序列是第一种排列情况，交换后两个
        	int tmp = nums[nums.length-1];
        	nums[nums.length-1] = nums[nums.length-2];
        	nums[nums.length-2] = tmp;
        	return;
        }
        int i=nums.length-1;
        for(;i>0;i--){
        	if(nums[i]>nums[i-1]){
        		break;
        	}
        }
        //i-1位置是替换位置
        if(i==0){//当前序列是最后一种排列情况，返回第一种
        	Arrays.sort(nums);
        	return;
        }else{
        	for(int j=nums.length-1;j>i-1;j--){//交换比当前值大的最小值位置
        		if(nums[j]>nums[i-1]){
        			int tmp = nums[j];
        			nums[j] = nums[i-1];
        			nums[i-1] = tmp;
        			break;
        		}
        	}
        	//升序排列
        	for(int k=i;k<i+(nums.length-i)/2;k++){
        		int tmp = nums[k];
        		nums[k] = nums[nums.length-1-(k-i)];
        		nums[nums.length-1-(k-i)] = tmp;
        	}
        }
    }
}
