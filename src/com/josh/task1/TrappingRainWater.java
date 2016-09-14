package com.josh.task1;

import org.junit.Test;
/**
 * 求降水量，转化为面积求解
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
		
		int water=0;//定义降水总量
		int stone=0;//数组和
		int max=0;//数组中当前最大值
		int preSum=0;//正向遍历面积
		int lastSum=0;//反向遍历面积
		int sum = 0;//矩形总面积
		
		if(height.length==0)
		{
			return water;
		}else{
			//正向遍历，求正向面积
			for(int i=0;i<height.length;i++)
			{
				stone = stone + height[i];//计算数组之和
				if(height[i]>max)//更新当前数组最大值
				{
					max = height[i];
				}
				preSum = preSum + max;
			}
			sum  = max * height.length;//矩形面积
			max = 0;
			//反向遍历，求反向面积
			for(int j=height.length-1;j>=0;j--)
			{
				if(height[j]>max)
				{
					max = height[j];
				}
				lastSum = lastSum + max;
			}
//			System.out.println("正向面积："+preSum);
//			System.out.println("反向面积："+lastSum);
//			System.out.println("矩形面积："+sum);
//			System.out.println("数组和："+stone);
			//计算降水量
			water = preSum + lastSum - sum - stone;	
			System.out.println("降水量："+water);
		}
		return water;
    }
}
