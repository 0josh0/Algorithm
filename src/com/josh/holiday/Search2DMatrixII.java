package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：在一个二维数组中寻找指定value。二维数组从左到右，从上到下均有序递增
 * 分析：1 暴力解法，O(N2) -- 没有用到有序的条件，竟然通过了！！
 *     2 从右上角开始, 比较target 和 matrix[i][j]的值. 
 *     如果小于target, 则该行不可能有此数,  所以i++; 
 *     如果大于target, 则该列不可能有此数, 所以j--. 
 *     遇到边界则表明该矩阵不含target.
 */
public class Search2DMatrixII {
	@Test
	public void test(){
		//int[][] matrix = {{2,5},{2,8},{7,9},{7,11},{9,11}};
		int[][] matrix = {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
		System.out.println(searchMatrix(matrix, 11));
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		int m=matrix.length,n=matrix[0].length;
		int i=0,j=n-1;
        while(i<m&&j>=0){
        	if(matrix[i][j]==target) return true;
        	else if(matrix[i][j]<target) i++;
        	else j--;
        }
        return false;
    }
	public boolean searchMatrix1(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		if(matrix[i][j]==target) return true;
        		//if(matrix[i][j]>target) return false;
        	}
        }
        return false;
    }
}
