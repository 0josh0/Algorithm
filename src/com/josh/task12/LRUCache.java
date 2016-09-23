package com.josh.task12;

import java.util.HashMap;
import java.util.Map;

/*
 * ���⣺���캯����ʼ��һ����СΪcapacity��LRUCache������key��get��cache�е�value�����û�оͲ��룬����ﵽcache��capacity��ɾ����ò��õ��Ǹ�Ԫ��
 * ������1��˫�������mapʵ��
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
    			if(tmp.val==key&&tmp==head) break;//key��ͷ�ڵ�
    			if(tmp.val==key){
    				if(tmp.next==null){//key��β�ڵ�
    					tmp.next = head;
    					tmp.pre.next = null;
    				}else{//���м�
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
    			if(tmp.val==key&&tmp==head) break;//key��ͷ�ڵ�
    			if(tmp.val==key){
    				if(tmp.next==null){//key��β�ڵ�
    					tmp.next = head;
    					tmp.pre = head;
    					tmp.pre.next = null;
    				}else{//���м�
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
    		//ɾ�����һ���ڵ�
    		LinkList cur = head;
    		while(cur.next!=null){
    			cur=cur.next;
    		}
    		map.remove(cur.val);
    		cur.pre.next = null;
    	}
    }
}
