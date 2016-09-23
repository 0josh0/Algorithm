package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺�ж�һ�������Ƿ���ڻ����粻���ڣ�return null�������return���Ŀ�ʼ�ڵ�
 * �����������ÿ���ָ���ҵ��������Ƿ���ڻ����粻���ڣ�ֱ�ӷ���null;����ڣ�������һ����
 * 	        ���ڻ�����¼����һ���ڵ㣬������ָ�������Ľڵ㣬Ȼ������ͱ�ɡ���һ����head��ʼ��һ���������ڵ��next�ڵ㿪ʼ�������н���������Ľ��㡱
 *     �󽻵㣬����Ҫ֪����������ĳ��ȣ����ԣ���һ��������������ĳ���(�����������������ڵ��β)len1��len2
 *     �ڶ������ӽϳ�����ʼ����ƶ�ָ�룬ֱ���������������
 *     ������������ָ��ͬʱ����ƶ���������ͬ�ڵ㼴Ϊ��ʼ���㡣
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
        while(fast!=null&&fast.next!=null){//Ѱ���Ƿ��л�
        	if(slow==fast){
        		sfMeetNode=slow;//�ҵ�����һ�㣬����ָ�������Ľڵ�
        		break;
        	}
        	//tail = slow;
        	slow=slow.next;
        	fast=fast.next.next;
        }
        if(slow==fast){//˵�������ˣ����ڻ�
        	int len1=1;
            ListNode l1 = head;
            while(l1!=sfMeetNode){//���㡰���������ĳ���
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
            if(len1>len2){//�ƶ��ϳ�����ָ�롣ʹ�������߳������
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
            while(h1!=h2&&count<len2){//Ѱ�ҽ��㣬count�����ã��������������һ�����Ļ�����֤��������ѭ��������head
            	h1=h1.next;
            	h2=h2.next;
            	count++;
            }
            return count>len2?head:h1;
        }
		return null;
    }
}
