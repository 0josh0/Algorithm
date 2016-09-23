package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：在I的基础上，如果数组是升序的，如何优化算法
 * 分析：
 */
public class HIndexII {
	@Test
	public void test(){
		int[] nums = {0};
		System.out.println(hIndex(nums));
	}
	public int hIndex(int[] citations) {
		int len=citations.length;
        for(int i=len-1;i>=0;i--){
        	if(citations[i]<len-i) return len-i-1;
        }
        return len;
    }
//	public int hIndex2(int[] citations) {
//		if(citations.length==1){
//			return citations[0]==0?0:1;
//		}
//        return helper(citations,0,citations.length-1);
//    }
//	public int helper(int[] citations,int left,int right){
//		if(left<=right){
//			int mid=(left+right)/2;
//			if(citations[mid]==citations.length-mid) return citations.length-mid;
//			if(citations[mid]>citations.length-mid){
//				if(mid-1>0&&citations[mid-1]<=citations.length-mid+1)
//					return citations.length-mid+1;
//				helper(citations,left,mid-1);
//			}else if(citations[mid]<citations.length-mid){
//				helper(citations,mid+1,right);
//			}
//		}
//		return 0;
//	}
}
