package com.josh.task11;

import org.junit.Test;

/*
 * ���⣺�����У�ÿk���ڵ�Ϊһ����з�ת��ʣ��ڵ�������k��������ԭ����k>len,����������ԭ��.
 * ����������˼·������ָ�� pre����ǰָ���ǰһ��ָ�� cur����ǰָ�� h����ǰ��ת�����β��Ҳ�Ƿ�ת֮ǰ��ͷ�����Ժ�������ת��������
 *     ���ȣ��м���������������ó�����1 head=null return null
 *     						   2 k=1 OR k>len return head (������ԭ��)	
 *     Ȼ��
 *     0 ��һ�α�������õ������ȣ�len    
 *     1 k>len OR k=1 return 1
 *     2 ��һ�η�תkλ������len=len-k
 *     3 �ж�len>k�� yes-�����4����ѭ����ת�����飬no-���ӷ�ת���ֺ�ʣ�ಿ�֣�������head
 *     4 ��ת�ڶ��鳤��Ϊk������������ת��Ľ������һ�����������������len = len-k �����3����
 *     ע�⣺
 *     �ѵ�һ�η�ת�����ó�����Ŀ����Ҫ��¼h(��ת֮ǰ��ͷ����ת֮���β)����Ϊ��ѭ����ʱ������ÿһ������Ҫ�õ����
 *     ������һ��Ҳ�൱���ʼ��һ��h��
 *     �ؼ����룺
 *     ListNode pre = null;
 *     ListNode cur = head;
 *     while(cur!=null){
 *     		ListNode temp = cur.next;
 *     		cur.next = pre;
 *     		pre = cur;
 *     		cur = temp;
 *     }
 */
public class ReverseNodesinkGroup {
	@Test
	public void test(){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		ListNode l7 = new ListNode(7);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		ListNode list = reverseKGroup(l1, 2);
		while(list!=null){
			System.out.print(list.val+" ");
			list=list.next;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null) return null;
		if(k==1) return head;
		ListNode lenHead = head;
		int len=0;
		while(lenHead!=null){//����������
			len++;
			lenHead=lenHead.next;
		}
		if(k>len) return head;
		ListNode pre = null;//��һ����ת����
		ListNode cur = head;
		int count=0;
		while(count<k&&cur!=null){
			ListNode temp = cur.next;
			cur.next = pre;
			pre=cur;
			cur=temp;
			count++;
		}
		ListNode h = head;//��ת����������һ��Ԫ��
		len-=k;//����length����
		if(len>=k){//ʣ�೤�Ȼ����Խ�����ת
			while(len>=k){
				ListNode h1 = cur;
				ListNode pre1 = null;//��һ����ת����
				//ListNode cur1 = cur;
				int count1=0;
				while(count1<k&&cur!=null){
					ListNode temp1 = cur.next;
					cur.next = pre1;
					pre1=cur;
					cur=temp1;
					count1++;
				}
				h.next=pre1;
				h=h1;
				len-=k;
			}
		}
		h.next=cur;
		return pre;
    }
}
