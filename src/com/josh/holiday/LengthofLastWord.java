package com.josh.holiday;

import org.junit.Test;

/*
 * ����: ��һ���ַ������һ�����ʵĳ��ȣ���û������ַ�������0��
 * ����: 
 */
public class LengthofLastWord {
	@Test
	public void test(){
		System.out.println(lengthOfLastWord("Hello World"));
	}
	public int lengthOfLastWord(String s) {
       if(s.length()==0) return 0;
       int start=0,end=s.length()-1;
       while(end>=0&&(s.charAt(end)==' ')) end--;
       for(start=end;start>=0;start--){
    	   if((s.charAt(start)==' ')) {
    		   break;
    		}
    	}
       return end-start;
    }
}
