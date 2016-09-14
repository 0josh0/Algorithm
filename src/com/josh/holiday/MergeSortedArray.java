package com.josh.holiday;

import org.junit.Test;

/*
 * ����: �鲢�����������顣nums1���㹻�Ŀռ���Է���nums2��Ԫ��
 * ����: 
 */
public class MergeSortedArray {
	@Test
	public void test(){
		int[] nums1= {1,2,3,0,0,0,0,0};
		int[] nums2={2,5,6};
		merge(nums1, 3, nums2, 3);
		for(int i=0;i<6;i++){
			System.out.println(nums1[i]);
		}
	}
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i=0,j=0;
        while(i<m&&j<n){
        	if(nums1[i]<nums2[j]) i++;
        	else{
        		for(int k=m;k>i;k--){
        			nums1[k] = nums1[k-1];
        		}
        		nums1[i] = nums2[j];
        		j++;
        		m++;
        	}
        }
        while(j<n){
        	nums1[i] = nums2[j];
    		j++;
    		i++;
        }
    }
}
