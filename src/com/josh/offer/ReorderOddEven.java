package com.josh.offer;

import org.junit.Test;

/*
 * ��������Ԫ�أ�������ǰż���ں�
 * �ⷨ��˫ָ��
 */
public class ReorderOddEven {

	@Test
	public void test(){
		int[] array = {2,1,4,5,8,3};
		oddEven(array);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
	public void oddEven(int[] array){
		int left=0,right=array.length-1;
		while(left<right){
			if(isOdd(array[left])&&!isOdd(array[right])){//left odd right even
				left++;
				right--;
			}else if(isOdd(array[left])&&isOdd(array[right])){//left odd right odd
				left++;
			}else if(!isOdd(array[left])&&isOdd(array[right])){//left even right odd
				int tmp = array[left];
				array[left] = array[right];
				array[right] = tmp;
				left++;
				right--;
			}else{
				right--;
			}
		}
	}
	//�ж�һ�����Ƿ�������
	public boolean isOdd(int value){
		if((value&1)==0)return false;
		return true;
	}
}
