package com.josh.holiday;
/*
 * ���⣺hָ����ָһ��������Ա������hƪ�������ٱ�������h�Ρ�����һ���������飬����һ��������Ա�������ı����õĴ���������Hָ��
 * ������1������
 */
public class HIndex {
	public int hIndex(int[] citations) {
		quickSort(citations,0,citations.length-1);
		int i=0;
		for(;i<citations.length;i++){
			if(citations[i]<(i+1)) return i;
		}
		return i;
    }
	//����
	public void quickSort(int[] nums,int left,int right){
		if(left<right){
			int mid = helper(nums,left,right);
			quickSort(nums,left,mid-1);
			quickSort(nums,mid+1,right);
		}
	}
	public int helper(int[] nums,int left,int right){
		int provit = nums[left];
		while(left<right){
			while(left<right&&nums[right]<=provit) right--;
			nums[left] = nums[right];
			while(left<right&&nums[left]>=provit) left++;
			nums[right] = nums[left];
		}
		nums[left] = provit;
		return left;
	}
}
