package com.josh.holiday;

import java.util.Iterator;

/*
 * 题意：给定一个迭代器类接口，包含方法: next()和hasNext()，设计并实现一个PeekingIterator支持peek()操作
 *  -- 其本质就是把原本应由next()方法返回的元素peek()出来。
 *  这里有一个例子。假设迭代器初始化为list：[1, 2, 3]。
 *  调用next()得到1，列表的第一个元素。
 *  现在调用peek()然后返回2，下一个元素。在此之后调用next()仍然返回2。
 *  最后一次调用next()返回3，末尾元素。此后调用hasNext()应该返回false。
 *  
 *  分析：next相当于一个指针，指向当前list中的第一个元素
 *  	实际就是为原来的迭代器添加了一个peek方法，那么需要用一个缓存来记录next()指向的元素，
 *  	如果在next()再次执行之前执行peek，直接return缓存数据即可
 *  	如果在next()再次执行之后执行peek，那么在执行next的时候要更新缓存
 */
public class PeekingIterator implements Iterator<Integer>{

	Iterator<Integer> iterator; //迭代器
	Integer peekElement = null;//缓存next指针移动的时候原来指向的Element
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	    this.peekElement = iterator.next();
	}
	
	public Integer peek() {
		return peekElement;
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return iterator.hasNext()||peekElement!=null;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		Integer res = peekElement;
		peekElement = iterator.hasNext()?iterator.next():null;
		return res;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
