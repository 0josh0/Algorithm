package com.josh.task1;

import org.junit.Test;
/**
 * ��ˮ����ת��Ϊ������
 * @author Josh
 *
 */
public class TrappingRainWater {
   
	@Test
	public void test(){
	
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		//int[] height = {4,2,3};
		trap(height);
	}
	//water = pre + last - sum - stone;
	public int trap(int[] height) {
		
		int water=0;//���彵ˮ����
		int stone=0;//�����
		int max=0;//�����е�ǰ���ֵ
		int preSum=0;//����������
		int lastSum=0;//����������
		int sum = 0;//���������
		
		if(height.length==0)
		{
			return water;
		}else{
			//������������������
			for(int i=0;i<height.length;i++)
			{
				stone = stone + height[i];//��������֮��
				if(height[i]>max)//���µ�ǰ�������ֵ
				{
					max = height[i];
				}
				preSum = preSum + max;
			}
			sum  = max * height.length;//�������
			max = 0;
			//����������������
			for(int j=height.length-1;j>=0;j--)
			{
				if(height[j]>max)
				{
					max = height[j];
				}
				lastSum = lastSum + max;
			}
//			System.out.println("���������"+preSum);
//			System.out.println("���������"+lastSum);
//			System.out.println("���������"+sum);
//			System.out.println("����ͣ�"+stone);
			//���㽵ˮ��
			water = preSum + lastSum - sum - stone;	
			System.out.println("��ˮ����"+water);
		}
		return water;
    }
}
