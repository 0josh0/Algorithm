package com.josh.offer;

import java.util.Stack;

import org.junit.Test;

/*
 * 从尾到头打印链表结点
 * 解法：递归、栈
 */
public class PrintLinkReverse {

	@Test
	public void test(){
		LinkNode n1 = new LinkNode(1);
		LinkNode n2 = new LinkNode(2);
		LinkNode n3 = new LinkNode(3);
		LinkNode n4 = new LinkNode(4);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		System.out.println("use stack:");
		stack(n1);
		System.out.println("use recursion:");
		recursoin(n1);
	}
	//解法1：用栈实现
	public void stack(LinkNode head){
		if(head==null||head.next==null) return;
		Stack<Integer> stack = new Stack<>();
		while(head!=null){
			stack.push(head.value);
			head=head.next;
		}
		while(!stack.isEmpty()){
			//int value = stack.pop();
			System.out.println(stack.pop());
		}
	}
	//解法2：递归
	public void recursoin(LinkNode head){
		if(head==null) return;
		else{
			recursoin(head.next);
			System.out.println(head.value);
		}
			
	}
}
