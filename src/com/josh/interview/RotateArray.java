/**
 * 
 */
package com.josh.interview;

import org.junit.Test;

/**
 * @Title: RotateArray
 * @Description:TODO
 * @author Summer
 * @date 2016��9��13�� ����10:38:13
 * 
 */
public class RotateArray {

	@Test
	public void test() {
		int[] A = { 7, 6, 5, 4, 3, 1, 2 };
		System.out.println(getTarget(A, 1));
	}

	public static int getTarget(int[] A, int target) {
		int l = 0, r = A.length - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			if (A[mid] == target)
				return mid;
			else {
				if (A[mid] > A[r] && A[mid] < target) {// mid֮ǰ����,target�����򲿷�
					r = mid;
				} else if (A[mid] > A[r] && A[mid] > target) {// mid֮ǰ����,target�����򲿷�
					l = mid;
				} else if (A[mid] < A[r] && A[mid] < target) {// mid֮������,target�����򲿷�
					l = mid;
				} else {
					r = mid;
				}
			}
		}
		return -1;
	}
}
