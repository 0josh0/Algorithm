package com.josh.task12;

import org.junit.Test;

/*
 * ���⣺������������Ҫ������λ�ô�������
 * �������������ڰ�Ҫ�����
 * 
 */
public class WiggleSortII {
	@Test
	public void test(){
		int[] nums={1,1,2,1,2,2,1};
		//quick(nums,0,6);
		wiggleSort(nums);
		for(int i=0;i<nums.length;i++){
			System.out.println(nums[i]);
		}
	}
	
	public void wiggleSort(int[] nums) {
//		if(nums.length<2) return;
//		Arrays.sort(nums);
//		int[] tmp =new int[nums.length];
//		for(int i=0;i<nums.length;i++){
//			//����˼·
//		}
		
	}
	
	public void wiggleSort1(int[] nums) {
		if(nums.length<2) return;
        int small=0,big=1,count=0;
        while(small<nums.length&&big<nums.length){
        	if(nums[small]>nums[big]){
        		int tmp = nums[small];
        		nums[small] = nums[big];
        		nums[big] = tmp;
        	}
        	if(count%2==0) small=small+2;
        	else big = big+2;
        	count++;
        }
    }
}
