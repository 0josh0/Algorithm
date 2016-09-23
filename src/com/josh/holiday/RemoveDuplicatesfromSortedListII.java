package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：删除有序链表中重复出现的节点。e.g. 1-3-3-4-5 res 1-4-5
 * 分析：双指针
 * 	        有几种情况：1）从头开始就有重复的节点
 *              2）末尾是重复节点
 *              3）连续出现重复节点  -3-3-4-4-
 *     1、所以，首先寻找唯一的头指针head，从left开始遍历链表；
 *     如果最后left=null，表示全部是重复的，返回null，否则确定头指针head=left
 *     2、然后初始化有指针right=head.next（即left.next）
 *     右指针开始寻找重复节点，right指的节点是唯一节点，left和right同时向后移动
 *     如果right指向的是重复节点，right向后移动，直到指向不重复的节点
 *     3、然后left连接当前right，并更新left=right，right=right.next
 *     4、回到2，right继续寻找重复节点，直到链表末尾
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
    	while(left!=null&&left.next!=null&&left.val==left.next.val){//判断头节点是否有重复情况
    		while(left!=null&&left.next!=null&&left.val==left.next.val){
    			left=left.next;
    		}
    		left=left.next;
    	}
    	head=left;
    	if(head!=null){
    		ListNode right=head.next;
        	while(right!=null){
        		if(right.next!=null&&right.val==right.next.val){//遇到重复节点
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
