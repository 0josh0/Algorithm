package com.josh.interview;

import org.junit.Test;

/*
 * 题意: 求解两个字符串的最长公共子序列
 * 分析: 动态规划，递归求解。(m,n分别为当前字符串的最后一个字符)
 *      两个字符串X和Y，若Xm=Yn，则最长公共子序列maxSub=(Xm-1，Yn-1)+1//递归调用
 *      			 若Xm！=Yn，则最长公共 子序列maxSub=Max((Xm-1,Yn),(Xm,Yn-1))
 */
public class MaxSubString {

	public String getMaxSubString(String s1,String s2){
		String maxSub="";
		maxLen(s1,s2,s1.length(),s2.length() ,maxSub);
		return s1;
	}
	@Test
	public void test(){
		String maxSub="";
		System.out.println(maxLen("BDCABA", "ABCBDAB", 5, 6,maxSub));
	}
	//返回最大子序列长度
	public int maxLen(String s1,String s2,int m,int n){
		if(m==0||n==0){
			if(s1.charAt(m)==s2.charAt(n)) return 1;
			else return 0;
		}else{
			if(s1.charAt(m)==s2.charAt(n)) return maxLen(s1, s2, m-1, n-1)+1;
			else return Math.max(maxLen(s1, s2, m-1, n),maxLen(s1, s2, m, n-1));
		}
	}
	//返回最大子序列
	public String maxLen(String s1,String s2,int m,int n,String maxSub){
		if(m==0||n==0){
			if(s1.charAt(m)==s2.charAt(n)) return maxSub=s1.charAt(m)+maxSub;
			else return maxSub;
		}else{
			if(s1.charAt(m)==s2.charAt(n)){
				return maxLen(s1, s2, m-1, n-1,s1.charAt(m)+maxSub);
			}
			else{
				return maxSub(maxLen(s1, s2, m-1, n,maxSub),maxLen(s1, s2, m, n-1,maxSub));
			}
		}
	}
	public String maxSub(String s1,String s2){
		return s1.length()>s2.length()?s1:s2;
	}
}
