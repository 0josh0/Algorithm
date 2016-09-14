package com.josh.holiday;

import java.util.HashSet;

import org.junit.Test;

/*
 * 题意：定义一个欢乐数，要满足: 1 非负 
 * 						  2  各个位上的数字平方相加，得到新数，若等于1，是欢乐数，否则继续各个位上的数平方相加，直到出现1或者之前出现过的数字
 * 分析：递归
 */
public class HappyNumber {
	 public boolean isHappy(int n) {
		 HashSet<Integer> set = new HashSet<>();
		 return isHappyNum(n,set);
	 }
	 public boolean isHappyNum(int n,HashSet<Integer> set){
	     //把n各个位上数字提取出来,平方相加
	     String nStr = String.valueOf(n);
	     int happy=0,temp=0;
	     for(int i=0;i<nStr.length();i++){
	    	 String s=String.valueOf(nStr.charAt(i));
	    	 temp=Integer.valueOf(s);
	    	 happy = happy + temp*temp;
	     }
	     if(happy==1) return true;//若和为1，返回true
	     if(!set.add(happy)) return false;//若和在之前出现过，表示循环回来，返回false
	     else return isHappyNum(happy,set);//递归执行
	 }
	 @Test
	 public void test(){
		 int n=19;
		 System.out.println(isHappy(n));
	 }
}
