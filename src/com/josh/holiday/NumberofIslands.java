package com.josh.holiday;


import org.junit.Test;

/*
 * 题意：1代表陆地，0代表水，求被水围住的孤岛个数
 * 分析：深搜，遍历二维数组，遇到1开始深搜，分别向1的上下左右进行递归，并将遇到的1置为0；
 * 
 */
public class NumberofIslands {
	@Test
	public void test(){
		char[][] grid = {{'1'}};
//		char[][] grid = {{'1','1','0','0','0'},
//				{'1','1','0','0','0'},
//				{'0','0','1','0','0'},
//				{'0','0','0','1','1'},
//				{'0','0','0','1','1'}};
		 System.out.println(numIslands(grid));
	}
	public int numIslands(char[][] grid) {
		int count = 0;
        if(grid.length==0) return 0;
        for(int i=0;i<grid.length;i++){
        	for(int j=0;j<grid[0].length;j++){
        		if(grid[i][j]=='1'){
        			count++;
        			helper(grid,i,j);
        		}
        	}
        }
		return count;
    }
	public void helper(char[][] grid,int i,int j){
		if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]=='0') return;//到达边界，返回
		grid[i][j] = '0';
		helper(grid,i+1,j);
		helper(grid,i-1,j);
		helper(grid,i,j+1);
		helper(grid,i,j-1);
	}
}
