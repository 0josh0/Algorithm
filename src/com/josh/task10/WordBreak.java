package com.josh.task10;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

/*
 * 题意: 给一个String s和字典，判断这个s能否被空格切分成字典中的词
 * 分析: 用一个boolean数组记录截止到i位置的时候该字符串能否被正确切分，那么b[i]等于所有以字符i结尾的字符串和之前位置的b[j]为true
 */
public class WordBreak {
	@Test
	public void test(){
		String s="aaaaaaa";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("aaaaa");
		wordDict.add("aa");
		System.out.println(wordBreak(s,wordDict));
	}
	public boolean wordBreak(String s, Set<String> wordDict) {
		if(s==null|s.length()==0) return true;
		boolean[] b = new boolean[s.length()];
		b[0] = wordDict.contains(s.substring(0,1));
		for(int i=1;i<s.length();i++){
			if(wordDict.contains(s.substring(0,i+1))){
				b[i]=true;
			}else{
				for(int j=1;j<=i;j++){
					//String ss = s.substring(j,i+1);
					if(b[j-1]&&wordDict.contains(s.substring(j,i+1))){
						b[i]=true;
						break;
					}
				}
			}
		}
		return b[s.length()-1];
	}
	//超时。。。。
	public boolean wordBreak1(String s, Set<String> wordDict) {
		int i=0,j=i+1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		while(j<=s.length()){//第一次找字典中的单词
			if(wordDict.contains(s.substring(i,j))){
				stack.push(j);//将查找到的word的最后一个位置下标(+1)存入stack
				i=j;
				j=i+1;
			}else{
				j++;
			}
		}
		if(stack.peek()==0) return false;
		else if(stack.peek()==s.length())return true;
		else{
			while(!stack.isEmpty()){
				int index = stack.pop();
				int ii=stack.peek(),jj=index+1;
				while(jj<=s.length()){//第一次找字典中的单词
					if(wordDict.contains(s.substring(ii,jj))){
						stack.push(jj);//将查找到的word的最后一个位置下标(+1)存入stack
						ii=jj;
						jj=ii+1;
					}else{
						jj++;
					}
				}
				if(stack.peek()==0) return false;
				else if(stack.peek()==s.length())return true;
			}
		}
		return false;
    }
}
