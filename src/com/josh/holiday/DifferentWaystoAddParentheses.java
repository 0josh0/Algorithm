package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
 * ���⣺һ�������ֺ�+����*���ɵ��ַ�������һ���������������ڲ�ͬλ�ü�����
 * �����������㷨���ݹ顣�����ַ���������һ���������������󲿷ֺ��Ҳ��ֱ��ʽ��ֵ��
 *     Ȼ���󲿷�m�н�����Ҳ���n�н���ĳ˻�m*n�����ܹ�������������
 *     e.g. 2-3*4+5
 *     "-":left=2(һ��)     right=3*4+5(�����ּ�����,*��+����һ��)   �˴������������
 *     "*":left=2-3(һ��)   right=4+5(ֻ��һ�ּ�����)              �˴�����һ�����
 *     "+":left=2-3*4(����) right=5(һ��)                         �˴������������
 *     ���ԣ��ܹ���2+1+2=5�ֽ��
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
        	if(op.contains(input.charAt(i)+"")){//����������������������ұ��ʽֵ
            	String left = input.substring(0,i);//��ȡ�󲿷ֱ��ʽ
            	String right = input.substring(i+1);//��ȡ�Ҳ��ֱ��ʽ
            	List<Integer> leftList = diffWaysToCompute(left);//�洢�󲿷ֱ��ʽ�ļ�����
            	List<Integer> rightList = diffWaysToCompute(right);//�洢�Ҳ��ֱ��ʽ�ļ�����
            	for(Integer l:leftList){
            		for(Integer r:rightList){
            			if(input.charAt(i)=='+') res.add(l+r);
            			else if(input.charAt(i)=='-') res.add(l-r);
            			else res.add(l*r);
            		}
            	}
            }
        }
        if(res.isEmpty())res.add(Integer.valueOf(input));//�������һ��������ֱ����ӵ�res��
        return res;
    }
}
