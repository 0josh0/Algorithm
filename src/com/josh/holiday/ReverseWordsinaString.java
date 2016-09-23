package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：翻转一个String字符串句子 e.g. Given s = "the sky is blue",
 * 							    return "blue is sky the".
 * 分析：用一个StringBuilder记录新结果，用一个StringBuilder记录单词
 *      从后向前遍历s，时间复杂度O(n),空间复杂度O(n)
 */
public class ReverseWordsinaString {
	@Test
	public void test(){
		String s="  the sky is blue  ";
		System.out.println(reverseWords(s));
	}
    public String reverseWords(String s) {
        if(s.length()==0||s==null) return s;
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
        	StringBuilder word = new StringBuilder();
        	while(i>=0&&!s.substring(i,i+1).equals(" ")){
        		word.insert(0,s.substring(i,i+1));
        		i--;
        	}
        	if(word.length()!=0){
        		sb.append(word+" ");
        	}
        }
        if(sb.length()!=0) sb.delete(sb.length()-1, sb.length());
        return sb.toString();
    }
}
