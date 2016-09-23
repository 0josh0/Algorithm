package com.josh.holiday;

import java.util.Arrays;

import org.junit.Test;

/*
 * ���⣺��һ���������е���һ������
 * ������һ���еĽ��ͣ�һ���������е�ȫ��������˳��ģ�����ֵ��������	���磺1 2 3��1 3 2��2 1 3��2 3 1��3 1 2��3 2 1
 * ��������Ϊ�ǵ����ģ����Ծͱ��Ѱ�ҵ�ǰ�������е���һ���ϴ�����       							
 * 	   1���ӵ�ǰ�������ʼ��ǰ�ң��ҵ���һ����С������									
 * 		  ���һֱ����һ��Ԫ�ض�û�ҵ�����ʾ��ǰ����������������������ص�һ���������������С���������
 * 	            ������һ��Ԫ�ؾ������Ԫ�أ�����ʼ���ǵ�һ������������򽻻����������֣����ؽ��
 *     2����ǰ���ҹ������������������ҵ��ȵ�ǰֵ�����С���֣��������������ֵ�λ��
 *     3��������Ľ��������������г�����	
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
        if(nums[nums.length-1]>nums[nums.length-2]){//��ǰ�����ǵ�һ���������������������
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
        //i-1λ�����滻λ��
        if(i==0){//��ǰ���������һ��������������ص�һ��
        	Arrays.sort(nums);
        	return;
        }else{
        	for(int j=nums.length-1;j>i-1;j--){//�����ȵ�ǰֵ�����Сֵλ��
        		if(nums[j]>nums[i-1]){
        			int tmp = nums[j];
        			nums[j] = nums[i-1];
        			nums[i-1] = tmp;
        			break;
        		}
        	}
        	//��������
        	for(int k=i;k<i+(nums.length-i)/2;k++){
        		int tmp = nums[k];
        		nums[k] = nums[nums.length-1-(k-i)];
        		nums[nums.length-1-(k-i)] = tmp;
        	}
        }
    }
}
