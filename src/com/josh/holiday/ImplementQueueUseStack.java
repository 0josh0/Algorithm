package com.josh.holiday;

import java.util.Stack;

import org.junit.Test;

/*
 * ����:��ջʵ�ֶ��еĻ���������push-��Ԫ�طŵ���β
 *                       pop-�Ƴ�����Ԫ��
 *                       peek-get������Ԫ��
 *                       empty-�ж϶����Ƿ�Ϊ��
 * ����:���к�ջ����������ڶ��������ȳ���ջ����������
 *     ����push-��Ԫ�طŵ�ջ�ף�pop-��ջ��popһ����peek-��ջ��peekһ����empty-��ջ��emptyһ��
 *     
 */
public class ImplementQueueUseStack {
	private Stack<Integer> queue = new Stack<Integer>();
	private Stack<Integer> stack = new Stack<Integer>();
    // Push element x to the back of queue.
	//������stackģ��queue�����Ȱ�queueԪ��ȫ��������stack��Ȼ���Ҫ��ӵ�Ԫ��ѹ��stack���ٽ�stack����Ԫ�ؿ�����queue
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
    	//System.out.println("Before pop��������������");
    	while(!myQueue.empty()){
    		System.out.println(myQueue.peek());
    		myQueue.pop();
    	}
    	//System.out.println("After pop��������������");
    }
}
