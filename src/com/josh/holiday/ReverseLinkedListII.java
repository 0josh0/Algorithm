package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺��ת����������m��n���ַ�ת
 * ������1���������� len
 * 		2����λm��nָ��
 * 		3����תm��n����
 *      4������head
 *      5������tail
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
        ListNode h=head,mNode=head,nNode=head,mPre=null,nNxt=null;//�������ȣ���λm��n
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
        while(cur!=nNode){//��תm��n����
        	nxt=cur.next;
        	cur.next = pre;
        	pre = cur;
        	cur=nxt;
        }
        cur.next=pre;
        
        mNode.next=nNxt;//����tail
        if(mPre!=null)mPre.next = nNode;//�������head������head
		return m==1?nNode:head;  		
    }
}
