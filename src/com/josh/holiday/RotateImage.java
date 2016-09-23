package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：顺时针旋转二维数组，即行变列
 * 分析：1 暴力解法，申请一个同等大小的数组
 */
public class RotateImage {
	@Test
	public void test(){
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.println(matrix[i][j]);
			}
		}
	}
	public void rotate(int[][] matrix) {
        int[][] tmp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		tmp[i][j]=matrix[i][j];
        	}
        }
        for(int i=0;i<tmp.length;i++){
        	for(int j=0;j<tmp[0].length;j++){
        		matrix[j][matrix.length-1-i] = tmp[i][j]; 
        	}
        }
    }
}
