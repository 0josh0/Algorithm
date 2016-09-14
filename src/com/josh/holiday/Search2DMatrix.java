package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：二维数组，每行从左到右一次增大（有序），每列从上到下依次增大（有序）
 * 分析：从右上角开始遍历，如果等于target，直接返回true
 * 	                                           如果小于target，向下找，即行数+1
 * 					   如果大于target，向前找，即列数-1
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
