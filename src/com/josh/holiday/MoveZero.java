package com.josh.holiday;
/*
 * ���⣺�������е�0ȫ���ƶ�������ĩβ�����ı�����������Ԫ�ص����λ�ã�����ʹ�ö���Ŀռ�
 * �����������ҵ���һ��Ϊ0��Ԫ�أ���������ֱ����һ��Ԫ�ز�Ϊ0���ƶ�������������Ԫ�أ���ȫ������Ϊ0��������0���0λ�õ�Ԫ��
 */

import org.junit.Test;

public class MoveZero {
    public void moveZeroes(int[] nums) {
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==0){
        		int end=i+1;
        		while(end<nums.length && nums[end]==0){
        			end++;
        		}
        		if(end==nums.length) return;
        		nums[i] = nums[end];
        		nums[end] = 0;
        	}
        }
    }
    public void moveZeroes2(int[] nums) {
    	int pos=0;
    	//������������з���Ԫ��һ������ԭ������
        for(int i=0;i<nums.length;i++){
        	if(nums[i]!=0){
        		nums[pos]=nums[i];
        		pos++;
        	}
        }
        //�������������Ԫ����0���
        while(pos<nums.length){
        	nums[pos]=0;
        	pos++;
        }
    }
    @Test
    public void test(){
    	int[] nums = {0,1,0,3,12};
    	moveZeroes2(nums);
    	for(int i=0;i<nums.length;i++){
    		System.out.println(nums[i]);
    	}
    }
}
