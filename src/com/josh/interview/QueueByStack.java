/**
 * 
 */
package com.josh.interview;

import java.util.Stack;

/**
 * @Title: QueueByStack
 * @Description:TODO
 * @author Summer
 * @date 2016年9月14日 上午11:04:10
 * 
 */
public class QueueByStack {

	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void add(int value) {
		stack1.push(value);
	}

	public int dequeue() {
		if (!stack2.isEmpty()) {
			return stack2.pop();
		} else {
			// if(stack1.isEmpty()) return null;
			int elment = stack1.pop();
			while (!stack1.isEmpty()) {
				stack2.push(elment);
				elment = stack1.pop();
			}
			return elment;
		}
	}
}
