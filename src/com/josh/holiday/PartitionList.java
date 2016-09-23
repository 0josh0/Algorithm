package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：将链表中比target value小的节点全部移到target的前面，且移动的节点的相对位置保持不变
 * 分析：首先从头开始找到第一个大于或者等于target value的节点，标记该节点的前一个节点，然后第二个指针由此开始继续想后找，
 * 	         把比target小的节点全部接到第一个指针后面，直到第二个指针到达末尾
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
		if(first.val>=x){//如果第一个节点值就大于等于x,找到小于x的节点，作为新head，并更新first指针为head
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
		while(first.next!=null&&first.next.val<x){//找到第一个大于或者等于x的节点，first指针指向该节点的前一个节点
			first=first.next;
		}
		if(first.next==null) return head;
		ListNode second=first.next;//second指针从第一个大于或者等于x的节点开始向后寻找小于x的节点
		while(second.next!=null){
			if(second.next.val<x){//将当前second节点挂到first后面，first指针后移
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
