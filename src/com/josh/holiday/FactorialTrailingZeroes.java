package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺��������׳�ĩβ��ĸ���
 * ����: 1 ����׳ˣ��ڼ���0�ĸ��� - ��ʱ
 *      2 n!ĩβ�γ�0�ĸ�������n!�������е�2��5�ĸ��������ģ�һ��2��5�γ�һ��0����2��5����=5�ĸ���������ֻҪ���n!�������������5�ĸ������ɡ�
 *      
 */
public class FactorialTrailingZeroes {
	@Test
	public void test(){
		int n=20;
		//System.out.println(Math.)
		System.out.println(trailingZeroes(n));
	}
    public int trailingZeroes(int n) {
    	int count=0;
    	while(n/5>0){
    		n=n/5;
    		count=count+n;
    	}
		return count;
    }
    public int trailingZeroes1(int n) {
    	int i=2,res=1,count=0;
    	while(i<=n){
    		res=res*i;
    		i++;
    	}
    	while(res%10==0){
    		count++;
    		res=res/10;
    	}
		return count;
    }
}
