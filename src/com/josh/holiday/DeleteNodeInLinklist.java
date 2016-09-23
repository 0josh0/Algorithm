package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺���ݸ����Ľڵ�ֵɾ��������ָ���Ľڵ㣨ĩβ�ڵ���⣩
 * ��������Ҫɾ���Ľڵ�������һ�ڵ㣬�ı�ָ��ָ��
 *      ���µ�ǰҪɾ���ڵ�ֵΪ��һ�ڵ��ֵ���ٽ�nextָ��ָ��next��next�ڵ㡣
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
		System.out.println("Before delete ������");
		while(curL.next!=null){
			System.out.print(curL.val+"  ");
			curL=curL.next;
		}
		System.out.println(curL.val);
		
		deleteNode(l3);
		
		curL = l1;
		System.out.println("After delete ������");
		while(curL.next != null){
			System.out.print(curL.val+"  ");
			curL=curL.next;
		}
		System.out.print(curL.val);
	}
    public void deleteNode(ListNode node) {
        if(node.next==null) return;//ĩβ�ڵ�ֱ�ӷ���
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
