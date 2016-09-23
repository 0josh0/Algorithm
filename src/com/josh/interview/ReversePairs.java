/**
 * 
 */
package com.josh.interview;

import org.junit.Test;

/**
 * @Title: ReversePairs
 * @Description:TODO
 * @author Summer
 * @date 2016年9月19日 下午11:30:25
 * 
 */
public class ReversePairs {
	int sum = 0;

	@Test
	public void test() {
		int[] a = { 7, 5, 4, 8 };
		merge(a, 0, 3);
		System.out.println("逆序数组一共有：" + sum + " 对");
		for (Integer i : a) {
			System.out.print(i + "  ");
		}
	}

	// int count = 0;

	public void merge(int[] a, int l, int r) {
		int count = 0;
		if (l < r) {
			int m = (l + r) / 2;
			merge(a, l, m);
			merge(a, m + 1, r);
			mergeSort(a, l, m, r, count);
		}
		// System.out.println(count);
	}

	public void mergeSort(int[] a, int l, int m, int r, int count) {
		int[] tmp = new int[r - l + 1];
		int p1 = m, p2 = r, k = tmp.length - 1;
		while (k >= 0) {
			if (p1 < l) {// 左半部分已经没有，把右半部分全部拷贝到tmp
				while (p2 >= m + 1) {
					tmp[k--] = a[p2--];
				}
				break;
			}
			if (p2 < m + 1) {
				while (p1 >= l) {
					tmp[k--] = a[p1--];
				}
				break;
			}
			if (a[p1] > a[p2]) {
				count++;
				// System.out.println(count);
				tmp[k--] = a[p1--];
				sum += count;
			} else if (a[p2] > a[p1]) {
				tmp[k--] = a[p2--];
			} else {
				tmp[k--] = a[p1--];
				tmp[k--] = a[p2--];
			}
		}
		System.arraycopy(tmp, 0, a, l, tmp.length);
	}
}
