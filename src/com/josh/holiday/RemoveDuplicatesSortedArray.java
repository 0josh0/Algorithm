package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺ɾ�������������ظ�Ԫ�أ�ʹÿ��Ԫ�ض�ֻ����һ�Σ�Ҫ����������������ռ䣬��ԭ�����ϲ���
 * ����������ظ����ֵ�Ԫ�أ�����ԭ����
 */
public class RemoveDuplicatesSortedArray {
	@Test
	public void test(){
		int[] nums = {2,2,2,4,5};
		//int val = 2;
		System.out.println("�������С��"+removeDuplicates(nums));
	}
    public int removeDuplicates(int[] nums) {
    	int temp = 0,count = 0;
    	for(int i=1,j=0;i<nums.length;i++){
    		temp = nums[i-1];
    		if(nums[i]!=temp){
    			nums[++j] = nums[i];
    		}else{
    			count++;
    		}
    	}
//    	for(int i=0;i<nums.length-count;i++){
//        	System.out.println(nums[i]);
//        }
        return nums.length-count; 
    }
}
