package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺��������Ҫ��ʱ�临�Ӷ�nlogn���ռ临�Ӷ�O(1)
 * �������鲢���򣬶�����Ĳ�����
 *     1��Ѱ���м�ڵ� - ���ÿ���ָ�룬��ı����Ŀ�һ�������Ե�fast��ĩβ��ʱ��slow����mid
 *     2����ǰ������� - �ݹ���У�ֱ��ֻ��һ���ڵ��û�У�Ȼ���������������ϲ����õ��ϳ�����������
 *     3���Ժ�������
 *     4���鲢������������Ϊһ����������
 */
public class SortList {
	@Test
	public void test(){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(4);
		ListNode l7 = new ListNode(8);
		l5.next = l6;
		l6.next = l7;
		//ListNode head = meger(l1,l5);
		ListNode head = sortList(l1);
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
    public ListNode sortList(ListNode head) {
    	if(head==null||head.next==null) return head;
    	ListNode slow=head,fast=head;//����ָ��Ѱ�������е�
    	while(fast.next!=null&&fast.next.next!=null){
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	//��ʱslowָ��ָ��ľ���������е�
    	fast = slow.next;
    	slow.next = null;//�Ͽ��м䣬��Ϊ��������
    	slow=sortList(head);//ǰ�������
    	fast=sortList(fast);//��������
    	return meger(slow,fast);  
    }
	/**
	 * ����һ���ź����ָ��cur����Զָ��h1��h2�н�С��һ����ͬʱ�ƶ�h1(����h2)��cur
	 * @param h1
	 * @param h2
	 * @return
	 */
	public ListNode meger(ListNode h1,ListNode h2){//���ϲ���h1
		if(h1==null) return h2;
		if(h2==null) return h1;
		//ȷ��head
		ListNode head=h1,cur=h1;
		if(h2.val<h1.val){
			head=h2;
			cur=h2;
			h2=h2.next;
		}else{
			h1=h1.next;
		}
		while(h1!=null&&h2!=null){
			if(h1.val<h2.val){
				ListNode h1Nxt=h1.next;
				cur.next=h1;
				h1=h1Nxt;
			}else{
				ListNode h2Nxt=h2.next;
				cur.next=h2;
				h2=h2Nxt;
			}
			cur=cur.next;
		}
		if(h1!=null) cur.next=h1;
		if(h2!=null) cur.next=h2;
		return head;
	}
}
