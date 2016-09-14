package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：把链表中奇数位置和偶数位置的元素分别提取出来，奇数在前，偶数在后，组成新链表。要求：时间复杂度O(n)，空间复杂度：O(1)
 * 分析：遍历一次，更改指针指向
 */
public class OddEvenLinkedList {
	@Test
	public void test(){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		ListNode head = oddEvenList(l1);
		
		while(head.next!=null){
			System.out.println(head.val);
			head = head.next;
		}
		System.out.println(head.val);
	}
	public ListNode oddEvenList(ListNode head) {
		if(head==null||head.next==null||head.next.next==null) return head;
		ListNode odd = head,even=null,evenNext=head.next,evenHead = head.next;
		while(odd.next!=null && odd.next.next!=null){
			odd.next = odd.next.next;//连接奇数位置元素
			odd = odd.next;
			even = evenNext;
			if(odd.next!=null){
				evenNext = odd.next;//连接偶数位置元素
				even.next = evenNext;
			}else{
				even.next = null;//偶数末尾置null
			}
		}
		odd.next = evenHead;//将奇数和偶数两个链表连接起来
        return head; 
    }
}
