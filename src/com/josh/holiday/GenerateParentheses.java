package com.josh.holiday;

import java.util.ArrayList;

import org.junit.Test;

/*
 * 题意: 给出整数n，输出所有n对合法的括号情况。e.g. n=3 "((()))", "(()())", "(())()", "()(())", "()()()"
 * 分析: 递归
 */
public class GenerateParentheses {
	@Test
	public void test(){
		ArrayList<String> list = new ArrayList<String>();
		list=generateParenthesis(3);
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
	}
	public ArrayList<String> generateParenthesis(int n) {  
	    ArrayList<String> res = new ArrayList<String>();  
	    if(n<=0)  
	        return res;  
	    helper(n,n,new String(),res);  
	    return res;  
	}  
	private void helper(int l, int r, String item, ArrayList<String> res)  
	{  
	    if(r<l)  
	        return;  
	    if(l==0 && r==0)  
	    {  
	        res.add(item);  
	    }  
	    if(l>0)  
	        helper(l-1,r,item+"(",res);  
	    if(r>0)  
	        helper(l,r-1,item+")",res);  
	} 
}
