package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺����һ���Ǹ����������ν���λ�ϵ�������ӣ��õ�����������Ǹ�λ��������������ٰ������ĸ�λ������ӣ�ֱ�����Ϊ��λ��
 * ��������ͳ��������ѭ��������λ�ϵ����ּӺͣ�ֱ����������
 * 	    ����ѭ����ʱ�临�Ӷ�ΪO(1):Digital root���⣬ģ����ȡ9����:(num-1)%9+1.
 */
public class AddDigit {
   @Test
   public void test(){
	   int num=10;
	   System.out.println(addDigits(num));
   }
	public int addDigits(int num) {
		return (num-1)%9+1;
	}
	public int addDigits2(int num) {
    	if(num<10) return num;
    	while(num>=10){
    		String strNum = num+"";
    		int n=0;
    		for(int i=0;i<strNum.length();i++){
    			n=n+Integer.parseInt(String.valueOf(strNum.charAt(i)));
    		}
    		num=n;
    	}
    	return num;
    }
}
