/**
 * 
 */
package com.josh.interview;

/**
 * @Title: MaxSubsquenceSum
 * @Description:最大连续子序列和：动态规划。因为最大 连续子序列和只可能是以位置0～n-1中某个位置结尾。
 *                                 当遍历到第i个元素时，判断在它前面的连续子序列和是否大于0，如果大于0，
 *                                 则以位置i结尾的最大连续子序列和为元素i和前门的连续子序列和相加；否则，
 *                                 则以位置i结尾的最大连续子序列和为元素i。
 * @author Summer
 * @date 2016年9月13日 下午3:22:27
 * 
 */
public class MaxSubsquenceSum {

	/**
	 * @Title:main
	 * @Description:TODO
	 * @param args
	 * @Author:Summer
	 * @Date:2016年9月13日
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 1, 3 - 2, 4, -5 };
		System.out.println(getMaxSum(A));
	}

	public static int getMaxSum(int[] A) {
		if (A.length == 0)
			return 0;
		int maxSum = A[0], dp = A[0];
		for (int i = 1; i < A.length; i++) {
			if (dp > 0) {
				dp += A[i];
			} else {
				dp = A[i];
			}
			maxSum = Math.max(maxSum, dp);
		}

		return maxSum;
	}

}
