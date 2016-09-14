package com.josh.task9;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/*
 * 题意: 一个加法减法的string表达式，可能包括空格，括号等字符，求表达式的结果
 * 分析: 1 全部按加法计算除了数字和他前面的符号其余字符全部忽略 --事实证明 这个想法是一坨屎！！！！！
 *      2 把中缀表达式转换为后缀表达式，然后遍历后缀表达式，若是数字，入栈，
 *        若是符号，计算，然后再将结果入栈，再遍历表达式，最后得到结果
 * 
 */
public class BasicCalculator {
	@Test
	public void test(){
		String s ="0";
//		List<String> list = preDo(s);
//		for(int i=0;i<list.size();i++){
//			System.out.print(list.get(i)+" ");
//		}
		System.out.print(calculate(s));
	}
	public int calculate(String s) {
		List<String> list = preDo(s);
		Stack<Integer> stack= new Stack<Integer>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).equals("-")||list.get(i).equals("+")) {
				if(list.get(i).equals("+")){
					stack.push(stack.pop()+stack.pop());
				}else{
					stack.push(- stack.pop() + stack.pop());
				}
			}else{
				stack.push(Integer.valueOf(list.get(i)));
			}
		}
		return stack.peek();
	}
	//赚转化为后缀表达式
	public List<String> preDo(String s){
		Stack<Character> stack= new Stack<Character>();
		List<String> list = new ArrayList<String>();
		//String str="";
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)>='0'){
				String str="";
				while(i<s.length()&&s.charAt(i)>='0'){
					str = str+s.charAt(i);
					i++;
				}
				list.add(str);
				i--;
			}else if(s.charAt(i)=='-'||s.charAt(i)=='+'){
				if(stack.isEmpty()||stack.peek()=='('){
					stack.push(s.charAt(i));
				}else{
					//str = str+stack.pop();
					list.add(stack.pop().toString());
					stack.push(s.charAt(i));
				}
			}else if(s.charAt(i)=='('){
				stack.push(s.charAt(i));
			}else if(s.charAt(i)==')'){
				while(stack.peek()!='('){
					//str = str+stack.pop();
					list.add(stack.pop().toString());
				}
				stack.pop();
			}
		}
		while(!stack.isEmpty())list.add(stack.pop().toString());
		return list;
	}
}
