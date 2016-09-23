package com.josh.task2;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

/**
 * Ѱ��һ����0��1���ɵľ����У���1���ɵ�������ľ���
 * ����˼·�����ÿһ�е�ֱ��ͼ����ÿһ���������ǰ�������ľ���
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
    		System.out.println("���������Ϊ��0");
    		return 0;
    	}
    	int[] histogram = new int[matrix[0].length];
    	//������ά���飬�õ�ÿһ�е�ֱ��ͼ
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
    	System.out.println("���������Ϊ��"+maxArea);
    	return maxArea;
        
    }
 
    //��ֱ��ͼ�����������
    public int maxRectangle(int[] A){
    	
    	int maxArea = 0;
    	Stack<Integer> stack = new Stack<Integer>();//ջ�洢������������ֵ����
    	int[] copyA = new int[A.length+1];
    	//��A��Ԫ��ȫ��copy��copyA�У����һλ��Ϊ0
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
