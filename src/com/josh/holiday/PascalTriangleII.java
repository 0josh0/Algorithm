package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * 题意: 只输出一行。e.g. 给定n=3，输出{1,3,3,1}
 * 分析: 因为当前行元素由前一行产生，所以用两个list分别保存当前行和上一行元素。
 */
public class PascalTriangleII {
	@Test
	public void test(){
		List<Integer> list = new ArrayList<Integer>();
		list = getRow(4);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> preList = new ArrayList<Integer>();
        if(rowIndex<0) return list;
        list.add(1);
        for(int i=1;i<=rowIndex;i++){
        	//把上一行元素存储到preList中
        	for(int k=0;k<list.size();k++){
        		preList.add(list.get(k));
        	}
        	list.clear();//清除list
        	list.add(1);
        	for(int j=1;j<i;j++){
        		list.add(preList.get(j-1)+preList.get(j));
        	}
        	preList.clear();
        	list.add(1);
        }
		return list;
    }
}
