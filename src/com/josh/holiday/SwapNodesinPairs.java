package com.josh.holiday;

import org.junit.Test;

/*
 * 题意: 交换linkedList每相邻的两个节点，返回表头
 * 分析: 四个指针
 */
public class SwapNodesinPairs {
	@Test
	public void test(){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		ListNode list = swapPairs(l1);
		while(list!=null){
			System.out.print(list.val+" ");
			list=list.next;
		}
	}
	public ListNode swapPairs(ListNode head) {
		if(head==null||head.next==null) return head;
		ListNode h = head.next;
		ListNode pre = head;
		ListNode cur = head.next;
		ListNode next = null;
		ListNode tail = null;
		while(pre!=null&&cur!=null){
			next=cur.next;
			cur.next = pre;
			tail = pre;
			pre = next;
			if(pre!=null){
				cur = pre.next;
				if(cur==null){
					tail.next=pre;
					return h;
				}else{
					tail.next=cur;
				}
			}
		}
		tail.next=null;
		return h;
    }
}
