/**
 * 
 */
package com.josh.interview;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Title: DiDi01
 * @Description:TODO
 * @author Summer
 * @date 2016年9月18日 下午3:46:12
 * 
 */
public class DiDi01 {

	private static int globalP = 0;
	private static List<int[]> list = new LinkedList<>();

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int p = in.nextInt();
		int[][] pazzel = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				pazzel[i][j] = in.nextInt();
			}
		}
		List<int[]> tmp = new LinkedList<>();
		boolean res = dfs(pazzel, 0, 0, p, tmp);
		if (res == false)
			System.out.println("Can not escape!");
		else
			print(list);

	}

	public static void print(List<int[]> list) {
		String s = "";
		for (int[] tuple : list) {
			s += "[" + tuple[0] + "," + tuple[1] + "]" + ",";
		}
		s = s.substring(0, s.length() - 1);
		System.out.println(s);
	}

	public static boolean dfs(int[][] pazzel, int x, int y, int p, List<int[]> res) {
		// 爬到中点时，体力值大于等于0
		if (x == 0 && y == pazzel[0].length - 1 && p >= 0) {
			if (p > globalP) {
				res.add(new int[] { x, y });
				globalP = p;
				list = res;
			}
			return true;
		}
		// 仍然有体力值，且不能爬出边界
		else if (p < 0 || x == -1 || x == pazzel.length || y == -1 || y == pazzel[0].length || pazzel[x][y] == 0)
			return false;
		else {
			// 向右爬
			int[] curr = new int[] { x, y };
			if (y + 1 != pazzel[0].length && pazzel[x][y + 1] == 1) {
				pazzel[x][y] = 0; // 将当前位置置为0
				res.add(curr);
				boolean right = dfs(pazzel, x, y + 1, p - 1, res);
				if (right == true)
					return true;
				else {
					res.remove(curr);
					pazzel[x][y] = 1;
				}
			}
			// 向下爬
			if (x + 1 != pazzel.length && pazzel[x + 1][y] == 1) {
				pazzel[x][y] = 0;
				res.add(curr);
				boolean down = dfs(pazzel, x + 1, y, p, res);
				if (down == true)
					return true;
				else {
					pazzel[x][y] = 1;
					res.remove(curr);
				}
			}
			// 向上爬
			if (x - 1 != -1 && pazzel[x - 1][y] == 1) {
				pazzel[x][y] = 0;
				res.add(curr);
				boolean up = dfs(pazzel, x - 1, y, p - 3, res);
				if (up == true)
					return true;
				else {
					pazzel[x][y] = 1;
					res.remove(curr);
				}
			}
			// 向左爬
			if (y - 1 != -1 && pazzel[x][y - 1] == 1) {
				pazzel[x][y] = 0;
				res.add(curr);
				boolean left = dfs(pazzel, x, y - 1, p - 1, res);
				if (left == true)
					return true;
				else {
					pazzel[x][y] = 1;
					res.remove(curr);
				}
			}
			return false;
		}

	}

}
