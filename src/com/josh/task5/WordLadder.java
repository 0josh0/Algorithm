package com.josh.task5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;
/*
 * 深度优先搜索，栈存储
 * 
 */
public class WordLadder {
	@Test
	public void test(){
		String b="hit",e="cog";
		Set<String> w = new HashSet<String>();
		w.add("hot");
		w.add("dot");
		w.add("dog");
		w.add("lot");
		w.add("log");
		int t = ladderLength(b,e,w);
		System.out.println(t);
//		String s = hasStr(b,w);
//		System.out.println(s);
	}
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Stack<String> stack = new Stack<String>();
		int minPath = 0;
		stack.push(beginWord);
		boolean flag = true;
		while(flag){
			if(isLike(stack.peek(),endWord)){
				flag = false;
				minPath = stack.size()+1;
				//return stack.size()+1;
			}else if(hasStr(stack.peek(),wordList,stack,"") != null){
				stack.push(hasStr(stack.peek(),wordList,stack,""));
			}else{
				flag = false;
			}
		}
		if(!isLike(stack.peek(),endWord)){//没找到路径跳出循环
			return 0;
		}else{//找到一条路径后跳出循环
			while(!stack.isEmpty() && !stack.peek().equals(beginWord)){//站内出来begin还有其他元素，继续出栈搜索
				stack.pop();
				stack.pop();		
				if(!stack.isEmpty()){
					if(likePeek(stack.peek(),wordList,endWord) != null){
						minPath = stack.size()+2;
					}
				}
			}
			return minPath;
		}
		
    }
	public boolean isLike(String s1,String s2){
		if(s1.length() != s2.length()) return false;
		int count = 0;
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i) != s2.charAt(i)) 
				count++;
		}
		if(count!=1) 
			return false;
		else
			return true;
	}
	public String hasStr(String s,Set<String> set,Stack<String> stack,String pop){
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String str = it.next();
			if(isLike(s,str) && !stack.contains(str) && !str.equals(pop))
				return str;
		}
		return null;
	}
	public String likePeek(String peek,Set<String> set,String endword){
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String str = it.next();
			if(isLike(str,peek) && isLike(str,endword))
				return str;
		}
		return null;
	}
}
