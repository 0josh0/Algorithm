package com.josh.task9;

import java.util.ArrayList;

import org.junit.Test;

/*
 * 题意: 给出两个整数分别代表分子和分母，求分数的小数形式,若是循环小数将，循环节用括号括起来
 * 分析: 定理：一个分母为N的循环小数的循环节位数最多不超过N-1位。
 */
public class FractionRecurringDecimal {
	@Test
	public void test(){
		System.out.println(fractionToDecimal(-1,-2147483647));
	}
    public String fractionToDecimal(int numerator, int denominator) {
    	if(numerator==0) return "0";
        long a = numerator,b=denominator;
        long numerator1=Math.abs(a);
        long denominator1=Math.abs(b);//全部转化为正数运算
        ArrayList<Long> list = new ArrayList<Long>();//存储不重复出现的余数
        String res = (numerator1/denominator1)+"";//保存整数部分
        if((numerator<0&&denominator>0)||(numerator>0&&denominator<0)) res="-"+res;
        StringBuffer sb = new StringBuffer();//保存小数部分
        long m = numerator1%denominator1;//计算余数
        if(m==0) return res;
        while(m!=0){
        	if(list.contains(m)){//不可以向集合中添加新余数，表示已经出现重复的余数，循环
        		int i=0;
        		for(;i<list.size();i++){//寻找循环节起点
        			if(list.get(i)==m) break;
        		}
        		sb.insert(i, "(");
        		sb.insert(list.size()+1, ")");
        		break;//跳出while循环
        	}else{//没有出现新余数，计算小数部分
        		list.add(m);//向set集合中添加新余数
        		sb.append(m*10/denominator1);
        		m=m*10%denominator1;//更新余数
        	}
        }
        return res+"."+sb;
    }
}
