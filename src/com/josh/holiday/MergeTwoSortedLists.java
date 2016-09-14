package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：归并两个有序链表
 * 分析：用两个节点指针分别遍历两个链表，找到拼接节点
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		ListNode head = l1.val<l2.val?l1:l2;
		ListNode pre1 = l1,pre2=l2;
		while(l1!=null && l2!=null){
			if(l1.val<l2.val){ 
				l1 = l1.next;
				while(l1!=null && l1.val<=l2.val){
					pre1 = pre1.next;
					l1 = l1.next;
				}
				pre1.next = l2;
				pre1 = l1;
			}else{
				l2 = l2.next;
				while(l2!=null && l2.val<=l1.val){
					pre2 = pre2.next;
					l2 = l2.next;
				}
				pre2.next = l1;
				pre2 = l2;
			}
		}
        return head;
    }
	@Test
	public void test(){
		ListNode l1 = new ListNode(-9);
		ListNode l3 = new ListNode(-7);
		ListNode l5 = new ListNode(-3);
		ListNode l7 = new ListNode(-3);
		ListNode l9 = new ListNode(-1);
		ListNode l11 = new ListNode(2);
		ListNode l13 = new ListNode(3);
		l1.next = l3;
		l3.next = l5;
		l5.next = l7;
		l7.next = l9;
		l9.next = l11;
		l11.next = l13;
		
		ListNode l2 = new ListNode(-7);
		ListNode l4 = new ListNode(-7);
		ListNode l6 = new ListNode(-6);
		ListNode l8 = new ListNode(-6);
		ListNode l10 = new ListNode(-5);
		ListNode l12 = new ListNode(-3);
		ListNode l14 = new ListNode(2);
		ListNode l16 = new ListNode(4);
		l2.next = l4;
		l4.next = l6;
		l6.next = l8;
		l8.next = l10;
		l10.next = l12;
		l12.next = l14;
		l14.next = l16;
		
		ListNode head = mergeTwoLists(l1,l2);
		
		System.out.println("After merge ………");
		while(head.next != null){
			System.out.print(head.val+"  ");
			head=head.next;
		}
		System.out.print(head.val);
	}
}
