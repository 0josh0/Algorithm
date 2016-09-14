package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺�������飬����һ������nums��һ������n������nums���ܹ���1-n������������Ҫ��Ӽ������֣����ء�
 * ����������һ����ǰ���鷶Χ�ܱ�ʾ��������������Ͻ�max����ʾ���Ա�ʾ��Χ��[0,max)��max=1��Ȼ���������nums��
 *      ��nums[i]<=maxʱ������max=max+nums[i]
 *      ��nums[i]>maxʱ��˵����ǰ�����޷���ʾmax(Ҳ�����б�max�������)��������Ҫ��nums�����max
 *                      ͬʱ����max=max+max
 *      ��max>nʱ���������������
 */
public class PatchingArray {
	@Test
	public void test(){
		int [] nums = {1,2,31,33};
		System.out.println(minPatches( nums, 2147483647));
	}
	public int minPatches(int[] nums, int n) {
       int count = 0,i=0;
       long max=1;//������long�ͣ�����Խ�磬��ѭ������ʱ����Ӱ�������������������
       while(max<=n){
    	   if(i<nums.length&&max>=nums[i]){
    		   max+=nums[i++];
    	   }else{
    		   max<<=1;
			   count++;
    	   }
       }
        return count;
    }
}
