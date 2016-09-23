/**
 * 
 */
package com.josh.interview;

import org.junit.Test;

/**
 * @Title: Comb
 * @Description:TODO
 * @author Summer
 * @date 2016年9月18日 上午11:05:45
 * 
 */
public class Permutation {

	@Test
	public void test() {
		String[] str = { "n", "e", "t", "e", "a", "s", "t" };
		per(str);
	}

	public void per(String[] str) {
		permutate(str, 0);
	}

	public void permutate(String[] str, int start) {
		if (start == str.length) {
			// 输出str
			for (int i = 0; i < str.length; i++) {
				System.out.print(str[i] + "  ");
				// System.out.println();
			}
		} else {
			for (int i = start; i < str.length; i++) {
				String tmp = str[i];
				str[i] = str[start];
				str[start] = tmp;

				permutate(str, start + 1);

				tmp = str[i];
				str[i] = str[start];
				str[start] = tmp;
			}
		}
	}
}
