package com.josh.interview;

import org.junit.Test;

public class Xiaomi {
	
	@Test
	public void test(){
		int[] array = {1, 3,-2, 4, -5};
		System.out.println(solution1(array));
		//System.out.println(getMin(array,1,4));
	}

	//求最大一个无序数组，找到它的两个最大连续字串的和sum1，sum2，满足|sum1-sum2|最大
	public int solution1(int[] array){
		int maxABS=0;
		for(int i=0;i<array.length;i++){
			int abs1 = getMax(array,0,i-1)-getMin(array,i,array.length-1);
			int abs2 = getMax(array,i,array.length-1)-getMin(array,0,i-1);
			maxABS=Math.max(maxABS, Math.max(abs1, abs2));
		}
		return maxABS;
	}
	//求最大连续子序列和
	public int getMax(int[] array,int start,int end){
		int max=array[start];
		int dp = array[start];
		for(int i=start+1;i<=end;i++){
			if(dp<0){
				dp=array[i];
			}else{
				dp+=array[i];
			}
			max=Math.max(max, dp);
		}
		return max;
	}
	//求最小连续子序列和
	public int getMin(int[] array,int start,int end){
		int min = array[start];
		int dp = array[start];
		for(int i=start+1;i<=end;i++){
			if(dp>0){
				dp=array[i];
			}else{
				dp+=array[i];
			}
			min =Math.min(min, dp);
		}
		return min;
		
	}
}
