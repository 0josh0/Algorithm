package com.josh.task4;

import org.junit.Test;

public class Squrt {
	@Test
	public void test(){
		//int x = 2147395599;
		//int x = 2147483647;
		int x= 2147395599;
		int res = mySqrt(x);
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(1/2);
		System.out.println(res);
	}
    public int mySqrt(int x) {
    	int xLength = String.valueOf(x).length(),b = 0;//ƽ������ƽ������λ�� ,��x��λ��
    	if(xLength%2 == 1) b = (xLength/2)+1;
    	if(xLength%2 == 0) b = xLength/2;
    	long i=1,j=9;//ƽ������Χ
    	for(int k=0;k<b-1;k++){
    		i = i*10;
    		j = j*10+9;
    	}
    	if(i<10) i=0;   	
		while(i<=j){
			long mid = (i+j)/2;//���ַ�����
			if(mid*mid>x){
				j = mid-1;
			}else if(mid*mid<x){
				i = mid + 1;
			}else if(mid*mid==x){
				return (int) mid;
			}	
		}
    	return (int) Math.min(i, j);  
    }
    public int mySqrt2(int x) {
    	int i=0,j=x;
		int mid = (i+j)/2;
		while(i<=j){
			if(mid*mid>x){
				j = mid-1;
				mid=(i+j)/2;
			}
			if(mid*mid<x){
				i = mid + 1;
				mid=(i+j)/2;
			}
			if(mid*mid==x) return mid;
		}
    	return -1;  
    }
}
