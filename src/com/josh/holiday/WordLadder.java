package com.josh.holiday;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

/*
 * 题意：给一个有n个单词的词典和一个首单词，一个尾单词，每次只能改动一个字母，且改后的单词必须在词典中
 *     所有单词长度相等，只包含小写字母，求从begin到end的最短路径
 * 分析1：用栈实现深搜 --- 这种方法只能找到一条路劲
 * 分析2：用队列实现的广搜 -- AC 但效率很低啊
 */
public class WordLadder {
	@Test
	public void test(){
		//String s="aaa";
		Set<String> wordList = new HashSet<String>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dor");
		wordList.add("lot");
		wordList.add("lor");
		int len = ladderLength("hit", "cog", wordList);
		System.out.println(len);
	}
	//BFS
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		if(isLike(beginWord,endWord)) return 2;
		if(beginWord.length()==0||endWord.length()==0||wordList.size()==0) return 0;
		Queue<String> Q = new LinkedList<String>();
		Q.add(beginWord);
		Q.add("");
		int res=1;
		while(!Q.isEmpty()){
			String str=Q.poll();
			if(str.equals("")){
				if(Q.isEmpty()) return 0;
				else{
					Q.add("");
					res++;
				}
			}else{//寻找在wordList中国和str相邻的所有单词
				if(isLike(str,endWord)) return res+1;
				String left,right;
				for(int i=0;i<str.length();i++){
		    		if(i==0){
		    			left="";
		    			right=str.substring(i+1,str.length());
		    		}else if(i==str.length()-1){
		    			left=str.substring(0,str.length()-1);
		    			right="";
		    		}else{
		    			left=str.substring(0,i);
		    			right=str.substring(i+1,str.length());
		    		}
		    		char c=97;//97代表a，122代表z
		    		for(int j=97;j<123;j++){//str的第i位上更换26个字母验证wordList中是否存在
		    			c=(char) j;
		        		if(wordList.contains(left+c+right)){
		        			Q.add(left+c+right);	
		        			wordList.remove(left+c+right);
		        		}
		    		}
		    	}
			}
		}
		return 0;
	}
    public int ladderLength1(String beginWord, String endWord, Set<String> wordList) {
		Stack<String> stack = new Stack<String>();
		stack.push(beginWord);
		int len=0;
		while(!stack.isEmpty()){
			if(isLike(stack.peek(),endWord)){
				return len;
			}else{
				String str = isContain(stack.peek(),wordList);//在wordList中找到和栈顶元素like的元素
				if(str!=null){
					stack.push(str);
					wordList.remove(str);
					len++;
				}else{
					stack.pop();
					len--;
				}
			}
		}
    	return 0;
    }
    public String isContain(String str,Set<String> wordList){
    	String left,right;
    	for(int i=0;i<str.length();i++){
    		if(i==0){
    			left="";
    			right=str.substring(i+1,str.length());
    		}else if(i==str.length()-1){
    			left=str.substring(0,str.length()-1);
    			right="";
    		}else{
    			left=str.substring(0,i);
    			right=str.substring(i+1,str.length());
    		}
    		char c=97;//97代表a，122代表z
    		for(int j=97;j<123;j++){//str的第i位上更换26个字母验证wordList中是否存在
    			c=(char) j;
        		if(wordList.contains(left+c+right)){
        			return left+c+right;	
        		}
    		}
    	}
    	return null;
    }
    public boolean isLike(String str1,String str2){
    	int count=0;
    	for(int i=0;i<str1.length();i++){
    		if(!str1.substring(i,i+1).equals(str2.substring(i,i+1))) count++;
    		if(count>1) return false;
    	}
    	return true;
    }
}
