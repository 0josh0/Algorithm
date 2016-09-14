package com.josh.holiday;

import java.util.*;

import org.junit.Test;

/*
 * 题意：输入行数，输出Pascal三角     
 *     [1],
      [1,1],
     [1,2,1],
    [1,3,3,1],
   [1,4,6,4,1]
 * 分析：
 */
public class PascalTriangle {
	@Test
	public void test(){
		generate(3);
	}
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	if(numRows==0) return list;
    	List<Integer> sList = new ArrayList<Integer>();
    	sList.add(1);
    	list.add(sList);
    	for(int i=1;i<numRows;i++){
    		List<Integer> cList = new ArrayList<Integer>();
    		cList.add(1);
    		for(int j=1;j<i;j++){
    			cList.add(list.get(i-1).get(j-1)+list.get(i-1).get(j));
    		}
    		cList.add(1);
    		list.add(cList);
    	}
		return list;
    }
}
