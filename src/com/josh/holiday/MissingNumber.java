package com.josh.holiday;
/*
 * ����: Ѱ�Ҷ�ʧ������ Given nums = [0, 1, 3] return 2
 * ����: ��һ�α������ҵ����ֵ�����ۼ����
 * 		�������ֵ������������֮�ͣ�����ȣ���ʧ�����ֵ+1��������ȣ����Ϊ��ʧ����
 * 		ע��0�����
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
    	if(nums.length==0) return 0;
    	int sum=0,max=nums[0];
    	boolean hasZero = false;
    	for(int i=0;i<nums.length;i++){
    		if(nums[i]==0) hasZero=true;
    		if(nums[i]>max) max = nums[i];
    		sum+=nums[i];
    	}
    	int res = max*(max+1)/2 - sum;
    	if(res==0){
    		if(hasZero) return max+1;
    		else return 0;
    	}else{
    		return res;
    	}
        
    }
}
