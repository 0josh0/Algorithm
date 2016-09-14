package com.josh.holiday;

import org.junit.Test;

/*
 * 题意: 寻找两个链表的交叉点。如果没有交叉点，返回null。要求时间复杂度O(n)，空间复杂度O(1)
 * 分析: 如果两个链表有交叉点，那么一定有从较长链表的某个节点（较长-较短的位置）开始到末尾的长度两个链表相等
 * 
 */
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA!=null && headB!=null){
			ListNode A = headA,B = headB;
			int aLength = 1,bLength=1;
			while(headA.next!=null){
				aLength++;
				headA = headA.next;
			}
			while(headB.next!=null){
				bLength++;
				headB=headB.next;
			}
			if(aLength>=bLength){
				int l=aLength-bLength;
				while(l>0){
					A=A.next;
					l--;
				}
				while(A!=null){
					if(A.val==B.val && A.next==B.next) return A;
					A=A.next;
					B=B.next;
				}
			}else{
				int l=bLength-aLength;
				while(l>0){
					B=B.next;
					l--;
				}
				while(B!=null){
					if(A.val==B.val && A.next==B.next) return B;
					A=A.next;
					B=B.next;
				}
			}
		}
		return null;
    }
	@Test
	public void test(){
		ListNode headA = new ListNode(1);
		ListNode headB = new ListNode(1);
		
		System.out.println(getIntersectionNode(headA,headB).val);
	}
}
