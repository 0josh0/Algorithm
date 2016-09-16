/**
 * 
 */
package com.josh.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: LRUCache
 * @Description:Design and implement a data structure for Least Recently Used
 *                     (LRU) cache. It should support the following operations:
 *                     get and set. get(key) - Get the value (will always be
 *                     positive) of the key if the key exists in the cache,
 *                     otherwise return -1.set(key, value) - Set or insert the
 *                     value if the key is not already present. When the cache
 *                     reached its capacity, it should invalidate the least
 *                     recently used item before inserting a new item.
 * @author Summer
 * @date 2016年9月2日 下午2:27:29
 * 
 */
public class LRUCache {

	public class Node {
		int key;
		int value;
		Node pre;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	int size;
	int capacity;
	Map<Integer, Node> map;
	Node head;
	Node tail;

	public LRUCache(int capacity) {
		this.size = 0;
		this.capacity = capacity;
		map = new HashMap<Integer, Node>();
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.pre = null;
		head.next = tail;
		tail.pre = head;
		tail.next = null;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			moveToHead(map.get(key));
			return map.get(key).value;
		}
		return -1;
	}

	public void set(int key, int value) {
		Node n = map.get(key);
		if (n == null) {
			n = new Node(key, value);
			if (size < capacity) {
				size++;
			} else {
				deleteLast();
				// map.remove(tail.pre.value);
			}
			map.put(key, n);
			insertToHead(n);
		} else {
			n.value = value;
			moveToHead(n);
		}
	}

	// 插入新节点移动到Head
	public void insertToHead(Node n) {
		Node tmp = head;
		n.pre = tmp;
		n.next = tmp.next;
		tmp.next.pre = n;
		tmp.next = n;
		// head = n;
	}

	// 移动已经存在的节点到Head
	public void moveToHead(Node n) {
		if (n.pre != head) {
			// 连接n的前后节点
			n.pre.next = n.next;
			n.next.pre = n.pre;
			// 插入到head之后
			Node headNext = head.next;
			head.next = n;
			n.pre = head;
			n.next = headNext;
			headNext.pre = n;
		}
	}

	// 删除最后一个节点
	public void deleteLast() {
		Node mid = tail.pre;
		mid.pre.next = tail;
		tail.pre = mid.pre;
		map.remove(mid.key);
		// help GC
		mid.pre = null;
		mid.next = null;
		mid = null;
	}
}
