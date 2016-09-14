package com.josh.holiday;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
 * 题意：用队列实现栈
 * 分析：将新元素入队，将原来元素先出队，再入队。
 */
public class ImplementStackusingQueues {
	@Test
	public void test(){
		
	}
	Queue<Integer> queue = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        queue.add(x);
        for(int i=0;i<queue.size()-1;i++){
        	int q = queue.poll();
        	queue.add(q);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}
