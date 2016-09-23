package com.josh.holiday;


import org.junit.Test;

/*
 * 题意：给定数字n，表示一个从1-n2的二维数组，然后旋转输出数组中所有元素
 * 分析：同1
 */
public class SpiralMatrixII {
	@Test
	public void test(){
		int[][] res = new int[1][1];
		
		res = generateMatrix(1);
		for(int i=0;i<res.length;i++){
			for(int j=0;j<res[0].length;j++){
				System.out.println(res[i][j]);
			}
			
		}
	}
	public int[][] generateMatrix(int n) {
		if(n==0) return new int[0][0];
		int[][] res = new int[n][n];
		helper(n,0,0,1,res);
		return res;
    }
	public void helper(int n,int x,int y,int value,int[][] res){
		if(n==0){
			return ;
		}else if(n==1){
			res[x][y] = value;
			return;
		}else{
			for(int i=0;i<n;i++){
				res[x][y+i]=value+i;
			}
			for(int i=0;i<n-1;i++){
				res[x+1+i][y+n-1]=res[x][y+n-1]+1+i;
			}
			for(int i=0;i<n-1;i++){
				res[x+n-1][y+n-2-i]=res[x+n-1][y+n-1]+1+i;
			}
			for(int i=0;i<n-2;i++){
				res[x+n-2-i][y]=res[x+n-1][y]+1+i;
			}
			helper(n-2,x+1,y+1,res[x+1][y]+1,res);
		}
	}
}
