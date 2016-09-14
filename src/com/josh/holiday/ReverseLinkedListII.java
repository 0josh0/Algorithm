package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：翻转部分链表，从m到n部分翻转
 * 分析：1、求链表长度 len
 * 		2、定位m、n指针
 * 		3、翻转m到n部分
 *      4、连接head
 *      5、连接tail
 */
public class ReverseLinkedListII {
	@Test
	public void test(){
		ListNode l1=new ListNode(1);
		ListNode l2=new ListNode(2);
		ListNode l3=new ListNode(3);
		ListNode l4=new ListNode(4);
		ListNode l5=new ListNode(5);
		
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		l4.next=l5;
		
		reverseBetween(l1,1,4);
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null) return null;
		int len=0;
        ListNode h=head,mNode=head,nNode=head,mPre=null,nNxt=null;//求链表长度，定位m、n
        while(h!=null){
        	len++;
        	if(len+1==m) mPre = h;
        	if(len==m) mNode=h;
        	if(len==n){
        		nNode=h;
        		nNxt = nNode.next;
        	}
        	h=h.next;
        }
        ListNode pre = null,cur=mNode,nxt=mNode.next;
        while(cur!=nNode){//翻转m到n部分
        	nxt=cur.next;
        	cur.next = pre;
        	pre = cur;
        	cur=nxt;
        }
        cur.next=pre;
        
        mNode.next=nNxt;//连接tail
        if(mPre!=null)mPre.next = nNode;//如果存在head，连接head
		return m==1?nNode:head;  		
    }
}
