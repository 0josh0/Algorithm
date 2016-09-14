package com.josh.task1;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
/**
 * δ�������������������
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
		// ��wordת����char����
		char[] charWord = word.toCharArray();

		int initialX = -1, initialY = -1;
		// boolean b = false;
		int i = 0, j = 0;
		// �ж��ַ����Ƿ�Ϊ��
		if (charWord.length == 0) {
			System.out.println("δ�ҵ�Ŀ�굥��  " + word);
			return false;
		}
		// ��ʼ�����λ
		boolean[][] p = new boolean[board.length][board[0].length];
		for (int pi = 0; pi < board.length; pi++) {
			for (int pj = 0; pj < board[0].length; pj++) {
				p[pi][pj] = false;
			}
		}
		// ����word������ĸ
		int count = 0;
		Map<Integer, Integer> mapXY = new HashMap<Integer, Integer>();
		while (i < board.length) {
			while (j < board[i].length) {
				if (board[i][j] == charWord[0]) {
					// initialX = i;
					// initialY = j;
					// ������ĸ������
					mapXY.put(i, j);
					count++;
				}
				j++;
			}
			i++;
		}
		if (count == 0) {
			System.out.println("δ�ҵ�Ŀ�굥��  " + word);
			return false;
		} else {
			for (int c = 0; c < count; c++) {
				// �����洢����ĸ�����ݽṹ
			}
			int m = initialX;
			int n = initialY;
			int k = 1;
			while (k < charWord.length) {
				if (n < board[m].length - 1 && board[m][n + 1] == charWord[k] && p[m][n + 1] == false) {// ������ĸ��������
					p[m][n + 1] = true;
					k++;
					n++;
				} else if (n > 0 && board[m][n - 1] == charWord[k] && p[m][n - 1] == false) {// ������ĸ��������
					p[m][n - 1] = true;
					k++;
					n--;
				} else if (m < board.length - 1 && board[m + 1][n] == charWord[k] && p[m + 1][n] == false) {// ������ĸ��������
					p[m + 1][n] = true;
					k++;
					m++;
				} else if (m > 0 && board[m - 1][n] == charWord[k] && p[m - 1][n] == false) {// ������ĸ��������
					p[m - 1][n] = true;
					k++;
					m--;
				} else {
					System.out.println("δ�ҵ�Ŀ�굥��  " + word);
					return false;
				}
			}
			System.out.println("�ҵ�Ŀ�굥��  " + word);
			return true;
		}

	}

	public boolean exist2(char[][] board, String word) {

		// ��wordת����char����
		char[] charWord = word.toCharArray();

		if (charWord == null) {
			System.out.println("δ�ҵ�Ŀ�굥��  " + word);
			return false;
		} else {
			int i = 0, j = 0;
			int k;
			while (i < charWord.length && j < board.length) {
				// ����j���ж�һ�еĺ�����ҷ���
				if (j % 2 == 0) {
					// ż�����������
					k = 0;
					while (i < charWord.length && k < board[j].length) {
						// ����ҵ������е�ĳ����ĸ������board��ѭ�������붥��ѭ�����ҵ����е���һ����ĸ
						if (i < charWord.length && board[j][k] == charWord[i]) {
							i++;
						}
						k++;
					}
				} else {
					// �������������
					k = board[j].length - 1;
					while (i < charWord.length && k >= 0) {
						// ����ҵ������е�ĳ����ĸ������board��ѭ�������붥��ѭ�����ҵ����е���һ����ĸ
						if (i < charWord.length && board[j][k] == charWord[i]) {
							i++;
						}
						k--;
					}
				}
				j++;
			}
			// ��������ȫ��û���ҵ������е���ĸ��˵�����ʲ����ڡ�
			if (i < charWord.length) {
				System.out.println("δ�ҵ�Ŀ�굥��  " + word);
				return false;
			} else {
				System.out.println("�ҵ�Ŀ�굥��  " + word);
				return true;
			}

		}
	}
}
