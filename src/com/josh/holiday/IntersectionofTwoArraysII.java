package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * ���⣺�ҳ����������غϵ����֣��ظ��ļ�¼n��
 * ������1������Ȼ��Ƚ�
 *      2����һ���������set�У�Ȼ���ٱ�����һ������
 */
public class IntersectionofTwoArraysII {
	@Test
	public void test(){
		int[] nums1={3,4,2,2,5};
		int[] nums2={1,7,2,2,3};
		//quickSort(nums,0,4);
		intersect(nums1,nums2);
//		for(int i=0;i<nums.length;i++){
//			System.out.println(nums[i]);
//		}
	}
    public int[] intersect(int[] nums1, int[] nums2) {
       List<Integer> list = new ArrayList<Integer>();
       quickSort(nums1,0,nums1.length-1);
       quickSort(nums2,0,nums2.length-1);
       int i=0,j=0;
       while(i<nums1.length&&j<nums2.length){
    	   if(i<nums1.length&&j<nums2.length&&nums1[i]<nums2[j])i++;
    	   if(i<nums1.length&&j<nums2.length&&nums1[i]>nums2[j])j++;
    	   if(i<nums1.length&&j<nums2.length&&nums1[i]==nums2[j]){
    		   list.add(nums1[i]);
    		   i++;
    		   j++;
    	   }
       }
       int len = list.size();
       int[] res = new int[len];
       for(int c=0;c<len;c++){
    	   res[c]=list.get(c);
    	   System.out.println(res[c]);
       }
       return res;
    }
    
	//quick sort
	public void quickSort(int[] nums,int left,int right){
		if(left<right){
			int mid = part(nums,left,right);
			quickSort(nums,left,mid-1);
			quickSort(nums,mid+1,right);
		}
	}
	public int part(int[] nums,int left,int right){
		int tmp=nums[left];
		while(left<right){
			while(left<right&&tmp<=nums[right]) right--;
			nums[left]=nums[right];
			while(left<right&&nums[left]<=tmp) left++;
			nums[right]=nums[left];	
		}
		nums[left] = tmp;
		return left;
	}
}
