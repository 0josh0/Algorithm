/**
 * 
 */
package com.josh.interview;

/**
 * @Title: MaxSubsquenceSum
 * @Description:������������кͣ���̬�滮����Ϊ��� ���������к�ֻ��������λ��0��n-1��ĳ��λ�ý�β��
 *                                 ����������i��Ԫ��ʱ���ж�����ǰ������������к��Ƿ����0���������0��
 *                                 ����λ��i��β��������������к�ΪԪ��i��ǰ�ŵ����������к���ӣ�����
 *                                 ����λ��i��β��������������к�ΪԪ��i��
 * @author Summer
 * @date 2016��9��13�� ����3:22:27
 * 
 */
public class MaxSubsquenceSum {

	/**
	 * @Title:main
	 * @Description:TODO
	 * @param args
	 * @Author:Summer
	 * @Date:2016��9��13��
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
