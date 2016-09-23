package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：判断一个链表是否存在环，如不存在，return null，如存在return环的开始节点
 * 分析：首先用快慢指针找到链表中是否存在环，如不存在，直接返回null;如存在，进行下一步；
 * 	        存在环，记录换上一个节点，即快慢指针相遇的节点，然后问题就变成“求：一个从head开始，一个从相遇节点的next节点开始的两个有交点的链表，的交点”
 *     求交点，首相要知道两个链表的长度，所以，第一步：求两个链表的长度(两个链表都是以相遇节点结尾)len1和len2
 *     第二步：从较长链表开始向后移动指针，直到两个链表长度相等
 *     第三步：两个指针同时向后移动，遇到相同节点即为开始交点。
 */
public class LinkedListCycleII {
	@Test
	public void tes(){
		//[-1,-7,7,-4,19,6,-9,-5,-2,-5]
		//[3,2,0,-4]
		ListNode l1=new ListNode(3);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(0);
		ListNode l4=new ListNode(-4);
		
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l2;
		
		System.out.println(detectCycle(l1)==null?-1:detectCycle(l1).val);
	}
	
	public ListNode detectCycle(ListNode head) {
		if(head==null||head.next==null) return null;
        ListNode slow=head,fast=head.next,sfMeetNode=null;
        while(fast!=null&&fast.next!=null){//寻找是否有环
        	if(slow==fast){
        		sfMeetNode=slow;//找到环上一点，快慢指针相遇的节点
        		break;
        	}
        	//tail = slow;
        	slow=slow.next;
        	fast=fast.next.next;
        }
        if(slow==fast){//说明相遇了，存在环
        	int len1=1;
            ListNode l1 = head;
            while(l1!=sfMeetNode){//计算“两个链表”的长度
            	l1=l1.next;
            	len1++;
            }
            ListNode l2=sfMeetNode.next;
            int len2=1;
            while(l2!=sfMeetNode){
            	l2=l2.next;
            	len2++;
            }
            ListNode h1 = head,h2=sfMeetNode.next;
            if(len1>len2){//移动较长链表指针。使两个两边长度相等
            	while(len1!=len2){
            		h1=h1.next;
            		len1--;
            	}
            }
            if(len1<len2){
            	while(len1!=len2){
            		h2=h2.next;
            		len2--;
            	}
            }
            int count =0;
            while(h1!=h2&&count<len2){//寻找交点，count的作用：如果整个链表是一个环的话，保证可以跳出循环，返回head
            	h1=h1.next;
            	h2=h2.next;
            	count++;
            }
            return count>len2?head:h1;
        }
		return null;
    }
}
