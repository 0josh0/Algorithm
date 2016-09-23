package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺ɾ�������������ظ����ֵĽڵ㡣e.g. 1-3-3-4-5 res 1-4-5
 * ������˫ָ��
 * 	        �м��������1����ͷ��ʼ�����ظ��Ľڵ�
 *              2��ĩβ���ظ��ڵ�
 *              3�����������ظ��ڵ�  -3-3-4-4-
 *     1�����ԣ�����Ѱ��Ψһ��ͷָ��head����left��ʼ��������
 *     ������left=null����ʾȫ�����ظ��ģ�����null������ȷ��ͷָ��head=left
 *     2��Ȼ���ʼ����ָ��right=head.next����left.next��
 *     ��ָ�뿪ʼѰ���ظ��ڵ㣬rightָ�Ľڵ���Ψһ�ڵ㣬left��rightͬʱ����ƶ�
 *     ���rightָ������ظ��ڵ㣬right����ƶ���ֱ��ָ���ظ��Ľڵ�
 *     3��Ȼ��left���ӵ�ǰright��������left=right��right=right.next
 *     4���ص�2��right����Ѱ���ظ��ڵ㣬ֱ������ĩβ
 *     
 */
public class RemoveDuplicatesfromSortedListII {
	@Test
	public void test(){
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(2);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		deleteDuplicates(l1);
	}
    public ListNode deleteDuplicates(ListNode head) {
    	if(head==null||head.next==null) return head;
    	ListNode left=head;
    	while(left!=null&&left.next!=null&&left.val==left.next.val){//�ж�ͷ�ڵ��Ƿ����ظ����
    		while(left!=null&&left.next!=null&&left.val==left.next.val){
    			left=left.next;
    		}
    		left=left.next;
    	}
    	head=left;
    	if(head!=null){
    		ListNode right=head.next;
        	while(right!=null){
        		if(right.next!=null&&right.val==right.next.val){//�����ظ��ڵ�
        			while(right.next!=null&&right.val==right.next.val){
            			right=right.next;
            		}
        			right=right.next;
        		}else{
        			left.next=right;
        			left=right;
            		right=right.next;
        		}	
        	}
        	left.next=null;
    	}
        return head;
    }
}
