package com.josh.interview;

import org.junit.Test;

public class Xiaomi {
	
	@Test
	public void test(){
		int[] array = {1, 3,-2, 4, -5};
		System.out.println(solution1(array));
		//System.out.println(getMin(array,1,4));
	}

	//�����һ���������飬�ҵ�����������������ִ��ĺ�sum1��sum2������|sum1-sum2|���
	public int solution1(int[] array){
		int maxABS=0;
		for(int i=0;i<array.length;i++){
			int abs1 = getMax(array,0,i-1)-getMin(array,i,array.length-1);
			int abs2 = getMax(array,i,array.length-1)-getMin(array,0,i-1);
			maxABS=Math.max(maxABS, Math.max(abs1, abs2));
		}
		return maxABS;
	}
	//��������������к�
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
	//����С���������к�
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
