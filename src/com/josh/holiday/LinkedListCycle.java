package com.josh.holiday;

import org.junit.Test;

/*
 * ����: �ж�һ��linedList�Ƿ��л�.Ҫ�󣺳����ռ临�Ӷ�
 * ����: ����ָ�룬һ��ָ����ʼλ�ã�һ�������������λ�ã����ܷ񵽴���ʵλ�ã������ж� -- �˷�����ʱ
 * 		����ָ�룬һ����ָ��һ����ָ�룬ÿ�ο����������������һ��������������null��˵��û�л��������ĺ�����������˵���л���
 * 		ע��Ϊʲô��ĺ��������л��������һ������������Ϊ������ָ����뻷�󣬿���1������ٶ�����������������һ��������
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
	//��ʱ ʱ�临�Ӷ�O(n2)
	public boolean hasCycle1(ListNode head) {
        if(head==null) return false;
        ListNode end=head.next;
        if(head==end) return true;
        while(end!=null){//�ж�start���Ƿ񹹳ɻ�
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
