package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺�������б�target valueС�Ľڵ�ȫ���Ƶ�target��ǰ�棬���ƶ��Ľڵ�����λ�ñ��ֲ���
 * ���������ȴ�ͷ��ʼ�ҵ���һ�����ڻ��ߵ���target value�Ľڵ㣬��Ǹýڵ��ǰһ���ڵ㣬Ȼ��ڶ���ָ���ɴ˿�ʼ��������ң�
 * 	         �ѱ�targetС�Ľڵ�ȫ���ӵ���һ��ָ����棬ֱ���ڶ���ָ�뵽��ĩβ
 */
public class PartitionList {
	@Test
	public void test(){
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(1);
		l1.next=l2;
		
		partition(l1,2);
	}
	public ListNode partition(ListNode head, int x) {
		if(head==null||head.next==null) return head;
		ListNode first=head;
		if(first.val>=x){//�����һ���ڵ�ֵ�ʹ��ڵ���x,�ҵ�С��x�Ľڵ㣬��Ϊ��head��������firstָ��Ϊhead
			while(first.next!=null&&first.next.val>=x){
				first=first.next;
			}
			if(first.next==null) return head;
			ListNode node = first.next;
			first.next = first.next.next;
			node.next = head;
			head = node;
			first = head;
		}
		while(first.next!=null&&first.next.val<x){//�ҵ���һ�����ڻ��ߵ���x�Ľڵ㣬firstָ��ָ��ýڵ��ǰһ���ڵ�
			first=first.next;
		}
		if(first.next==null) return head;
		ListNode second=first.next;//secondָ��ӵ�һ�����ڻ��ߵ���x�Ľڵ㿪ʼ���Ѱ��С��x�Ľڵ�
		while(second.next!=null){
			if(second.next.val<x){//����ǰsecond�ڵ�ҵ�first���棬firstָ�����
				ListNode tmp = first.next;
				first.next=second.next;
				first=first.next;
				second.next = second.next.next;
				first.next=tmp;
				
			}else{
				second=second.next;
			}
		}
        return head;
    }
}
