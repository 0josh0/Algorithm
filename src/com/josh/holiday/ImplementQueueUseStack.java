package com.josh.holiday;

import java.util.Stack;

import org.junit.Test;

/*
 * 题意:用栈实现队列的基本操作：push-把元素放到队尾
 *                       pop-移除队首元素
 *                       peek-get到队首元素
 *                       empty-判断队列是否为空
 * 分析:队列和栈的区别仅在于队里先入先出，栈是先入后出。
 *     所以push-把元素放到栈底；pop-和栈的pop一样；peek-和栈的peek一样；empty-和栈的empty一样
 *     
 */
public class ImplementQueueUseStack {
	private Stack<Integer> queue = new Stack<Integer>();
	private Stack<Integer> stack = new Stack<Integer>();
    // Push element x to the back of queue.
	//用两个stack模拟queue：首先把queue元素全部拷贝到stack，然后把要入队的元素压入stack，再将stack所有元素拷贝到queue
    public void push(int x) {
        while(!queue.isEmpty()){
        	stack.push(queue.pop());
        }
        stack.push(x);
        while(!stack.isEmpty()){
        	queue.push(stack.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        queue.pop();
    }

    // Get the front element.
    public int peek() {
        return queue.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
    
    @Test
    public void test(){
    	ImplementQueueUseStack myQueue = new ImplementQueueUseStack();
    	myQueue.push(1);
    	myQueue.push(2);
    	myQueue.push(3);
    	//System.out.println("Before pop…………………");
    	while(!myQueue.empty()){
    		System.out.println(myQueue.peek());
    		myQueue.pop();
    	}
    	//System.out.println("After pop…………………");
    }
}
