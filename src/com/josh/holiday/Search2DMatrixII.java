package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺��һ����ά������Ѱ��ָ��value����ά��������ң����ϵ��¾��������
 * ������1 �����ⷨ��O(N2) -- û���õ��������������Ȼͨ���ˣ���
 *     2 �����Ͻǿ�ʼ, �Ƚ�target �� matrix[i][j]��ֵ. 
 *     ���С��target, ����в������д���,  ����i++; 
 *     �������target, ����в������д���, ����j--. 
 *     �����߽�������þ��󲻺�target.
 */
public class Search2DMatrixII {
	@Test
	public void test(){
		//int[][] matrix = {{2,5},{2,8},{7,9},{7,11},{9,11}};
		int[][] matrix = {{1,3,5,7,9},{2,4,6,8,10},{11,13,15,17,19},{12,14,16,18,20},{21,22,23,24,25}};
		System.out.println(searchMatrix(matrix, 11));
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		int m=matrix.length,n=matrix[0].length;
		int i=0,j=n-1;
        while(i<m&&j>=0){
        	if(matrix[i][j]==target) return true;
        	else if(matrix[i][j]<target) i++;
        	else j--;
        }
        return false;
    }
	public boolean searchMatrix1(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		if(matrix[i][j]==target) return true;
        		//if(matrix[i][j]>target) return false;
        	}
        }
        return false;
    }
}
