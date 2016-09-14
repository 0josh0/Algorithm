package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺������������λ�ú�ż��λ�õ�Ԫ�طֱ���ȡ������������ǰ��ż���ں����������Ҫ��ʱ�临�Ӷ�O(n)���ռ临�Ӷȣ�O(1)
 * ����������һ�Σ�����ָ��ָ��
 */
public class OddEvenLinkedList {
	@Test
	public void test(){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		ListNode head = oddEvenList(l1);
		
		while(head.next!=null){
			System.out.println(head.val);
			head = head.next;
		}
		System.out.println(head.val);
	}
	public ListNode oddEvenList(ListNode head) {
		if(head==null||head.next==null||head.next.next==null) return head;
		ListNode odd = head,even=null,evenNext=head.next,evenHead = head.next;
		while(odd.next!=null && odd.next.next!=null){
			odd.next = odd.next.next;//��������λ��Ԫ��
			odd = odd.next;
			even = evenNext;
			if(odd.next!=null){
				evenNext = odd.next;//����ż��λ��Ԫ��
				even.next = evenNext;
			}else{
				even.next = null;//ż��ĩβ��null
			}
		}
		odd.next = evenHead;//��������ż������������������
        return head; 
    }
}
