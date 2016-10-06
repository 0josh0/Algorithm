package com.josh.offer;

import java.util.Stack;

/*
 * ʵ��һ��������n��1��ʱ���ڻ�ȡջ����Сֵ��ջ
 * �ⷨ������ջ�洢ÿ����ջ�ĵ�ǰ��Сֵ
 * 
 */
public class StackWithMin {

	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	//���캯��
	public StackWithMin(){
		stack = new Stack<>();
		minStack = new Stack<>();
	}
	//��ջ
	public void push(int item){
		stack.push(item);
		if(minStack.isEmpty()){
			minStack.push(item);//��СջΪnull������ǰֵ��ջ
		}else{
			if(item<=minStack.peek()){//��ǰ��ջԪ��С��minStackջ����Сֵ������Сֵ��ջ
				minStack.push(item);
			}else{
				minStack.push(minStack.peek());//�����ٴ���ջ��ǰminջ����Сֵ����Ϊ���ε�ǰ��Сֵ
			}
		}
	}
	//��ջ
	public void pop(){
		stack.pop();
		minStack.pop();
	}
	//��ȡջ����Сֵ
	public int getMin(){
		return minStack.peek();
	}
}
 