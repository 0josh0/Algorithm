package com.josh.holiday;

import org.junit.Test;

/*
 * ����: ɾ�������������Ԫ����ȵ�Ԫ�أ����������鳤��
 * ����: �ò��ظ���Ԫ�ظ���ԭ����
 */
public class RemoveElements {
	@Test
	public void test(){
		int[] nums = {1,2,3,4,5};
		int val = 2;
		System.out.println(removeElement(nums, val));
	}
    public int removeElement(int[] nums, int val) {
    	int count = 0;
        for(int i=0,j=0;i<nums.length;i++){
        	if(nums[i]!=val){
        		nums[j++] = nums[i];
        	}else{
        		count++;
        	}
        }
//        for(int i=0;i<nums.length-count;i++){
//        	System.out.println(nums[i]);
//        }
    	return nums.length-count;
    }
}
