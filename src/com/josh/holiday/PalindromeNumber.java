package com.josh.holiday;
/*
 * ����: �ж�һ�������Ƿ��ǻ���
 * ����: ������ָ��˫�����
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
