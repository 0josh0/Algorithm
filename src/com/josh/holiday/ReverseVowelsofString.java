package com.josh.holiday;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * 题意：翻转字符串中所有原因字母：AOEIU
 * 分析：把五个元音字母放入set中,双指针判断
 */
public class ReverseVowelsofString {
	@Test
	public void test(){
		String s="aA";
		System.out.println(reverseVowels(s));
		StringBuilder sb =new StringBuilder(s);
		sb.replace(0, 1, "w");
//		Set<Character> vowelSet = new HashSet<Character>();
//        vowelSet.add('e');
		//System.out.println(sb.toString());
	}
    public String reverseVowels(String s) {
    	if(s==null|s.length()==0) return s;
        Set<Character> vowelSet = new HashSet<Character>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');
        int i=0,j=s.length()-1;
        StringBuilder sb =new StringBuilder(s);
        while(i<s.length()&&j>=0&&i<j){
        	char pi=s.charAt(i),pj=s.charAt(j);
        	if(vowelSet.contains(pi)&&vowelSet.contains(pj)){//交换i、j两个位置的字母
        		//s=s.substring(0,i)+s.charAt(j)+s.substring(i+1,j)+s.charAt(i)+s.substring(j+1,s.length());
        		sb.replace(i, i+1, String.valueOf(pj));
        		sb.replace(j, j+1, String.valueOf(pi));
        		i++;
            	j--;
        	}else{
        		if(!vowelSet.contains(s.charAt(i)))i++;
            	if(!vowelSet.contains(s.charAt(j)))j--;
        	}
        }
    	return sb.toString();
    }
}
