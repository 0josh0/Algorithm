package com.josh.holiday;

import java.util.HashMap;

import org.junit.Test;

/*
 * ���⣺��������Ѱ�������������ִ�������n/2����
 * ������1������һ�Σ���map��ÿ�������ֵĴ�����Ѱ������.O(n) O(n)
 *      2��������˼�롣�������������ִ�����������һ�룬�ò�ͬ��������֮���������ʣ�µľ���������O(n) O(1)
 */
public class MajorityElement {
	@Test
	public void test(){
		int[] nums={1,2,3,4,2,2,2,2};
		System.out.println(majorityElement2(nums));
	}
	public int majorityElement(int[] nums) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<nums.length;i++){
			if(!map.containsKey(nums[i])){//�����һ��ֱ�Ӽ��룬����1
				map.put(nums[i], 1);
			}else{//map���Ѿ���������ˣ��ı����+1
				int count = map.get(nums[i]);
				map.put(nums[i],++count);
			}
			if(map.get(nums[i])>(nums.length)/2) return nums[i];
		}
		//����map��Ѱ������
//		for(Integer value:map.values()){
//			if(value>(nums.length)/2) return value;
//		}
		return 0; 
    }
	public int majorityElement2(int[] nums) {
		int majority = nums[0],count=1;
		for(int i=1;i<nums.length;i++){
			if(majority==nums[i]) count++;//���ظ���+1
			else if(count==0){//��������ϣ���ʼ��������
				majority = nums[i];
				count++;
			}else count--;//�����ظ����ֵ�����
		}
		return majority;
	}
}
