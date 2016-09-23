package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * 题意：一个由数字和+——*构成的字符串，求一共有运算结果，即在不同位置加括号
 * 分析：分治算法，递归。遍历字符串，遇到一个操作符，计算左部分和右部分表达式的值，
 *     然后左部分m中结果和右部分n中结果的乘积m*n就是总共的运算结果数。
 *     e.g. 2-3*4+5
 *     "-":left=2(一种)     right=3*4+5(有两种计算结果,*和+处各一种)   此处共有两个结果
 *     "*":left=2-3(一种)   right=4+5(只有一种计算结果)              此处共有一个结果
 *     "+":left=2-3*4(两种) right=5(一种)                         此处共有两个结果
 *     所以，总共有2+1+2=5种结果
 *     
 */
public class DifferentWaystoAddParentheses {
	@Test
	public void test(){
		List<Integer> res = diffWaysToCompute("2*3-4*5");
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i));
		}
	}
	public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if(input==null||input.length()==0) return res;
        String op = "+-*";
        for(int i=0;i<input.length();i++){
        	if(op.contains(input.charAt(i)+"")){//如果碰到操作符，计算左右表达式值
            	String left = input.substring(0,i);//获取左部分表达式
            	String right = input.substring(i+1);//获取右部分表达式
            	List<Integer> leftList = diffWaysToCompute(left);//存储左部分表达式的计算结果
            	List<Integer> rightList = diffWaysToCompute(right);//存储右部分表达式的计算结果
            	for(Integer l:leftList){
            		for(Integer r:rightList){
            			if(input.charAt(i)=='+') res.add(l+r);
            			else if(input.charAt(i)=='-') res.add(l-r);
            			else res.add(l*r);
            		}
            	}
            }
        }
        if(res.isEmpty())res.add(Integer.valueOf(input));//如果就是一个整数，直接添加到res中
        return res;
    }
}
