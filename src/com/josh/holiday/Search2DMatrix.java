package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺��ά���飬ÿ�д�����һ���������򣩣�ÿ�д��ϵ���������������
 * �����������Ͻǿ�ʼ�������������target��ֱ�ӷ���true
 * 	                                           ���С��target�������ң�������+1
 * 					   �������target����ǰ�ң�������-1
 */
public class Search2DMatrix {
	@Test
	public void test(){
		
	}
	public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length-1;
        while(row<matrix.length&&col>=0){
        	if(matrix[row][col]==target) return true;
        	else if(matrix[row][col]<target) row++;
        	else col--;
        }
		return false;
    }
}
