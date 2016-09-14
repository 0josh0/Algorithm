package com.josh.holiday;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
 * 题意：一个二维char数组，将所有被X包围的O改成X
 * 分析：1、深搜，遍历board,若碰到O判断
 *      2、若是边界，保持O，若不是进行第三步
 *      3、判断其前和上方是不是O，若是，保持当前O，若不是，进行第四步
 *      4、向下和向右深搜，判断当前位置的O是否被X包围，若是，将当前位置的O改为X，若不是，保持O不变。
 *      这种做法是O(n2)+DFS
 *      ------------------------妈蛋，辛苦写出来竟然超时了！！！
 * 分析2：先对四个边界进行深搜，有O的标记为#，找出所有没有被包围的O都标记为# 时间复杂度O(n)+DFS
 *      然后再遍历一次board，遇到#全部修改为O，遇到O（被包围的O）修改为X    
 *      ------------------------妈蛋，因为递归调用方法次数太多，stackoverflow了！！！
 * 分析3：所以，为了防止stackoverflowError，减少方法递归调用次数用一个队列来存储所有没有被包围的点   
 *      ------------------------终于通过了！
 *      这道题优化了两次，第一次，深搜时机优化，第二次，深搜方式优化
 */
public class SurroundedRegions {
	@Test
	public void test(){
		//["XOXOXO","OXOXOX","XOXOXO","OXOXOX"]
		char[][] board = {{'X','O','X','O','X','O'},
						  {'O','X','O','X','O','X'},
						  {'X','O','X','O','X','O'},
						  {'O','X','O','X','O','X'}};
		solve(board);
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j]+"  ");
			}
			System.out.println();
		}
	}
	public void solve(char[][] board) {
		if(board.length==0) return;
		int row=board.length,col=board[0].length;
		for(int i=0;i<col;i++){
			if(board[0][i]=='O') DFS(0,i,board);
			if(board[row-1][i]=='O') DFS(row-1,i,board);
		}
		for(int i=0;i<row;i++){
			if(board[i][0]=='O') DFS(i,0,board); 
			if(board[i][col-1]=='O') DFS(i,col-1,board); 
		}
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
				if(board[i][j]=='#') board[i][j]='O';
				else if(board[i][j]=='O') board[i][j]='X';
			}
		}
	}
	public void DFS(int i,int j,char[][] board){
		int row=board.length,col=board[0].length;
		Queue<Integer> queue=new LinkedList<Integer>();
		board[i][j]='#';
		queue.add(i*col+j);
		while(!queue.isEmpty()){
			int curPos=queue.poll();
			int x=curPos/col;
			int y=curPos%col;
			if(x-1>=0&&board[x-1][y]=='O'){//向上
				queue.add((x-1)*row+y);
				board[x-1][y]='#';
			}
			if(x+1<row&&board[x+1][y]=='O'){//向下
				queue.add((x+1)*row+y);
				board[x+1][y]='#';
			}
			if(y-1>=0&&board[x][y-1]=='O'){//向左
				queue.add(x*row+(y-1));
				board[x][y-1]='#';
			}
			if(y+1<col&&board[x][y+1]=='O'){//向右
				queue.add(x*row+y+1);
				board[x][y+1]='#';
			}
		}
	}
	public void DFS2(int i,int j,char[][] board){
		if(i<0 || i>=board.length || j<0 || j>=board[0].length) 
	        return;
	    if(board[i][j] != 'O')
	        return;
	    board[i][j] = '#';
	    DFS(i-1,j,board);
	    DFS(i+1,j,board);
	    DFS(i,j-1,board);
	    DFS(i,j+1,board);
//		if(i-1>=0&&board[i-1][j]=='O'){//向上深搜
//			board[i-1][j]='#';
//			DFS(i-1,j,board);
//		}
//		if(i+1<board.length&&board[i+1][j]=='O'){//向下深搜
//			board[i+1][j]='#';
//			DFS(i+1,j,board);
//		}
//		if(j+1<board[0].length&&board[i][j+1]=='O'){//向右深搜
//			board[i][j+1]='#';
//			DFS(i,j+1,board);
//		}
//		if(j-1>=0&&board[i][j-1]=='O'){//向左深搜
//			board[i][j-1]='#';
//			DFS(i,j-1,board);
//		}
	}
    public void solve2(char[][] board) {
        for(int i=0;i<board.length;i++){
        	for(int j=0;j<board[0].length;j++){
        		if(board[i][j]=='O'){
        			if(!(i==0||j==0||i==board.length-1||j==board[0].length-1)&&!(board[i][j-1]=='O'||board[i-1][j]=='O')&&isSurrounded(i,j,board)){
        				board[i][j]='X';
        			}
        		}
        	}
        }
    }
    //向下和向右深搜
    public boolean isSurrounded(int x,int y,char[][] board){
    	boolean down=true,right=true;
    	int row=board.length,col=board[0].length;
    	if(x+1>=row) down=false;//向下深搜
    	else if(board[x+1][y]=='X') down=true;
    	else down=isSurrounded(x+1,y,board);
    	
    	if(y+1>=col) right=false;//向右深搜
    	else if(board[x][y+1]=='X') right=true;
    	else right=isSurrounded(x,y+1,board);
    	return down&&right;
    }
}
