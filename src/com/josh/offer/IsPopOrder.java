package com.josh.offer;

import java.util.Stack;

import org.junit.Test;

/*
 * ������ջ�����жϸ��������Ƿ��ǳ�ջ����
 * �ⷨ���ж�ջ��Ԫ���Ƿ��ǳ�ջ�����еĶ���Ԫ�أ����ǣ���ջ�������ǣ�����ջ�����е�Ԫ��һ����ջ
 */
public class IsPopOrder {

	@Test
	public void test(){
		int[] pushOrder = {1,2,3,4,5};
		int[] popOrder = {4,5,3,2,1};
		System.out.println(isOrder(pushOrder,popOrder));
	}
	public boolean isOrder(int[] pushOrder,int[] popOrder){
		boolean result = false;
		int pushIndex=0,popIndex=0;
		Stack<Integer> stack = new Stack<>();
		stack.push(pushOrder[pushIndex++]);
		while(popIndex<popOrder.length){
			if(stack.peek()!=popOrder[popIndex]){
				if(pushIndex<pushOrder.length)
					stack.push(pushOrder[pushIndex++]);
				else
					break;
				//pushIndex++;
			}else if(stack.peek().equals(popOrder[popIndex])){
				stack.pop();
				popIndex++;
			}
		}
		if(stack.isEmpty()) result=true;
		return result;
	}
}
