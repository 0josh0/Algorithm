package com.josh.offer;

import java.util.Stack;

/*
 * 实现一个可以在n（1）时间内获取栈内最小值的栈
 * 解法：辅助栈存储每次入栈的当前最小值
 * 
 */
public class StackWithMin {

	private Stack<Integer> stack;
	private Stack<Integer> minStack;
	//构造函数
	public StackWithMin(){
		stack = new Stack<>();
		minStack = new Stack<>();
	}
	//入栈
	public void push(int item){
		stack.push(item);
		if(minStack.isEmpty()){
			minStack.push(item);//最小栈为null，将当前值入栈
		}else{
			if(item<=minStack.peek()){//当前入栈元素小于minStack栈顶最小值，将最小值入栈
				minStack.push(item);
			}else{
				minStack.push(minStack.peek());//否则再次入栈当前min栈顶最小值，最为本次当前最小值
			}
		}
	}
	//出栈
	public void pop(){
		stack.pop();
		minStack.pop();
	}
	//获取栈中最小值
	public int getMin(){
		return minStack.peek();
	}
}
 