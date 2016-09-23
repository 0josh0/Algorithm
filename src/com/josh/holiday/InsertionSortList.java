package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺�ò������������������
 * ������˫ָ��,���������˼��
 */
public class InsertionSortList {
	@Test
	public void test(){
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(3);
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		
		insertionSortList(l1);
	}
	public ListNode insertionSortList(ListNode head) {
		if(head==null||head.next==null) return head;
		ListNode tail = head;
		while(tail.next!=null){
			if(tail.next.val>=tail.val){//����������Թ�����ǰ���С�ڵ��ں���Ľڵ�ֵ
				tail = tail.next;
			}else{//��һ���ڵ��ǰһ���ڵ�С������С�ڵ���뵽���ʵ�λ��
				ListNode node=tail.next;//���Ҫ����ڵ�
				ListNode start = head;
				while(start!=tail&&start.next.val<=node.val){//��֮ǰ�Ѿ�����Ĳ����������ҵ�Ҫ����ڵ��λ��
					start=start.next;
				}
				if(start==head&&start.val>=node.val){//�嵽start�ڵ��ǰ��
					tail.next = node.next;
					node.next=start;
					head = node;
				}else{//�嵽start�ڵ�ĺ���
					ListNode startNext = start.next;
					start.next=node;
					tail.next=node.next;
					node.next=startNext;
				}
			}
		}
		return head;
        
    }
}
