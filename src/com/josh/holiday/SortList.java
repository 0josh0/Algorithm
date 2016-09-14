package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：链表排序，要求时间复杂度nlogn，空间复杂度O(1)
 * 分析：归并排序，对链表的操作：
 *     1、寻找中间节点 - 利用快慢指针，快的比慢的快一倍，所以当fast到末尾的时候，slow就是mid
 *     2、对前半段排序 - 递归进行，直到只有一个节点或没有，然后对两个有序链表合并，得到较长的有序链表
 *     3、对后半段排序
 *     4、归并两段有序链表为一个有序链表
 */
public class SortList {
	@Test
	public void test(){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(4);
		ListNode l7 = new ListNode(8);
		l5.next = l6;
		l6.next = l7;
		//ListNode head = meger(l1,l5);
		ListNode head = sortList(l1);
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
    public ListNode sortList(ListNode head) {
    	if(head==null||head.next==null) return head;
    	ListNode slow=head,fast=head;//快慢指针寻找链表中点
    	while(fast.next!=null&&fast.next.next!=null){
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	//此时slow指针指向的就是链表的中点
    	fast = slow.next;
    	slow.next = null;//断开中间，成为两个链表
    	slow=sortList(head);//前半段排序
    	fast=sortList(fast);//后半段排序
    	return meger(slow,fast);  
    }
	/**
	 * 定义一个排好序的指针cur，永远指向h1和h2中较小的一个，同时移动h1(或者h2)和cur
	 * @param h1
	 * @param h2
	 * @return
	 */
	public ListNode meger(ListNode h1,ListNode h2){//都合并到h1
		if(h1==null) return h2;
		if(h2==null) return h1;
		//确定head
		ListNode head=h1,cur=h1;
		if(h2.val<h1.val){
			head=h2;
			cur=h2;
			h2=h2.next;
		}else{
			h1=h1.next;
		}
		while(h1!=null&&h2!=null){
			if(h1.val<h2.val){
				ListNode h1Nxt=h1.next;
				cur.next=h1;
				h1=h1Nxt;
			}else{
				ListNode h2Nxt=h2.next;
				cur.next=h2;
				h2=h2Nxt;
			}
			cur=cur.next;
		}
		if(h1!=null) cur.next=h1;
		if(h2!=null) cur.next=h2;
		return head;
	}
}
