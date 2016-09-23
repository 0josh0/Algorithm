package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * 题意：三角形的数组，求从top到bottom的最小路径，当前元素值等于其上一层两个相邻元素较小的一个加上当前值
 * 分析：DP
 */
public class Triangle {
	@Test
	public void test(){
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(-1);
		triangle.add(list);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(2);
		list2.add(3);
		triangle.add(list2);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(1);
		list3.add(-1);
		list3.add(-3);
		triangle.add(list3);
		
		System.out.println(minimumTotal(triangle));
	}
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null) return 0;
        List<Integer> preRow = new ArrayList<Integer>();
        List<Integer> curRow = new ArrayList<Integer>();
        preRow.add(triangle.get(0).get(0));
        curRow.add(triangle.get(0).get(0));
        for(int i=1;i<triangle.size();i++){
        	curRow.clear();
        	//第i+1行第一个元素
        	curRow.add(preRow.get(0)+triangle.get(i).get(0));
        	//第i+1行其他元素
        	for(int j=1;j<i;j++){
        		curRow.add(Math.min(preRow.get(j-1), preRow.get(j))+triangle.get(i).get(j));
        	}
        	//第i+1行最后一个元素
        	curRow.add(preRow.get(preRow.size()-1)+triangle.get(i).get(i));
        	preRow.clear();
        	preRow.addAll(curRow);
        }
        
        int minSum=curRow.get(0);
        for(int i=1;i<curRow.size();i++){
        	if(curRow.get(i)<minSum) minSum=curRow.get(i);
        }
		return minSum;
    }
}
