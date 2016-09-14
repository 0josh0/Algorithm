package com.josh.holiday;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/*
 * ���⣺�ö���ʵ��ջ
 * ����������Ԫ����ӣ���ԭ��Ԫ���ȳ��ӣ�����ӡ�
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
