package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：根据给定的节点值删除链表中指定的节点（末尾节点除外）
 * 分析：将要删除的节点变成其下一节点，改变指针指向
 *      更新当前要删除节点值为下一节点的值，再将next指针指向next的next节点。
 */
public class DeleteNodeInLinklist {
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
		
		ListNode curL = l1;
		System.out.println("Before delete ………");
		while(curL.next!=null){
			System.out.print(curL.val+"  ");
			curL=curL.next;
		}
		System.out.println(curL.val);
		
		deleteNode(l3);
		
		curL = l1;
		System.out.println("After delete ………");
		while(curL.next != null){
			System.out.print(curL.val+"  ");
			curL=curL.next;
		}
		System.out.print(curL.val);
	}
    public void deleteNode(ListNode node) {
        if(node.next==null) return;//末尾节点直接返回
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
