package com.josh.holiday;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

/*
 * ���⣺��һ����n�����ʵĴʵ��һ���׵��ʣ�һ��β���ʣ�ÿ��ֻ�ܸĶ�һ����ĸ���Ҹĺ�ĵ��ʱ����ڴʵ���
 *     ���е��ʳ�����ȣ�ֻ����Сд��ĸ�����begin��end�����·��
 * ����1����ջʵ������ --- ���ַ���ֻ���ҵ�һ��·��
 * ����2���ö���ʵ�ֵĹ��� -- AC ��Ч�ʺܵͰ�
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
			}else{//Ѱ����wordList�й���str���ڵ����е���
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
		    		char c=97;//97����a��122����z
		    		for(int j=97;j<123;j++){//str�ĵ�iλ�ϸ���26����ĸ��֤wordList���Ƿ����
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
				String str = isContain(stack.peek(),wordList);//��wordList���ҵ���ջ��Ԫ��like��Ԫ��
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
    		char c=97;//97����a��122����z
    		for(int j=97;j<123;j++){//str�ĵ�iλ�ϸ���26����ĸ��֤wordList���Ƿ����
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
