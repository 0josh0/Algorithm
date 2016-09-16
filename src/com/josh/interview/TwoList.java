/**
 * 
 */
package com.josh.interview;

import org.junit.Test;

/**
 * @Title: TwoList
 * @Description:将一个链表按奇偶拆分两个链表
 * @author Summer
 * @date 2016年9月13日 下午4:03:55
 * 
 */
public class TwoList {

	@Test
	public void test() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		tList(n1);
	}

	class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void tList(Node head) {
		if (head == null || head.next == null)
			return;
		Node head2 = head.next;
		Node h1 = head, h2 = head2;
		if (head2.next == null) {
			// h2 = new Node(head2.value);
			head.next = null;
		}
		Node cur = head2.next;
		int count = 3;
		while (cur != null) {
			if (count % 2 == 1) {
				Node tmp = cur;
				head.next = tmp;
				head = tmp;
				cur = cur.next;
			} else {
				Node tmp = cur;
				head2.next = tmp;
				head2 = tmp;
				cur = cur.next;
			}
			count++;
		}
		if (count % 2 == 0) {
			head2.next = null;
		} else {
			head.next = null;
		}

		// 输出两个链表
		while (h1 != null) {
			System.out.print(h1.value + "  ");
			h1 = h1.next;
		}
		System.out.println();
		while (h2 != null) {
			System.out.print(h2.value + "  ");
			h2 = h2.next;
		}
	}
}
