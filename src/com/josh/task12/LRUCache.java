package com.josh.task12;

import java.util.HashMap;
import java.util.Map;

/*
 * 题意：构造函数初始化一个大小为capacity的LRUCache，根据key，get到cache中的value，如果没有就插入，如果达到cache的capacity，删除最久不用的那个元素
 * 分析：1、双向链表和map实现
 */
public class LRUCache {
	
	class LinkList{
		int val=0;
		LinkList pre=null;
		LinkList next=null;
		public LinkList(int v){
			val = v;
		}
	}
	int capacity=0;
	LinkList head = null;
	
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	if(map.containsKey(key)){
    		LinkList tmp = head;
    		while(tmp!=null){
    			if(tmp.val==key&&tmp==head) break;//key是头节点
    			if(tmp.val==key){
    				if(tmp.next==null){//key是尾节点
    					tmp.next = head;
    					tmp.pre.next = null;
    				}else{//在中间
    					tmp.pre.next = tmp.next;
        				tmp.next.pre = tmp.pre;
        				tmp.next = head;
    				}
    				tmp.pre = null;
    				head.pre=tmp;
    				head = tmp;
    				break;
    			}
    			tmp=tmp.next;
    		}
    		return map.get(key);
    	}
        return -1;
    }
    
    public void set(int key, int value) {
    	if(map.containsKey(key)){
    		LinkList tmp = head;
    		while(tmp!=null){
    			if(tmp.val==key&&tmp==head) break;//key是头节点
    			if(tmp.val==key){
    				if(tmp.next==null){//key是尾节点
    					tmp.next = head;
    					tmp.pre = head;
    					tmp.pre.next = null;
    				}else{//在中间
    					tmp.pre.next = tmp.next;
        				tmp.next.pre = tmp.pre;
        				tmp.next = head;
        				tmp.pre = null;
    				}
    				head.pre=tmp;
    				head = tmp;
    				break;
    			}
    			tmp=tmp.next;
    		}
    	}else{
    		LinkList node = new LinkList(key);
    		if(head!=null){
    			node.next = head;
        		head.pre = node;
    		}
    		head = node;
    	}
    	map.put(key, value);
    	if(map.size()>capacity){
    		//删除最后一个节点
    		LinkList cur = head;
    		while(cur.next!=null){
    			cur=cur.next;
    		}
    		map.remove(cur.val);
    		cur.pre.next = null;
    	}
    }
}
