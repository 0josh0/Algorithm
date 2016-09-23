package com.josh.task4;

import org.junit.Test;

public class MergeSortedLists {
	@Test
	public void test(){
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = null;
		
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(6);
		l4.next = l5;
		l5.next = l6;
		l6.next = null;
		
		ListNode l7 = new ListNode(7);
		ListNode l8 = new ListNode(8);
		ListNode l9 = new ListNode(9);
		l7.next = l8;
		l8.next = l9;
		l9.next = null;
		
		ListNode[] lists = {l1,l4,l7};
		ListNode res = mergeKLists(lists);
		if(res.equals(null)){
			System.out.println("null");
		}else {
			while(res.next != null){
				System.out.println(res.val);
				res = res.next;
			}
			System.out.println(res.val);
		}
		
//		ListNode l = mergeTwoList(l1, l4);
//		while(l.next != null){
//			System.out.println(l.val);
//			l = l.next;
//		}
//		System.out.println(l.val);
	}
	
    public ListNode mergeKLists(ListNode[] lists) {
		ListNode res = new ListNode(-1);
		if(lists.length == 0) return res;
		if(lists.length == 1) return lists[0];
		res = mergeTwoList(lists[0],lists[1]);
		for(int i=2;i<lists.length;i++){
			res = mergeTwoList(res,lists[i]);
		}
    	return res;
    }
    public ListNode mergeTwoList(ListNode h1,ListNode h2){
        ListNode hn = new ListNode(-1);
        ListNode c = hn;        
        while (h1 != null && h2 != null ){
            if (h1.val <= h2.val){
                c.next = h1;
                h1 = h1.next;
            }else {
                c.next = h2;
                h2 = h2.next;
            }
            c = c.next;
        }
        if(h1 == null){
            c.next = h2;
        }else{
            c.next = h1;
        }
        return hn.next;
    }
}
