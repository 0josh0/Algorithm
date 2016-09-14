package com.josh.holiday;

import org.junit.Test;

/*
 * ������������Ŀ���������Ϸ,����һ��ϸ���Զ���,
 * ÿһ��λ��������״̬��1Ϊ��ϸ����0Ϊ��ϸ��������ÿ��λ�ö��������µ�������
	1. �����ϸ����Χ�˸�λ�õĻ�ϸ�����������������λ�û�ϸ������
	2. �����ϸ����Χ�˸�λ����������������ϸ�������λ�û�ϸ����Ȼ���
	3. �����ϸ����Χ�˸�λ���г���������ϸ�������λ�û�ϸ������
	4. �����ϸ����Χ������������ϸ�������λ����ϸ������
	
	�������ò�ͬ�����ֱ��״̬
	0 : ��һ����0����һ�ֹ�����0
	1 : ��һ����1����һ�ֹ�����1
	2 : ��һ����1����һ�ֹ����Ϊ0
	3 : ��һ����0����һ�ֹ����Ϊ1
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
		int row = board.length;//����
		int col = board[0].length;//����
        for(int i=0;i<row;i++){
        	for(int j=0;j<col;j++){
        		int alive = 0;//��¼��ǰϸ����Χ��ϸ����
        		if(i>0&&j>0){//�ж����Ͻ�
        			if(board[i-1][j-1]==1 || board[i-1][j-1]==2) alive++;
        		}
        		if(i>0){//�ж����Ϸ�
        			if(board[i-1][j]==1 || board[i-1][j]==2) alive++;
        		}
        		if(i>0&&j<col-1){//�ж����Ͻ�
        			if(board[i-1][j+1]==1 || board[i-1][j+1]==2) alive++;
        		}
        		if(j<col-1){//�ж��Ҳ�
        			if(board[i][j+1]==1 || board[i][j+1]==2) alive++;
        		}
        		if(i<row-1&&j<col-1){//�ж����½�
        			if(board[i+1][j+1]==1 || board[i+1][j+1]==2) alive++;
        		}
        		if(i<row-1){//�ж����·�
        			if(board[i+1][j]==1 || board[i+1][j]==2) alive++;
        		}
        		if(i<row-1&&j>0){//�ж����½�
        			if(board[i+1][j-1]==1 || board[i+1][j-1]==2) alive++;
        		}
        		if(j>0){//�ж����
        			if(board[i][j-1]==1 || board[i][j-1]==2) alive++;
        		}
        		if(board[i][j]==0){//ԭ������ϸ��
        			if(alive==3) board[i][j] = 3;//��ϸ������
        		}else{//ԭ���ǻ�ϸ��
        			if(!(alive==2||alive==3)) board[i][j] = 2;//��ϸ����
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
