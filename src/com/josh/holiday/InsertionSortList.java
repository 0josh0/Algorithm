package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：用插入排序进行链表排序
 * 分析：双指针,插入排序的思想
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
			if(tail.next.val>=tail.val){//有序的依次略过，即前面的小于等于后面的节点值
				tail = tail.next;
			}else{//后一个节点比前一个节点小，将该小节点插入到合适的位置
				ListNode node=tail.next;//标记要插入节点
				ListNode start = head;
				while(start!=tail&&start.next.val<=node.val){//从之前已经有序的部分链表中找到要插入节点的位置
					start=start.next;
				}
				if(start==head&&start.val>=node.val){//插到start节点的前面
					tail.next = node.next;
					node.next=start;
					head = node;
				}else{//插到start节点的后面
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
