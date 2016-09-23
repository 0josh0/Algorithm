package com.josh.holiday;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

/*
 * ����: �����е�ÿһ��Ԫ�ض��������Σ�ֻ��һ������һ�Σ��ҳ��������һ�ε�Ԫ��
 * ����: 1 ��map����ÿ��Ԫ�س��ֵĴ�����Ȼ�����map�ҵ�ֻ����һ�ε�Ԫ��
 * 	    2  �����������ڲ���
 *      3 ����λ��������򣬣�������λ��ͬΪ0��ͬΪ1������ͬ���������һ����0��������������������Ǹ�����һ�ε�Ԫ��
 */
public class SingleNumber {
	@Test
	public void test(){
		int[] array = {2,2,1};
		quickSort(array,0,array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	public int singleNumber(int[] nums) {
		int res = 0;
		for(int i=0;i<nums.length;i++){
			res^=nums[i];
		}
		return res;
	}
	public int singleNumber2(int[] nums) {
		if(nums.length==1) return nums[0];
		quickSort(nums,0,nums.length-1);
		for(int i=1;i<nums.length;){
			if(nums[i]!=nums[i-1]) return nums[i-1];
			i=i+2;
		}
		return nums[nums.length-1];
    }
	public void quickSort(int[] nums,int left,int right){
		if(left<right){
			int mid = part(nums,left,right);
			quickSort(nums,left,mid-1);
			quickSort(nums,mid+1,right);
		}
	}
	public int part(int[] nums,int left,int right){
		int center = nums[left];
		while(left<right){
			while(left<right&&nums[right]>=center) right--;//���Ҳ࿪ʼѰ�ұ�centerС����
			nums[left]=nums[right];//��С��center��Ԫ�أ��ƶ���leftλ��
			while(left<right&&nums[left]<=center)
				left++;
			nums[right] = nums[left];
		}
		nums[left] = center;//���м�Ԫ��д����ȷλ��
		return left;
	}
	public int singleNumber1(int[] nums) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], 1);
			}else{
				map.put(nums[i], 2);
			}
		}
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()){
			int key = it.next();
			if(map.get(key)==1){
				return key;
			}
		}
		return 0;
    }
}
