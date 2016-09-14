package com.josh.holiday;

import org.junit.Test;

/*
 * ����: Ѱ����������Ľ���㡣���û�н���㣬����null��Ҫ��ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
 * ����: ������������н���㣬��ôһ���дӽϳ������ĳ���ڵ㣨�ϳ�-�϶̵�λ�ã���ʼ��ĩβ�ĳ��������������
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
