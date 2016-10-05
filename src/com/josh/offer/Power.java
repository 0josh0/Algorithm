package com.josh.offer;
/*
 * 求double的int次方
 * 
 */
public class Power {

	public double p1(double base,int exp){
		if(exp==1) return base;
		if(exp==0) return 1.0;
		int abs_exp = Math.abs(exp);
		double res = base;
		while(abs_exp>0){
			res=res*base;
			abs_exp--;
		}
		if(exp<0)
			return 1/res;
		return res;
	}
}
