package com.josh.holiday;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * ���⣺�ж�һ���������Ƿ����ظ����֡����������ظ���������true�����򷵻�false
 * ������1����ͳ����������.�˷���-��ʱ��O(n2)
 *      2���ռ任ʱ�䣬��һ��list���ΰ�nums�е����ִ洢������ÿ�δ洢֮ǰ�ж��Ƿ��ظ�.�˷���-��ʱ��O(n)����Ϊ�õ�contains������ÿ���ж϶�Ҫ��������
 *      3���ռ任ʱ�䣬��set�������set.add��ȥԪ�أ���ʾ���ظ��������ܣ����ظ�������true��O(n)
 */
public class ContainsDuplicate {
	@Test
	public void test(){
		int[] nums = {1,2,3,4,5,6};
		System.out.println(containsDuplicate(nums));
	}
    public boolean containsDuplicate1(int[] nums) {
        if(nums.length==0 || nums.length==1) return false;
    	for(int i=0;i<nums.length;i++){
    		for(int j=i+1;j<nums.length;j++){
    			if(nums[i]==nums[j]) return true;
    		}
    	}
        return false; 
    }
    public boolean containsDuplicate2(int[] nums) {
    	ArrayList<Integer> list = new ArrayList<>();
    	for(int i=0;i<nums.length;i++){
    		if(!list.contains(nums[i])) 
    			list.add(nums[i]);
    		else 
    			return true;
    	}
        return false;
    }
    public boolean containsDuplicate3(int[] nums) {
    	Set<Integer> list = new HashSet<>();
    	for(int i=0;i<nums.length;i++){
    		if(!list.contains(nums[i])) 
    			list.add(nums[i]);
    		else 
    			return true;
    	}
        return false;
    }
    public boolean containsDuplicate(int[] nums) {
    	if(nums.length==0) return false;
        Set<Integer> set = new HashSet<>();
    	for(int i=0;i<nums.length;i++){
    		if(!set.add(nums[i])) 
    			return true;
    	}
        return false;
    }
}
