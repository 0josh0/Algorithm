package com.josh.task1;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
/**
 * 未完待续。。。。。。。
 * 
 * @author Josh
 *
 */
public class WordSearch {

	@Test
	public void test() {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		// char[][] board = { { 'a', 'b' }, { 'c', 'd' } };
		exist(board, "SEE");
	}

	public boolean exist(char[][] board, String word) {
		// 将word转化成char数组
		char[] charWord = word.toCharArray();

		int initialX = -1, initialY = -1;
		// boolean b = false;
		int i = 0, j = 0;
		// 判断字符串是否为空
		if (charWord.length == 0) {
			System.out.println("未找到目标单词  " + word);
			return false;
		}
		// 初始化标记位
		boolean[][] p = new boolean[board.length][board[0].length];
		for (int pi = 0; pi < board.length; pi++) {
			for (int pj = 0; pj < board[0].length; pj++) {
				p[pi][pj] = false;
			}
		}
		// 搜索word的首字母
		int count = 0;
		Map<Integer, Integer> mapXY = new HashMap<Integer, Integer>();
		while (i < board.length) {
			while (j < board[i].length) {
				if (board[i][j] == charWord[0]) {
					// initialX = i;
					// initialY = j;
					// 将首字母存起来
					mapXY.put(i, j);
					count++;
				}
				j++;
			}
			i++;
		}
		if (count == 0) {
			System.out.println("未找到目标单词  " + word);
			return false;
		} else {
			for (int c = 0; c < count; c++) {
				// 遍历存储首字母的数据结构
			}
			int m = initialX;
			int n = initialY;
			int k = 1;
			while (k < charWord.length) {
				if (n < board[m].length - 1 && board[m][n + 1] == charWord[k] && p[m][n + 1] == false) {// 从首字母向右搜索
					p[m][n + 1] = true;
					k++;
					n++;
				} else if (n > 0 && board[m][n - 1] == charWord[k] && p[m][n - 1] == false) {// 从首字母向左搜索
					p[m][n - 1] = true;
					k++;
					n--;
				} else if (m < board.length - 1 && board[m + 1][n] == charWord[k] && p[m + 1][n] == false) {// 从首字母向下搜索
					p[m + 1][n] = true;
					k++;
					m++;
				} else if (m > 0 && board[m - 1][n] == charWord[k] && p[m - 1][n] == false) {// 从首字母向上搜索
					p[m - 1][n] = true;
					k++;
					m--;
				} else {
					System.out.println("未找到目标单词  " + word);
					return false;
				}
			}
			System.out.println("找到目标单词  " + word);
			return true;
		}

	}

	public boolean exist2(char[][] board, String word) {

		// 将word转化成char数组
		char[] charWord = word.toCharArray();

		if (charWord == null) {
			System.out.println("未找到目标单词  " + word);
			return false;
		} else {
			int i = 0, j = 0;
			int k;
			while (i < charWord.length && j < board.length) {
				// 根据j来判断一行的横向查找方向
				if (j % 2 == 0) {
					// 偶数，正向查找
					k = 0;
					while (i < charWord.length && k < board[j].length) {
						// 如果找到单词中的某个字母，跳出board层循环，进入顶层循环查找单词中的下一个字母
						if (i < charWord.length && board[j][k] == charWord[i]) {
							i++;
						}
						k++;
					}
				} else {
					// 奇数，反向查找
					k = board[j].length - 1;
					while (i < charWord.length && k >= 0) {
						// 如果找到单词中的某个字母，跳出board层循环，进入顶层循环查找单词中的下一个字母
						if (i < charWord.length && board[j][k] == charWord[i]) {
							i++;
						}
						k--;
					}
				}
				j++;
			}
			// 遍历数组全部没有找到单词中的字母，说明单词不存在。
			if (i < charWord.length) {
				System.out.println("未找到目标单词  " + word);
				return false;
			} else {
				System.out.println("找到目标单词  " + word);
				return true;
			}

		}
	}
}
