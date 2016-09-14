package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺�ж�һ�������Ƿ���3����
 * ������1 ��ѭ�����ߵݹ� --- ��ʱ
 *      2 ����java��Math������������3Ϊ�͵Ķ���,�мǽ��ȡ����Ȼ���ڳ˷���������Ƿ����
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
//    	if(n==0) return false;
//    	double up = Math.log10(n);
//    	double down = Math.log10(3);
//    	int m = (int)(up/down);
//    	double nn = Math.pow(3, m);
//    	if(n==nn) return true;
    	return n==0?false:Math.pow(3, (int)((Math.log10(n))/(Math.log10(3))))==n;
    }
    public boolean isPowerOfThree1(int n) {
    	if(n==1) return true;
    	int i=3;
    	while(i<=n){
    		if(i==n) return true;
    		else i=i*3;
    	}
    	return false;
    }
    @Test
    public void test(){
    	System.out.println(isPowerOfThree(177148));
    }
}
