package com.josh.task10;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

/*
 * ����: ��һ��String s���ֵ䣬�ж����s�ܷ񱻿ո��зֳ��ֵ��еĴ�
 * ����: ��һ��boolean�����¼��ֹ��iλ�õ�ʱ����ַ����ܷ���ȷ�з֣���ôb[i]�����������ַ�i��β���ַ�����֮ǰλ�õ�b[j]Ϊtrue
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
	//��ʱ��������
	public boolean wordBreak1(String s, Set<String> wordDict) {
		int i=0,j=i+1;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0);
		while(j<=s.length()){//��һ�����ֵ��еĵ���
			if(wordDict.contains(s.substring(i,j))){
				stack.push(j);//�����ҵ���word�����һ��λ���±�(+1)����stack
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
				while(jj<=s.length()){//��һ�����ֵ��еĵ���
					if(wordDict.contains(s.substring(ii,jj))){
						stack.push(jj);//�����ҵ���word�����һ��λ���±�(+1)����stack
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
