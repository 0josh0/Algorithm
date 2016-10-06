package com.josh.offer;

import org.junit.Test;

/*
 * ·´×ªÁ´±í
 * 
 */
public class ReverLink {
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
		LinkNode head = reverse(n1);;
		while(head!=null){
			System.out.println(head.value);
			head=head.next;
		}
	}

	public LinkNode reverse(LinkNode head){
		if(head==null||head.next==null) return head;
		LinkNode pre = null,cur=head,next=head.next;
		while(next!=null){
			cur.next=pre;
			pre = cur;
			cur = next;
			next = next.next;
		}
		cur.next = pre;
		return cur;
	}
}
