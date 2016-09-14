package com.josh.task10;

import org.junit.Test;
/*
 * ����: ��������������
 * ����: DP-��ÿһ��λ���ϵ����ֱ�ʾ�Ե�ǰλ��Ϊ���������½ǵ���߳�
 * 		��d[i][j]!=0ʱ����d[i][j]Ϊ���½ǵ���������εı߳�=min(d[i-1][j-1]d[i-1][j]d[i][j-1])+1
 * 		��d[i][j]==0ʱ����d[i][j]Ϊ���½ǵ���������εı߳�=0
 * 		��d[i][j]!=0ʱ����̬�滮�ĵ��Ʒ���:d[i][j]=min(d[i-1][j-1]d[i-1][j]d[i][j-1])+1
 */
public class MaximalSquare {
	@Test
	public void test(){
		char[][] c = {{'1','1','1'},{'1','1','1'},{'1','1','1'}};
		//c[1][1] = '1';
		System.out.println(maximalSquare(c));
	}
	public int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int maxEdge=0;
        int[][] area = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<area[0].length;j++){
        		area[i][j] = matrix[i][j]-'0';
        	}
        }
		for(int i=0;i<area.length;i++){
			if(area[i][0]==1){
				maxEdge=1;
				break;
			}
		}
		if(maxEdge==0){
			for(int i=0;i<area[0].length;i++){
				if(area[0][i]==1){
					maxEdge=1;
					break;
				}
			}
		}
		for(int i=1;i<area.length;i++){
			for(int j=1;j<area[0].length;j++){
				if(area[i][j]!=0){
					area[i][j] = Math.min(area[i-1][j-1],Math.min(area[i-1][j],area[i][j-1]))+1;
				}
				maxEdge = Math.max(maxEdge,area[i][j]);
			}
		}
		return maxEdge*maxEdge;
	}
}
