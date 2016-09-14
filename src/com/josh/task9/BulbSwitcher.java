package com.josh.task9;

import org.junit.Test;

/*
 * 题意: 给定数字n，表示有n盏灯，初始化全部关闭，第一轮全部打开，
 *      第二轮，关闭所有2的倍数的位置的灯，第三轮，关闭所有3的倍数的位置的灯（若已经off，改变为on）
 *      最后一轮，只改变最后一盏灯的状态。
 *      求，最后一轮后有多少盏灯on？
 * 分析: 1 改变一次状态计数器加1，最后统计.时间复杂度O(n2) -- 笨蛋！！！用膊了盖想都知道肯定超时！！
 *      2 求每个位置对应数字的分解因子 -- 还是超时啊，还得优化，真特么费劲！！
 *      3 通过实验发现，最终亮灯的位置都是平方数的位置，e.g.1-4-9……所以此题转化为求n以内平方数的个数
 */

public class BulbSwitcher {
	@Test
	public void test(){
		System.out.println(bulbSwitch(5));
	}
	public int bulbSwitch(int n) {
		return (int)Math.sqrt(n);
	}
	public int bulbSwitch2(int n) {
		if(n==0) return 0;
		int[] bulb = new int[n];
		for(int i=1;i<n;i++){
			bulb[i]++;
			for(int j=2;j<=(i+1)/2;j++){
				if((i+1)%j==0) bulb[i]++;
			}
		}
		int count=0;
    	for(int k=0;k<n;k++){
    		if(bulb[k]%2==0) count++;
    	}
    	return count;
	}
    public int bulbSwitch1(int n) {
    	if(n==0) return 0;
        int[] bulb = new int[n];
    	for(int i=1;i<n;i++){
    		int m=i+1;
        	for(int j=i;j<n;j++){
        		if((j+1)%m==0)bulb[j]++;
        	}
        }
    	int count=0;
    	for(int k=0;k<n;k++){
    		if(bulb[k]%2==0) count++;
    	}
    	return count;
    }
}
