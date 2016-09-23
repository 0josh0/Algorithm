package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * 题意：旋转输出数组中的数字
 * 分析：递归
 */
public class SpiralMatrix {
	@Test
	public void test(){
		int[][] matrix = { { 2, 5 },
						   { 8, 4 },
						   { 0, -1 }};
		List<Integer> list = new ArrayList<Integer>();
		list = spiralOrder(matrix);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix.length==0) return list;
        helper(matrix,matrix.length,matrix[0].length,0,0,list);
        return list;
    }
	public void helper(int[][] matrix,int row,int col,int x,int y,List<Integer> list){
		if(row==0||col==0){//当行数或者列数为0，返回
			return ;
		}else if(row==1){//行数为1，累加一行
			for(int i=0;i<col;i++){
				list.add(matrix[x][y+i]);
			}
		}else if(col==1){//列数为1，累加一列
			for(int i=0;i<row;i++){
				list.add(matrix[x+i][y]);
			}
		}else{//求一圈值
			for(int i=0;i<col;i++){//上侧，从左到右
				list.add(matrix[x][y+i]);
			}
			for(int i=0;i<row-1;i++){//右侧，从上到下
				list.add(matrix[x+1+i][y+col-1]);
			}
			for(int i=0;i<col-1;i++){//下侧，从右到左
				list.add(matrix[x+row-1][y+col-2-i]);
			}
			for(int i=0;i<row-2;i++){//左侧，从下到上
				list.add(matrix[x+row-2-i][y]);
			}
			helper(matrix,row-2,col-2,x+1,y+1,list);//递归
		}
	}
}
