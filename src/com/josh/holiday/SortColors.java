package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺0.1.2�ֱ����졢�ס�������ͬ����ɫ��һ���ұ�֤�������˳��
 * ����: ����
 */
public class SortColors {
	@Test
	public void test(){
		int[] nums={4,2,4,1,7,9};
        quick(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
        	System.out.println(nums[i]);
        }
	}
	public void sortColors(int[] nums) {
        quick(nums,0,nums.length-1);
    }
	private int pre(int[] nums,int left,int right){	
		int pro=nums[left];
		while(left<right){
			while(right>left&&nums[right]>=pro) right--;
			nums[left]=nums[right];
			while(right>left&&nums[left]<=pro)
				left++;
			nums[right] = nums[left];
		}
		nums[left] = pro;
		return left;
	}
	private void quick(int[] nums,int left,int right){
		if(left<right){
			int pro = pre(nums,left,right);
			quick(nums,left,pro);
			quick(nums,pro+1,right);
		}
	}
}
