package com.josh.holiday;

import org.junit.Test;

/*
 * 这道题是有名的康威生命游戏,这是一种细胞自动机,
 * 每一个位置有两种状态，1为活细胞，0为死细胞，对于每个位置都满足如下的条件：
	1. 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡
	2. 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活
	3. 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡
	4. 如果死细胞周围正好有三个活细胞，则该位置死细胞复活
	
	分析：用不同的数字标记状态
	0 : 上一轮是0，这一轮过后还是0
	1 : 上一轮是1，这一轮过后还是1
	2 : 上一轮是1，这一轮过后变为0
	3 : 上一轮是0，这一轮过后变为1
 */
public class GameofLife {
	@Test
	public void test(){
		int[][] board = {{1,1},{1,0}};
		gameOfLife(board);
		for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		System.out.println(board[i][j]);
        	}
        }
	}
	public void gameOfLife(int[][] board) {
		int row = board.length;//行数
		int col = board[0].length;//列数
        for(int i=0;i<row;i++){
        	for(int j=0;j<col;j++){
        		int alive = 0;//记录当前细胞周围活细胞数
        		if(i>0&&j>0){//判断左上角
        			if(board[i-1][j-1]==1 || board[i-1][j-1]==2) alive++;
        		}
        		if(i>0){//判断正上方
        			if(board[i-1][j]==1 || board[i-1][j]==2) alive++;
        		}
        		if(i>0&&j<col-1){//判断右上角
        			if(board[i-1][j+1]==1 || board[i-1][j+1]==2) alive++;
        		}
        		if(j<col-1){//判断右侧
        			if(board[i][j+1]==1 || board[i][j+1]==2) alive++;
        		}
        		if(i<row-1&&j<col-1){//判断右下角
        			if(board[i+1][j+1]==1 || board[i+1][j+1]==2) alive++;
        		}
        		if(i<row-1){//判断正下方
        			if(board[i+1][j]==1 || board[i+1][j]==2) alive++;
        		}
        		if(i<row-1&&j>0){//判断左下角
        			if(board[i+1][j-1]==1 || board[i+1][j-1]==2) alive++;
        		}
        		if(j>0){//判断左侧
        			if(board[i][j-1]==1 || board[i][j-1]==2) alive++;
        		}
        		if(board[i][j]==0){//原来是死细胞
        			if(alive==3) board[i][j] = 3;//死细胞复活
        		}else{//原来是活细胞
        			if(!(alive==2||alive==3)) board[i][j] = 2;//活细胞死
        		}
        	}
        }
        for(int i=0;i<row;i++){
        	for(int j=0;j<col;j++){
        		board[i][j] = board[i][j]%2;
        	}
        }
    }
}
