package com.josh.offer;

import org.junit.Test;

/*
 * ����ͷָ���ɾ����㣬��O(1)ʱ����ɾ���ý��
 * �ⷨ��ָ���ߵ���ɾ������ʱ�򣬽����һ������ֵ������ǰ��㣬Ȼ��ɾ������һ�����
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
				if(cur.next==null) cur=null;//Ҫɾ���Ľ�������һ��
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
