package com.josh.interview;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * 题意: 给两个字符串，凡是在第一个中的字符也出现在第二个中的，则在第一个中删除
 * 分析: 把s2中的每个字符都放在set中，然后遍历s1，并检查set中是否有这个字符
 */
public class RemoveSameCharacter {

	@Test
	public void test(){
		char[] c1={'a','b','c','d'};
		char[] c2={'a','b'};
 		System.out.println(removeSame2(c1,c2));
	}
	//用了set标准库的解决方案
	public String removeSame(String s1,String s2){
		Set<Character> set = new HashSet<Character>();
		for(int i=0;i<s2.length();i++){
			set.add(s2.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s1.length();i++){
			if(!set.contains(s1.charAt(i))){
				sb.append(s1.charAt(i));
			}
		}
		return sb.toString();
	}
	//不用标准库的暴力解决方案 O(n2)
	public String removeSame1(String s1,String s2){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				if(s1.charAt(i)==s2.charAt(j)){
					break;
				}else{
					if(j==s2.length()-1){
						sb.append(s1.charAt(i));
					}
				}
			}
		}
		return sb.toString();
	}
	//不用标准库的一般解决方案 O(n)
	public String removeSame2(char[] c1,char[] c2){
		StringBuilder sb = new StringBuilder();
		boolean[] b=new boolean[26];//初始化26个字母位置false
		for(int i=0;i<c2.length;i++){//c2中出现的字符在b中置为true
			int a = 'a'+0;
			int bPos = c2[i]-a;
			if(b[bPos]==false) b[bPos]=true;
		}
		for(int i=0;i<c1.length;i++){
			int a = 'a'+0;
			int bPos = c1[i]-a;
			if(b[bPos]==false) sb.append(c1[i]);
		}
		return sb.toString();
	}
}
