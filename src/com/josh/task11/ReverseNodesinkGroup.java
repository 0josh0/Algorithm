package com.josh.task11;

import org.junit.Test;

/*
 * 题意：链表中，每k个节点为一组进行翻转，剩余节点数不足k个，保持原序。若k>len,整个链表保持原序.
 * 分析：整体思路：三个指针 pre：当前指针的前一个指针 cur：当前指针 h：当前翻转链表的尾，也是翻转之前的头，用以和其他翻转部分连接
 *     首先，有几种特殊情况单独拿出来：1 head=null return null
 *     						   2 k=1 OR k>len return head (链表保持原序)	
 *     然后，
 *     0 第一次遍历链表得到链表长度：len    
 *     1 k>len OR k=1 return 1
 *     2 第一次翻转k位，更新len=len-k
 *     3 判断len>k？ yes-进入第4步，循环旋转其他组，no-连接翻转部分和剩余部分，并返回head
 *     4 翻转第二组长度为k的链表，并将翻转后的结果和上一结果连接起来，更新len = len-k 进入第3步；
 *     注意：
 *     把第一次翻转单独拿出来的目的是要记录h(翻转之前的头，翻转之后的尾)，因为在循环的时候，连接每一部分需要用到这个
 *     所以这一步也相当与初始化一个h。
 *     关键代码：
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
		while(lenHead!=null){//计算链表长度
			len++;
			lenHead=lenHead.next;
		}
		if(k>len) return head;
		ListNode pre = null;//第一次旋转链表
		ListNode cur = head;
		int count=0;
		while(count<k&&cur!=null){
			ListNode temp = cur.next;
			cur.next = pre;
			pre=cur;
			cur=temp;
			count++;
		}
		ListNode h = head;//旋转后的链表最后一个元素
		len-=k;//更新length长度
		if(len>=k){//剩余长度还可以进行旋转
			while(len>=k){
				ListNode h1 = cur;
				ListNode pre1 = null;//第一次旋转链表
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
