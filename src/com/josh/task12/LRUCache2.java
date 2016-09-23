package com.josh.task12;

import java.util.HashMap;
import java.util.Map;

/*
 * ���⣺���캯����ʼ��һ����СΪcapacity��LRUCache������key��get��cache�е�value�����û�оͲ��룬����ﵽcache��capacity��ɾ����ò��õ��Ǹ�Ԫ��
 * ������1��get O(n)��set O(n), ��ʱ
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
    		if(map.size()>=capacity){//�������������ɾ��key�����һ��Ԫ��
    			map.remove(keys[map.size()-1]);//ɾ��map�е�key
    		}
    		for(int i=map.size();i>0;i--){
				keys[i] = keys[i-1];
			}
			keys[0] = key;	
    	}
    	map.put(key, value);
    }
}
