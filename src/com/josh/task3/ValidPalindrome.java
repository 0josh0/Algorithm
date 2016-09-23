package com.josh.task3;

import org.junit.Test;

public class ValidPalindrome {
	@Test
	public void test(){
		String s = "race a car";
		boolean b = isPalindrome(s);
		System.out.println(b);
	}
	public boolean isPalindrome(String s) {
		String str = s.toLowerCase(); 
		if(str.length()<2){
			return true;
		}
		int i=0,j=str.length()-1;
		while(i<j){
			if(isChar(str.charAt(i)) && isChar(str.charAt(j))){
				if(str.charAt(i) != str.charAt(j)){
					return false;
				}
				i++;
				j--;
			}else if(isChar(str.charAt(i)) && !isChar(str.charAt(j))){
				j--;
			}else if(!isChar(str.charAt(i)) && isChar(str.charAt(j))){
				i++;
			}else{
				i++;
				j--;
			}
		}
		return true;  
    }
	//ÅÐ¶Ï×Ö·û´®ÖÐµÄÄ³¸ö×Ö·û
	public boolean isChar(char c){
		if((c>='a' && c<='z') || (c>='0' && c<='9')){
			return true;
		}
		return false;
	}
}
