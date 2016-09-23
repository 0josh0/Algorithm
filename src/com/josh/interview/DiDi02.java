/**
 * 
 */
package com.josh.interview;

import java.util.Scanner;

/**
 * @Title: DiDi02
 * @Description:TODO
 * @author Summer
 * @date 2016年9月18日 下午4:22:18
 * 
 */
public class DiDi02 {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();

		int ret = 0;
		while (N > 0) {
			ret += N / 5;
			N /= 5;
		}
		System.out.println(ret);
	}

}
