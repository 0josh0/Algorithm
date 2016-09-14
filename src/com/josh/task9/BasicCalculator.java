package com.josh.task9;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/*
 * ����: һ���ӷ�������string���ʽ�����ܰ����ո����ŵ��ַ�������ʽ�Ľ��
 * ����: 1 ȫ�����ӷ�����������ֺ���ǰ��ķ��������ַ�ȫ������ --��ʵ֤�� ����뷨��һ��ʺ����������
 *      2 ����׺���ʽת��Ϊ��׺���ʽ��Ȼ�������׺���ʽ���������֣���ջ��
 *        ���Ƿ��ţ����㣬Ȼ���ٽ������ջ���ٱ������ʽ�����õ����
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
	//׬ת��Ϊ��׺���ʽ
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
