package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺��תLinklist
 * ������������������¶���һ����ͬ���ȵ�list���ռ临�Ӷ�O(n)
 *      �������ڵ�ֱ��ǵ�ǰ�ڵ����һ���ڵ㣬�ı�ڵ�ָ��ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(1)
 *      ����ָ�룺curNode����ǰָ�룬�����������ָ��
 *              head����ǰͷָ�룬����������
 *              preNode��head�ڵ��ǰ�ڵ㣬������head֮ǰ�Ľڵ�
 *              �����ڵ�˳��pre-head-cur
 *              whileѭ�����ĸ����ܣ�����Ϊ�ı�����ָ��λ�ã�����һ���Ƿ�����������
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
