package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺����excel������ַ�������ʱ�ǵڼ��С�
 * ������A-1����Z-26��AA-27��AB-28����
 *      ����ת���ɡ�26���ơ�������ת����e.g.AA=A*26+A*1
 */

public class ExcelSheetColumnNumber {
	@Test
	public void test(){
		//System.out.println(Math.pow(2, 3));
		titleToNumber("ABZ");
	}
	public int titleToNumber(String s) {
		int num=0;
		if(s==null) return num;
		int pos = s.length()-1;
		for(int i=0;i<s.length();i++){
			num = num + (s.charAt(i)-'A'+1)*(int)Math.pow(26, pos--);
		}
		System.out.println(num);
        return num;
    }
}
