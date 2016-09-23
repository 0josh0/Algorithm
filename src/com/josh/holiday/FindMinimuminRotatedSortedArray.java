package com.josh.holiday;
/*
 * ���⣺һ������������ĳ�����ת��Ѱ�ҵ���ת֮�����Сֵ
 * ������1����ͷ�����������ȵ�ǰֵС�ľ���
 *     2�����ֲ���,�ҵ��м�λ�ã����м�λ�õ����ֱ�startλ�����ִ���֮ǰ����֮��������Сֵ��֮��
 *     					        ���м�λ�õ����ֱ�startλ������С����֮ǰ����֮��������Сֵ��֮ǰ
 */
public class FindMinimuminRotatedSortedArray {
	public int findMin(int[] nums) {
		if(nums.length==0) return 0;
       // if(nums.length==1) return nums[1];
        return helper(nums,0,nums.length-1);
    }
	public int helper(int[] nums,int start,int end){
		if(end-start>1){
			int mid=(start+end)/2;
			if(nums[end]>nums[start]) return nums[start];
			if(nums[mid]<nums[mid-1]) return nums[mid];
			else if(nums[start]<=nums[mid]) return helper(nums,mid+1,end);
			else return helper(nums,start,mid-1);
			
		}else{
			if(start==end) return nums[start];
			else{
				if(nums[start]<nums[end]) return nums[start];
				else return nums[end];
			}
		}
	}
	public int findMin1(int[] nums) {
		if(nums.length==0) return 0;
        for(int i=1;i<nums.length;i++){
        	if(nums[i]<nums[i-1]) return nums[i];
        }
        return nums[0];
    }
}
