package com.josh.task12;

import java.util.HashMap;
import java.util.Map;

/*
 * 题意：构造函数初始化一个大小为capacity的LRUCache，根据key，get到cache中的value，如果没有就插入，如果达到cache的capacity，删除最久不用的那个元素
 * 分析：1、get O(n)，set O(n), 超时
 */
public class LRUCache2 {
	
	int capacity=0;
	int[] keys;
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	public LRUCache2(int capacity) {
        this.capacity = capacity;
        keys = new int[capacity];
    }
    
    public int get(int key) {
    	if(map.containsKey(key)){
    		if(keys[0]!=key){
    			int i=1;
        		int tmp=keys[0],cur=keys[0];
        		keys[0]=key;
        		while(keys[i]!=key){
        			tmp = keys[i];
        			keys[i] = cur;
        			cur = tmp;
        			i++;
        		}
        		keys[i] = cur;
    		}
    		return map.get(key);
    	}
        return -1;
    }
    
    public void set(int key, int value) {
    	if(!map.containsKey(key)){
    		if(map.size()>=capacity){//超过最大容量，删除key中最后一个元素
    			map.remove(keys[map.size()-1]);//删除map中的key
    		}
    		for(int i=map.size();i>0;i--){
				keys[i] = keys[i-1];
			}
			keys[0] = key;	
    	}
    	map.put(key, value);
    }
}
