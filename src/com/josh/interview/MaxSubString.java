package com.josh.interview;

import org.junit.Test;

/*
 * ����: ��������ַ����������������
 * ����: ��̬�滮���ݹ���⡣(m,n�ֱ�Ϊ��ǰ�ַ��������һ���ַ�)
 *      �����ַ���X��Y����Xm=Yn���������������maxSub=(Xm-1��Yn-1)+1//�ݹ����
 *      			 ��Xm��=Yn��������� ������maxSub=Max((Xm-1,Yn),(Xm,Yn-1))
 */
public class MaxSubString {

	public String getMaxSubString(String s1,String s2){
		String maxSub="";
		maxLen(s1,s2,s1.length(),s2.length() ,maxSub);
		return s1;
	}
	@Test
	public void test(){
		String maxSub="";
		System.out.println(maxLen("BDCABA", "ABCBDAB", 5, 6,maxSub));
	}
	//������������г���
	public int maxLen(String s1,String s2,int m,int n){
		if(m==0||n==0){
			if(s1.charAt(m)==s2.charAt(n)) return 1;
			else return 0;
		}else{
			if(s1.charAt(m)==s2.charAt(n)) return maxLen(s1, s2, m-1, n-1)+1;
			else return Math.max(maxLen(s1, s2, m-1, n),maxLen(s1, s2, m, n-1));
		}
	}
	//�������������
	public String maxLen(String s1,String s2,int m,int n,String maxSub){
		if(m==0||n==0){
			if(s1.charAt(m)==s2.charAt(n)) return maxSub=s1.charAt(m)+maxSub;
			else return maxSub;
		}else{
			if(s1.charAt(m)==s2.charAt(n)){
				return maxLen(s1, s2, m-1, n-1,s1.charAt(m)+maxSub);
			}
			else{
				return maxSub(maxLen(s1, s2, m-1, n,maxSub),maxLen(s1, s2, m, n-1,maxSub));
			}
		}
	}
	public String maxSub(String s1,String s2){
		return s1.length()>s2.length()?s1:s2;
	}
}
