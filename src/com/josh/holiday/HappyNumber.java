package com.josh.holiday;

import java.util.HashSet;

import org.junit.Test;

/*
 * ���⣺����һ����������Ҫ����: 1 �Ǹ� 
 * 						  2  ����λ�ϵ�����ƽ����ӣ��õ�������������1���ǻ������������������λ�ϵ���ƽ����ӣ�ֱ������1����֮ǰ���ֹ�������
 * �������ݹ�
 */
public class HappyNumber {
	 public boolean isHappy(int n) {
		 HashSet<Integer> set = new HashSet<>();
		 return isHappyNum(n,set);
	 }
	 public boolean isHappyNum(int n,HashSet<Integer> set){
	     //��n����λ��������ȡ����,ƽ�����
	     String nStr = String.valueOf(n);
	     int happy=0,temp=0;
	     for(int i=0;i<nStr.length();i++){
	    	 String s=String.valueOf(nStr.charAt(i));
	    	 temp=Integer.valueOf(s);
	    	 happy = happy + temp*temp;
	     }
	     if(happy==1) return true;//����Ϊ1������true
	     if(!set.add(happy)) return false;//������֮ǰ���ֹ�����ʾѭ������������false
	     else return isHappyNum(happy,set);//�ݹ�ִ��
	 }
	 @Test
	 public void test(){
		 int n=19;
		 System.out.println(isHappy(n));
	 }
}
