package com.josh.holiday;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
 * ���⣺һ����άchar���飬�����б�X��Χ��O�ĳ�X
 * ������1�����ѣ�����board,������O�ж�
 *      2�����Ǳ߽磬����O�������ǽ��е�����
 *      3���ж���ǰ���Ϸ��ǲ���O�����ǣ����ֵ�ǰO�������ǣ����е��Ĳ�
 *      4�����º��������ѣ��жϵ�ǰλ�õ�O�Ƿ�X��Χ�����ǣ�����ǰλ�õ�O��ΪX�������ǣ�����O���䡣
 *      ����������O(n2)+DFS
 *      ------------------------�走������д������Ȼ��ʱ�ˣ�����
 * ����2���ȶ��ĸ��߽�������ѣ���O�ı��Ϊ#���ҳ�����û�б���Χ��O�����Ϊ# ʱ�临�Ӷ�O(n)+DFS
 *      Ȼ���ٱ���һ��board������#ȫ���޸�ΪO������O������Χ��O���޸�ΪX    
 *      ------------------------�走����Ϊ�ݹ���÷�������̫�࣬stackoverflow�ˣ�����
 * ����3�����ԣ�Ϊ�˷�ֹstackoverflowError�����ٷ����ݹ���ô�����һ���������洢����û�б���Χ�ĵ�   
 *      ------------------------����ͨ���ˣ�
 *      ������Ż������Σ���һ�Σ�����ʱ���Ż����ڶ��Σ����ѷ�ʽ�Ż�
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
			if(x-1>=0&&board[x-1][y]=='O'){//����
				queue.add((x-1)*row+y);
				board[x-1][y]='#';
			}
			if(x+1<row&&board[x+1][y]=='O'){//����
				queue.add((x+1)*row+y);
				board[x+1][y]='#';
			}
			if(y-1>=0&&board[x][y-1]=='O'){//����
				queue.add(x*row+(y-1));
				board[x][y-1]='#';
			}
			if(y+1<col&&board[x][y+1]=='O'){//����
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
//		if(i-1>=0&&board[i-1][j]=='O'){//��������
//			board[i-1][j]='#';
//			DFS(i-1,j,board);
//		}
//		if(i+1<board.length&&board[i+1][j]=='O'){//��������
//			board[i+1][j]='#';
//			DFS(i+1,j,board);
//		}
//		if(j+1<board[0].length&&board[i][j+1]=='O'){//��������
//			board[i][j+1]='#';
//			DFS(i,j+1,board);
//		}
//		if(j-1>=0&&board[i][j-1]=='O'){//��������
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
    //���º���������
    public boolean isSurrounded(int x,int y,char[][] board){
    	boolean down=true,right=true;
    	int row=board.length,col=board[0].length;
    	if(x+1>=row) down=false;//��������
    	else if(board[x+1][y]=='X') down=true;
    	else down=isSurrounded(x+1,y,board);
    	
    	if(y+1>=col) right=false;//��������
    	else if(board[x][y+1]=='X') right=true;
    	else right=isSurrounded(x,y+1,board);
    	return down&&right;
    }
}
