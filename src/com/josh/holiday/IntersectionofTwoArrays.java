package com.josh.holiday;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

/*
 * 题意：找出两个数组重合的数字，重复的只记录一次
 * 分析：1、排序然后比较
 *      2、将一个数组放入set中，然后再遍历另一个数组
 */
public class IntersectionofTwoArrays {
	@Test
	public void test(){
		int[] nums1={1,2};
		int[] nums2={2,1};
		int[] res =intersection(nums1,nums2);
		for(int i=0;i<res.length;i++){
			System.out.println(res[i]);
		}
	}
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        if(nums1.length<nums2.length){
        	for(int i=0;i<nums1.length;i++){
        		set.add(nums1[i]);
        	}
        	for(int j=0;j<nums2.length;j++){
        		if(set.contains(nums2[j])){
        			res.add(nums2[j]);
        		}
        	}
        }else{
        	for(int i=0;i<nums2.length;i++){
        		set.add(nums2[i]);
        	}
        	for(int j=0;j<nums1.length;j++){
        		if(set.contains(nums1[j])){
        			res.add(nums1[j]);
        		}
        	}
        }
        int[] array= new int[res.size()];
        Iterator<Integer> it = res.iterator();
        int i=0;
        while(it.hasNext()){
        	array[i++]=it.next();
        }
    	return array;
    }
}
