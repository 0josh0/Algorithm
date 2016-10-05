package com.josh.offer;

import java.util.Stack;

//用两个栈实现一个队列

public class StackQueue {

	Stack<Integer> deq = new Stack<>();//保存即将要出队的元素
	Stack<Integer> inq = new Stack<>();//保存入队的元素
	int size = 0;//保存队列中的元素个数
	
	public int dequeue(){
		if(size==0) return -1;
		if(!deq.isEmpty()){//如果出队栈不为空，直接从栈顶pop
			size--;
			return deq.pop();
		}else{
			while(inq.size()>1){//将入队栈中的元素全部拷贝到出队栈中（最后一个不拷贝，直接弹出，减少一次入栈出栈操作）
				int item = inq.pop();
				deq.push(item);
			}	
			size--;
			return inq.pop();
		}
	}
	public void inqueue(int value){
		size++;
		inq.push(value);
	}
	public boolean isEmpty(){
		return size==0;
	}
}
