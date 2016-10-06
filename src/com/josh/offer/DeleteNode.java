package com.josh.offer;

import org.junit.Test;

/*
 * 给定头指针和删除结点，在O(1)时间内删除该结点
 * 解法：指针走到待删除结点的时候，将其后一个结点的值赋给当前结点，然后删除其下一个结点
 * 
 */
public class DeleteNode {

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
		
		//LinkNode head = delete(n1,n3);
		
		LinkNode head = n1;
		delete2(n4);
		
		while(head!=null){
			System.out.println(head.value);
			head=head.next;
		}
	}
	public void delete2(LinkNode node){
		if(node.next==null){
			node=null;
		}
		else{
			node.value = node.next.value;
			node.next = node.next.next;
		}
	}
	public LinkNode delete(LinkNode head,LinkNode node){
		if(head==null) return null;
		if(head.equals(node)) return head.next;
		LinkNode cur = head;
		while(cur!=null){
			if(cur.equals(node)){
				if(cur.next==null) cur=null;//要删除的结点是最后一个
				else{
					cur.value = cur.next.value;
					cur.next=cur.next.next;
				}
				break;
			}else
				cur=cur.next;
		}
		return head;
	}
}
