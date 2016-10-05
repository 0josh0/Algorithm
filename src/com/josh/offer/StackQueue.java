package com.josh.offer;

import java.util.Stack;

//������ջʵ��һ������

public class StackQueue {

	Stack<Integer> deq = new Stack<>();//���漴��Ҫ���ӵ�Ԫ��
	Stack<Integer> inq = new Stack<>();//������ӵ�Ԫ��
	int size = 0;//��������е�Ԫ�ظ���
	
	public int dequeue(){
		if(size==0) return -1;
		if(!deq.isEmpty()){//�������ջ��Ϊ�գ�ֱ�Ӵ�ջ��pop
			size--;
			return deq.pop();
		}else{
			while(inq.size()>1){//�����ջ�е�Ԫ��ȫ������������ջ�У����һ����������ֱ�ӵ���������һ����ջ��ջ������
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
