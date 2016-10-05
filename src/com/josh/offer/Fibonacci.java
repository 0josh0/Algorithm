package com.josh.offer;

import org.junit.Test;

/*
 * 쳲���������f(n)=f(n-1)+f(n-2)
 * �ݹ�ORѭ��
 */
public class Fibonacci {
	
	@Test
	public void test(){
		System.out.println(fibo(5));
		System.out.println(fibo2(5));
	}

	//ѭ��д��
	public int fibo(int n){
		int pre1=1,pre2=1,res=1;
		for(int i=2;i<=n;i++){
			res=pre1+pre2;
			pre1=pre2;
			pre2=res;
		}
		return res;
	}
	//�ݹ�д��
	public int fibo2(int n){
		if(n<2){
			return 1;
		}else{
			return fibo2(n-1)+fibo2(n-2);
		}
	}
}
