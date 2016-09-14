package com.josh.holiday;

import org.junit.Test;

/*
 * ����: ��������г���λ��i�ϵ�����λ������Ԫ�س˻�����Ϊ��λ�õ���Ԫ��
 * ����: һ�α�������������Ԫ�س˻�mul
 * 		���α�����λ��i�ϵ�Ԫ��mul/nums[i]
 * 		ע��0�����
 */
public class ProductofArrayExceptSelf {
	@Test
	public void test(){
		int[] nums = {1,0};
		int[] res = new int[nums.length];
		res = productExceptSelf(nums);
		for(int i=0;i<nums.length;i++){
			System.out.println(res[i]);
		}
	}
	public int[] productExceptSelf(int[] nums) {
		int mul=1,count = 0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]!=0){
				mul*=nums[i];
			}else{
				count++;
			}
		}
		if(count==nums.length) return nums;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==0){
				if(count==1)nums[i] = mul;
				else nums[i]=0;
			}else{
				if(count==0)nums[i]=mul/nums[i];
				else nums[i]=0;
			}
		}
		return nums;
    }
}
