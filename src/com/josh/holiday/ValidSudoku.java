package com.josh.holiday;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * ���⣺��֤���������Ƿ�Ϸ�������ÿһ�С�ÿһ�С�ÿ��С�Ź���ľŸ����ֲ������ظ���
 * ���������б��������б�������С�Ź������
 */
public class ValidSudoku {
	@Test
	public void test(){
		
	}
    public boolean isValidSudoku(char[][] board) {
       for(int i=0;i<9;i++){
    	   Set<Character> setRow = new HashSet<Character>();
    	   Set<Character> setClo = new HashSet<Character>();
    	   Set<Character> setNine = new HashSet<Character>();
    	   for(int j=0;j<9;j++){
    		   if(board[i][j]!='.' && !setRow.add(board[i][j])) return false;//��
    		   if(board[j][i]!='.' && !setClo.add(board[j][i])) return false;//��
    		   int r = j/3+(i/3)*3;//ÿ��С�Ź����������j/3���̱�ʾ
    		   int l = j%3+(i%3)*3;//ÿ��С�Ź����������j%3��������ʾ
    		  // System.out.print("("+r+"��"+l+")  ");
    		   if(board[r][l]!='.' && !setNine.add(board[r][l])) return false;//С�Ź���
    	   }
    	   //System.out.println();
       }
    	return true;
    }
}
