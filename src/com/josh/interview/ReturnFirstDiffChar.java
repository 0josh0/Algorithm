package com.josh.interview;

import org.junit.Test;

/*
 * ����: ���ص�һ�����ظ����ֵ��ַ�
 * ����: ��һ�α�����¼ÿ���ַ����ֵĴ������ڶ��α���Ѱ�ҳ��ִ���Ϊ1�ĵ�һ���ַ�
 */
public class ReturnFirstDiffChar {
	@Test
	public void test(){
		System.out.println(retrueChar("abbbccdefafgg"));
	}
	public char retrueChar(String s){
		char c = s.charAt(0);
		int[] b = new int[26];//��¼ÿ���ַ����ֵĴ���
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
