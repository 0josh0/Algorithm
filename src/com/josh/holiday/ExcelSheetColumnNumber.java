package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：输入excel表格列字符，返回时是第几列。
 * 分析：A-1……Z-26、AA-27、AB-28……
 *      可以转换成“26进制”的数字转换。e.g.AA=A*26+A*1
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
