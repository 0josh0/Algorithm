package com.josh.offer;

import org.junit.Test;

/*
 * 顺时针循环打印矩阵
 * 
 */
public class SnakeMatrix {
	
	@Test
	public void test(){
		int[][] matrix = {{0,1,2,3},{7,6,5,4}};
		printMatrix(matrix,0,0);
	}

	public void printMatrix(int[][] matrix,int row,int col){
		
		if(row>matrix.length-row-1||col>matrix[0].length-col-1) return;
		//打印——>:上侧-从左到右
		for(int j=col;j<matrix[0].length-col;j++){
			System.out.print(matrix[row][j]+" ");
			//System.out.println();
		}
		//打印|:右侧-从上到下
		if(row<matrix.length-row-1&&col<matrix[0].length-col-1){
			for(int i=row+1;i<matrix.length-row;i++){
				System.out.print(matrix[i][matrix[0].length-col-1]+" ");
				//System.out.println();
			}
		}
		
		//打印<——:下侧-从右到左
		if(row<matrix.length-row-1&&col<matrix[0].length-col-1){
			for(int j=matrix[0].length-col-2;j>=col;j--){
				System.out.print(matrix[matrix.length-row-1][j]+" ");
				//System.out.println();
			}
		}
		
		//打印|:左侧-从下到上
		if(row<matrix.length-row-1&&col<matrix[0].length-col-1){
			for(int i=matrix.length-row-2;i>row;i--){
				System.out.print(matrix[i][col]+" ");
				//System.out.println();
			}
		}
		printMatrix(matrix,row+1,col+1);
	}
}
