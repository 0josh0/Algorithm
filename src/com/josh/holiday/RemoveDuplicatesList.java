package com.josh.holiday;

import org.junit.Test;
/*
 * ���⣺ɾ���������ظ��Ľڵ�
 * ������������ListNode�ֱ��¼�����ڵ��������ͬ�ڵ㣬next������Ծɾ���ظ��ڵ㣬pre���next֮ǰ�Ľڵ�
 */
public class RemoveDuplicatesList {
	@Test
	public void test(){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		ListNode curL = l1;
		System.out.println("Before delete ������");
		while(curL.next!=null){
			System.out.print(curL.val+"  ");
			curL=curL.next;
		}
		System.out.println(curL.val);
		
		curL = deleteDuplicates(l1);;
		System.out.println("After delete ������");
		while(curL.next != null){
			System.out.print(curL.val+"  ");
			curL=curL.next;
		}
		System.out.print(curL.val);
	}
    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null || head.next==null) return head;
    	ListNode pre=head,next = head.next;
    	while(next!=null){
    		while(next!=null && pre.val==next.val){
    			next=next.next;
    		}
    		pre.next=next;
    		if(next==null || next.next==null) break;
    		pre=next;
    		next=next.next;
    	}
		return head;
    }
}
