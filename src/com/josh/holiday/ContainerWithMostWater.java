package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺�����±߱�ʾx��λ�ã�Ԫ�ر�ʾ�߶ȣ���Χ���������ľ���
 * ������1 ��ٷ�O(n2) ---��ʱ
 *      2 ��������ָ��ָ���������β��i��j����������������߽磬
 *      ��height[i]<height[j]ʱ������Ķ̰���i�������i++�Ի�ýϴ����
 *      ��֮������Ķ̰���j���j--���Ի�ýϴ���� O(n)
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
	//��������ָ��
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
