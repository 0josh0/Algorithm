package com.josh.task12;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] nums = {0,9,5,7,3};
//		 NumArray numArray = new NumArray(nums);
//		 System.out.println(numArray.sumRange(4,4));
//		 System.out.println(numArray.sumRange(2,4));
//		 System.out.println(numArray.sumRange(3,3));
//		 numArray.update(4,5);
//		 numArray.update(1,7);
//		 numArray.update(0,8);
//		 numArray.sumRange(1,2);
//		 numArray.update(1,9);
//		 numArray.sumRange(4,4);
//		 numArray.update(3,4);
		 
		 LRUCache l = new LRUCache(3);
		 l.set(1, 1);
		 l.set(2, 2);
		 l.set(3, 3);
		 l.set(4, 4);
		 System.out.println(l.get(4));
		 System.out.println(l.get(3));
		 System.out.println(l.get(2));
		 System.out.println(l.get(1));
		 l.set(5, 5);
		 System.out.println(l.get(1));
		 System.out.println(l.get(2));
		 System.out.println(l.get(3));
		 System.out.println(l.get(4));
		 System.out.println(l.get(5));

//		 3,[set(1,1),set(2,2),set(3,3),set(4,4),get(4),get(3),get(2),get(1),set(5,5),get(1),get(2),get(3),get(4),get(5)]
		 
	}

}
