package com.josh.task2;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

/**
 * 寻找一个由0和1构成的矩阵中，由1构成的面积最大的矩形
 * 解题思路：求出每一行的直方图，在每一行中求出当前最大面积的矩形
 * @author Josh
 *
 */
public class MaximalRectangle {
	
	@Test
	public void test(){
//		int[] A = {0,1,1,0,2};
//		maxRectangle(A);
		char[][] matrix = {{'0','0','1','0'},
						   {'1','1','1','0'},
						   {'1','1','1','0'},
						   {'0','0','0','1'}};
		//char[][] matrix = {{}};
		maximalRectangle(matrix);
	}
	
    public int maximalRectangle(char[][] matrix) {
		
    	int maxArea = 0;
    	if(matrix == null || matrix.length == 0){
    		System.out.println("最大矩形面积为：0");
    		return 0;
    	}
    	int[] histogram = new int[matrix[0].length];
    	//遍历二维数组，得到每一行的直方图
    	for(int i=0;i<matrix.length;i++){
    		for(int j=0;j<matrix[i].length;j++){
    			if(matrix[i][j] == '1'){
    				histogram[j]++;
    			}else{
    				histogram[j] = 0;
    			}
    		}
    		maxArea = Math.max(maxArea, maxRectangle(histogram));
    	}
    	System.out.println("最大矩形面积为："+maxArea);
    	return maxArea;
        
    }
 
    //求直方图的最大矩形面积
    public int maxRectangle(int[] A){
    	
    	int maxArea = 0;
    	Stack<Integer> stack = new Stack<Integer>();//栈存储数组索引，按值升序
    	int[] copyA = new int[A.length+1];
    	//将A中元素全部copy到copyA中，最后一位置为0
    	copyA = Arrays.copyOf(A, A.length+1);
    	copyA[A.length] = -1;
    	int i=0;
    	while(i<copyA.length){
    		if(stack.isEmpty() || copyA[stack.peek()]<=copyA[i]){
    			stack.push(i++);
    		}else{
    			int top = stack.pop();
    			maxArea = Math.max(maxArea, copyA[top]*(stack.isEmpty()?i:i-stack.peek()-1));
    		}
    	}
    	//System.out.println(maxArea);
    	return maxArea;
    }

}
