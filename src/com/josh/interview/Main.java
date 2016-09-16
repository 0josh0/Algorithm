/**
 * 
 */
package com.josh.interview;

/**
 * @Title: Main
 * @Description:TODO
 * @author Summer
 * @date 2016年9月2日 下午3:38:19
 * 
 */
public class Main {

	/**
	 * @Title:main
	 * @Description:TODO
	 * @param args
	 * @Author:Summer
	 * @Date:2016年9月2日 3,[set(1,1),set(2,2),set(3,3),set(4,4),get(4),get(3),get(
	 *                 2),get(1),set(5,5),get(1),get(2),get(3),get(4),get(5)]
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		// l.set(1, 5);
		// l.set(1, 2);
		System.out.println(l.get(2));
		// l.set(4, 1);
		System.out.println(l.get(3));
		// l.set(1, 5);
		// l.set(1, 2);
		System.out.println(l.get(4));
		System.out.println(l.get(5));
	}

}
