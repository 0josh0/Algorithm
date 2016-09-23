package com.josh.holiday;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * 题意：验证数独棋盘是否合法，即，每一行、每一列、每个小九宫格的九个数字不能有重复的
 * 分析：按行遍历，按列遍历，按小九宫格遍历
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
    		   if(board[i][j]!='.' && !setRow.add(board[i][j])) return false;//行
    		   if(board[j][i]!='.' && !setClo.add(board[j][i])) return false;//列
    		   int r = j/3+(i/3)*3;//每个小九宫格的行数用j/3的商表示
    		   int l = j%3+(i%3)*3;//每个小九宫格的列数用j%3的余数表示
    		  // System.out.print("("+r+"、"+l+")  ");
    		   if(board[r][l]!='.' && !setNine.add(board[r][l])) return false;//小九宫格
    	   }
    	   //System.out.println();
       }
    	return true;
    }
}
