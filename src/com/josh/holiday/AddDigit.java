package com.josh.holiday;

import org.junit.Test;

/*
 * 题意：给定一个非负整数，依次将各位上的数字相加，得到新数，如果是个位数，输出，否则，再把新数的各位数字相加，直到结果为个位数
 * 分析：传统做法不断循环整数各位上的数字加和，直到满足条件
 * 	    不用循环用时间复杂度为O(1):Digital root问题，模运算取9余数:(num-1)%9+1.
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
