package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺��תһ��String�ַ������� e.g. Given s = "the sky is blue",
 * 							    return "blue is sky the".
 * ��������һ��StringBuilder��¼�½������һ��StringBuilder��¼����
 *      �Ӻ���ǰ����s��ʱ�临�Ӷ�O(n),�ռ临�Ӷ�O(n)
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
