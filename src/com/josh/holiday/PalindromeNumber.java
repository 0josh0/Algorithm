package com.josh.holiday;
/*
 * 题意: 判断一个数字是否是回文
 * 分析: 用两个指针双向遍历
 * 
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		String str = String.valueOf(x);
		int size = str.length()/2;
		for(int i=0;i<size;i++){
			if(str.charAt(i)!=str.charAt(str.length()-1-i)) return false;
		}
		return true;
    }
}
