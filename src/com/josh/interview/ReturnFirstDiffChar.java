package com.josh.interview;

import org.junit.Test;

/*
 * 题意: 返回第一个不重复出现的字符
 * 分析: 第一次遍历记录每个字符出现的次数，第二次遍历寻找出现次数为1的第一个字符
 */
public class ReturnFirstDiffChar {
	@Test
	public void test(){
		System.out.println(retrueChar("abbbccdefafgg"));
	}
	public char retrueChar(String s){
		char c = s.charAt(0);
		int[] b = new int[26];//记录每个字符出现的次数
		for(int i=0;i<s.length();i++){
			b[s.charAt(i)-'a']++;
		}
		for(int i=0;i<s.length();i++){
			if(b[s.charAt(i)-'a']==1) 
				return  s.charAt(i);
		}
		return c;
	}
}
