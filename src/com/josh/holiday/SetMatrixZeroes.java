package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：二维数组矩阵，出现0的位置，行列都置为0
 * 分析：用String记录行列为0的记录，标记行列长度
 */
public class SetMatrixZeroes {
	@Test
	public void test(){
		int[][] matrix = {{0,9,3,3,8,2,1,4,1,7,1,2,7},
				{6,0,2,3,3,8,5,1,9,3,2,0,7},
				{8,4,6,0,2,6,1,5,1,0,7,2,6},
				{1,1,9,3,9,6,5,1,1,1,1,7,2},
				{0,0,6,3,9,4,7,5,6,0,3,7,7},
				{5,9,7,9,6,8,1,5,3,0,3,8,3},
				{5,1,7,4,3,9,4,9,2,6,5,0,3}};
		setZeroes(matrix);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	public void setZeroes(int[][] matrix) {
        StringBuilder row = new StringBuilder();
        StringBuilder rowIndex = new StringBuilder();
        StringBuilder col = new StringBuilder();
        StringBuilder colIndex = new StringBuilder();
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		if(matrix[i][j]==0){
        			row.append(i);
        			rowIndex.append((i+"").length());
        			col.append(j);
        			colIndex.append((j+"").length());
        		}
        	}
        }
        for(int i=0,j=0;i<rowIndex.length();i++){
        	//将此行全部置为0
        	int len = Integer.valueOf(rowIndex.substring(i,i+1).toString());
        	int r=Integer.valueOf(row.subSequence(j, j+len).toString());
        	for(int c=0;c<matrix[0].length;c++){
        		matrix[r][c] = 0;
        	}
        	j=j+len;
        }
        for(int i=0,j=0;i<colIndex.length();i++){
        	//将此列全部置为0
        	int len = Integer.valueOf(colIndex.substring(i,i+1).toString());
        	int c=Integer.valueOf(col.subSequence(j, j+len).toString());
        	for(int r=0;r<matrix.length;r++){
        		matrix[r][c] = 0;
        	}
        	j=j+len;
        }
    }
}
