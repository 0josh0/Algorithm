package com.josh.offer;

import org.junit.Test;

/*
 * ��ά����������Ѱ��target
 * ÿһ�д����ҵ���
 * ÿһ�д��ϵ��µ���
 * �ⷨ�������Ͻǿ�ʼѰ��
 */
public class FindInSortedMatrix {

	@Test
	public void test(){
		int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.println(find(matrix,11));
	}
	public boolean find(int[][] matrix,int target){
		if(matrix.length==0) return false;
		int row=matrix.length-1,col=matrix[0].length-1;
		int i=0,j=col;
		while(i<=row&&j>=0){
			if(matrix[i][j]==target)
				return true;
			else if(matrix[i][j]>target)
				j--;
			else
				i++;
		}
		return false;
	}
}
