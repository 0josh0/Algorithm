package com.josh.task4;

import org.junit.Test;

public class SearchForRange {
	@Test
	public void test(){
		int[] nums = {1, 1, 2};
		int[] res = searchRange(nums, 1);
		System.out.println(res[0]+"  "+res[1]);
	}
    public int[] searchRange(int[] nums, int target) {
    	int[] res = {-1,-1};
    	int i=0,j=nums.length-1,starting=-1,ending=-1;
    	while(i<=j){
    		int mid=(i+j)/2;
    		if(nums[mid] == target){//search starting and ending
    			starting = mid-1;
    			ending =mid+1;
    			while(starting >= 0 && nums[starting] == target){
    				starting--;
    			}
    			while(ending < nums.length && nums[ending] == target){
    				ending++;
    			}
    			res[0] = starting+1;
    			res[1] = ending-1;
    			return res;
    		}else if(nums[mid] > target){
    			j = mid-1;
    		}else if(nums[mid] < target){
    			i = mid+1;
    		}
    	}
		return res;
    }
}
