package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：数组下边表示x轴位置，元素表示高度，求围成最大面积的矩形
 * 分析：1 穷举法O(n2) ---超时
 *      2 保持两个指针指向数组的首尾，i和j，计算面积的两个边界，
 *      当height[i]<height[j]时，面积的短板在i这里，所以i++以获得较大面积
 *      反之，面积的短板在j这里，j--，以获得较大面积 O(n)
 *      
 */
public class ContainerWithMostWater {
	@Test
	public void test(){
		int[] height = {1,2,4,3};
		System.out.println(maxArea(height));
	}
	public int maxArea1(int[] height) {
		int max = 0;
		if(height.length==0||height.length==1) return max;
		for(int i=0;i<height.length;i++){
			for(int j=i;j<height.length;j++){
				if((j-i)*Math.min(height[i], height[j])>max){
					max=(j-i)*Math.min(height[i], height[j]);
				}
			}
		}
		return max;
    }
	//保持两个指针
	public int maxArea(int[] height) {
		int max = 0;
		if(height.length==0||height.length==1) return max;
		int i=0,j=height.length-1;
		while(i<j){
			max=Math.max(max, (j-i)*Math.min(height[i], height[j]));
			if(height[i]<height[j]) i++;
			else j--;
		}
		return max;
    }
	
	
}
