package com.josh.offer;

import org.junit.Test;

/*
 * 归并有序链表
 * 解法：递归&非递归
 */
public class MergeSortLink {

	@Test
	public void test(){
		LinkNode n1 = new LinkNode(1);
		LinkNode n2 = new LinkNode(3);
		LinkNode n3 = new LinkNode(5);
		LinkNode n4 = new LinkNode(7);
		LinkNode n5 = new LinkNode(9);
		
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		
		LinkNode nn1 = new LinkNode(2);
		LinkNode nn2 = new LinkNode(4);
		LinkNode nn3 = new LinkNode(6);
		LinkNode nn4 = new LinkNode(8);
		LinkNode nn5 = new LinkNode(10);
		
		nn1.next=nn2;
		nn2.next=nn3;
		nn3.next=nn4;
		nn4.next=nn5;
		
		LinkNode head = merge(n1,nn1);
		
		while(head!=null){
			System.out.println(head.value);
			head=head.next;
		}
	}
	//递归
	public LinkNode merge(LinkNode h1,LinkNode h2){
		if(h1==null) return h2;
		else if(h2==null) return h1;
		LinkNode mergeHead = null;
		if(h1.value<h2.value){
			mergeHead=h1;
			mergeHead.next = merge(h1.next,h2);
		}else{
			mergeHead=h2;
			mergeHead.next = merge(h1,h2.next);
		}
		return mergeHead;
	}
}
