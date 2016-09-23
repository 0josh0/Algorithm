package com.josh.holiday;

import org.junit.Test;

/*
 * 题意: 判断一个linedList是否有环.要求：常量空间复杂度
 * 分析: 两个指针，一个指向起始位置，一个遍历，到最后位置，看能否到达其实位置，依次判断 -- 此方法超时
 * 		两个指针，一个快指针一个慢指针，每次快的走两步，慢的走一步，如果快的碰到null，说明没有环，如果快的和慢的相遇，说明有环。
 * 		注：为什么快的和漫的在有环的情况下一定会相遇，因为，两个指针进入环后，快以1的相对速度在向慢靠近，所以一定会相遇
 */
public class LinkedListCycle {
	@Test
	public void tes(){
		ListNode l1=new ListNode(3);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(0);
		ListNode l4=new ListNode(-4);
		
		l1.next=l1;
		l2.next=l3;
		l3.next=l4;
		l4.next=l4;
		
		System.out.println(hasCycle(l1));
	}
	public boolean hasCycle(ListNode head) {
		if(head==null||head.next==null) return false;
		ListNode tail = head.next.next;
		while(tail!=null&&tail.next!=null){
			if(tail==head) return true;
			head=head.next;
			tail=tail.next.next;
		}
		return false;
	}
	//超时 时间复杂度O(n2)
	public boolean hasCycle1(ListNode head) {
        if(head==null) return false;
        ListNode end=head.next;
        if(head==end) return true;
        while(end!=null){//判断start出是否构成环
        	if(end==end.next) return true;
        	ListNode start=head;
        	while(end.next!=null&&start!=end){
        		if(start.val==end.next.val&&start.next==end.next.next) 
            		return true;
        		start=start.next;
        	}
            end=end.next;
        }
		return false;
    }
}
