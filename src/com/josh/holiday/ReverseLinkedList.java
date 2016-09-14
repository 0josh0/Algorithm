package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：翻转Linklist
 * 分析：最简单做法，重新定义一个相同长度的list。空间复杂度O(n)
 *      用两个节点分别标记当前节点和上一个节点，改变节点指向。时间复杂度O(n),空间复杂度O(1)
 *      三个指针：curNode：当前指针，负责遍历链表指针
 *              head：当前头指针，负责反向链接
 *              preNode：head节点的前节点，负责标记head之前的节点
 *              三个节点顺序：pre-head-cur
 *              while循环里四个功能：三个为改变三个指针位置，还有一个是反向链接链表。
 */
public class ReverseLinkedList {
	@Test
	public void test(){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = null;
		
		ListNode head = reverseList(l1);
		
		while(head.next!=null){
			System.out.println(head.val);
			head = head.next;
		}
		System.out.println(head.val);
	}
	public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode preNode = null,curNode = head;
        while(curNode.next!=null){
        	curNode = curNode.next;
        	head.next = preNode;
        	preNode = head;
        	head = curNode;
        }
        head.next = preNode;
		return head;  
    }
}
