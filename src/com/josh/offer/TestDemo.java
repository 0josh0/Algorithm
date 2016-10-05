package com.josh.offer;

import org.junit.Test;

public class TestDemo {

	@Test
	public void test(){
		StackQueue sq = new StackQueue();
		sq.inqueue(1);
		sq.inqueue(2);
		sq.inqueue(3);
		
		System.out.println(sq.dequeue());
		
		sq.inqueue(4);
		sq.inqueue(5);
		
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
	}
}
