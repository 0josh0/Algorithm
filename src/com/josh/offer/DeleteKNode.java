package com.josh.offer;

import org.junit.Test;

/*
 * 删除链表中倒数第k个结点
 * 解法：双指针
 */
public class DeleteKNode {

	@Test
	public void test(){
		LinkNode n1 = new LinkNode(1);
		LinkNode n2 = new LinkNode(2);
		LinkNode n3 = new LinkNode(3);
		LinkNode n4 = new LinkNode(4);
		LinkNode n5 = new LinkNode(5);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		
		//delete(n1,3);
		LinkNode head = delete(n1,1);;
		while(head!=null){
			System.out.println(head.value);
			head=head.next;
		}
	}
	public LinkNode delete(LinkNode head,int k){
		if(head==null) return null;
		LinkNode slow = head,fast = head;
		int count=0;
		while(fast!=null&&count<k){//快指针先走k步
			fast=fast.next;
			count++;
		}
		if(count<k) return head;
		if(fast==null){//删除头指针
			return head.next;
		}
		while(fast.next!=null){//快慢指针同时走，直到快指针走到尾结点
			fast=fast.next;
			slow=slow.next;
		}
		slow.next=slow.next.next;//此时慢指针指向的是待删除结点的前一个结点
		return head;
	}
}
