package com.josh.task10;

import org.junit.Test;

/*
 * ����: ��һ��������ÿһ��Ԫ�ض��������Σ�ֻ��һ������һ�Σ��ҵ��Ǹ�����һ�ε�Ԫ�ء�Ҫ��ʱ�临�Ӷ�O(N)���ռ临�Ӷ�O(1)
 * ����: ��һ��32��С�������¼ÿһλ�ϳ���1�Ĵ��������ͳ��ÿһλ��1�Ĵ�������3ȡģ��Ϊ1��λ�����Ǹ�����һ�ε���������
 */
public class SingleNumberII {
	@Test
	public void test(){
		int [] nums = {-2,-2,1,1,-3,1,-3,-3,-4,-2};
		System.out.println(singleNumber(nums));
	}
    public int singleNumber(int[] nums) {
    	int[] num=new int[32];
    	int singleNum=0;
    	for(int i=0;i<32;i++){//ͳ�Ƶ�iλ�ϵ�1�ĸ���
    		for(int j=0;j<nums.length;j++){
    			if(((nums[j]>>i) & 1)==1) num[i]++;
    		}
    		//num[i] = num[i]%3;
    		//singleNum +=num[i]*Math.pow(2, i);
    		singleNum |= ((num[i] % 3) << i);
    	}
		return singleNum;
        
    }
}
