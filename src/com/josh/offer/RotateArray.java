package com.josh.offer;

import org.junit.Test;

/*
 * 求旋转数组中的最小
 * 解法：双指针或者二分查找
 * 
 */
public class RotateArray {

	@Test
	public void test(){
		int[] array={3,4,5,1,2};
		int min = findMin(array);
		System.out.println(min);
	}
	public int findMin(int[] array){
		int index=0;
		int left=0,right=array.length-1;
		while(array[left]>=array[right]){
			if(right-left==1){
				index = right;
				break;
			}
			index = (left+right)/2;
			if(array[left]<=array[index]){
				left=index;
			}else{
				right=index;
			}
		}
		return array[index];
	}
}
