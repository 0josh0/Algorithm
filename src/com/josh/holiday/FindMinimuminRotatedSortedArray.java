package com.josh.holiday;
/*
 * 题意：一个有序数组在某点出旋转，寻找到旋转之后的最小值
 * 分析：1、从头遍历，遇到比当前值小的就是
 *     2、二分查找,找到中间位置，若中间位置的数字比start位置数字大，则之前有序，之后无序，最小值在之后
 *     					        若中间位置的数字比start位置数字小，则之前无序，之后有序，最小值在之前
 */
public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] nums) {
		if(nums.length==0) return 0;
       // if(nums.length==1) return nums[1];
        return helper(nums,0,nums.length-1);
    }
	public int helper(int[] nums,int start,int end){
		if(end-start>1){
			int mid=(start+end)/2;
			if(nums[end]>nums[start]) return nums[start];
			if(nums[mid]<nums[mid-1]) return nums[mid];
			else if(nums[start]<=nums[mid]) return helper(nums,mid+1,end);
			else return helper(nums,start,mid-1);
			
		}else{
			if(start==end) return nums[start];
			else{
				if(nums[start]<nums[end]) return nums[start];
				else return nums[end];
			}
		}
	}
	public int findMin1(int[] nums) {
		if(nums.length==0) return 0;
        for(int i=1;i<nums.length;i++){
        	if(nums[i]<nums[i-1]) return nums[i];
        }
        return nums[0];
    }
}
