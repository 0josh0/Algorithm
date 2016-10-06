package com.josh.offer;

import org.junit.Test;

/*
 * ɾ�������е�����k�����
 * �ⷨ��˫ָ��
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
		while(fast!=null&&count<k){//��ָ������k��
			fast=fast.next;
			count++;
		}
		if(count<k) return head;
		if(fast==null){//ɾ��ͷָ��
			return head.next;
		}
		while(fast.next!=null){//����ָ��ͬʱ�ߣ�ֱ����ָ���ߵ�β���
			fast=fast.next;
			slow=slow.next;
		}
		slow.next=slow.next.next;//��ʱ��ָ��ָ����Ǵ�ɾ������ǰһ�����
		return head;
	}
}
