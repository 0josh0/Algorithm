package com.josh.task4;

import org.junit.Test;

public class Pow {
	@Test
	public void test(){
		double x = 4.0000;
		int n = -3;
		double res = myPow(x, n);
		System.out.println(res);
		System.out.println(Math.pow(4.0, -3));
	}
	public double myPow(double x, int n) {
		double res = x*x;
		long count = 2;
		if(n<0) res = (1/x) * (1/x);
		if(n==0 || x == 1.0 || (x == -1.0 && n%2==0)) return 1.0;
		if(x == -1.0 && n%2==1) return -1.0;
		if(n==1) return x;
		if(n==2 || n==-2) return res;
		while(count < Math.abs(n)){
			res = res * res;
			count = count + count;
		}
		for(int i=0;i<count-Math.abs(n);i++){//count比n大几，就是多乘了几个x，再除掉
			if(n<0) res = res*x;
			if(n>0) res = res/x;
		}
		return res;
    }
}
