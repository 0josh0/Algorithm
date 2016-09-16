package com.josh.interview;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/*
 * ����: �������ַ����������ڵ�һ���е��ַ�Ҳ�����ڵڶ����еģ����ڵ�һ����ɾ��
 * ����: ��s2�е�ÿ���ַ�������set�У�Ȼ�����s1�������set���Ƿ�������ַ�
 */
public class RemoveSameCharacter {

	@Test
	public void test(){
		char[] c1={'a','b','c','d'};
		char[] c2={'a','b'};
 		System.out.println(removeSame2(c1,c2));
	}
	//����set��׼��Ľ������
	public String removeSame(String s1,String s2){
		Set<Character> set = new HashSet<Character>();
		for(int i=0;i<s2.length();i++){
			set.add(s2.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s1.length();i++){
			if(!set.contains(s1.charAt(i))){
				sb.append(s1.charAt(i));
			}
		}
		return sb.toString();
	}
	//���ñ�׼��ı���������� O(n2)
	public String removeSame1(String s1,String s2){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s1.length();i++){
			for(int j=0;j<s2.length();j++){
				if(s1.charAt(i)==s2.charAt(j)){
					break;
				}else{
					if(j==s2.length()-1){
						sb.append(s1.charAt(i));
					}
				}
			}
		}
		return sb.toString();
	}
	//���ñ�׼���һ�������� O(n)
	public String removeSame2(char[] c1,char[] c2){
		StringBuilder sb = new StringBuilder();
		boolean[] b=new boolean[26];//��ʼ��26����ĸλ��false
		for(int i=0;i<c2.length;i++){//c2�г��ֵ��ַ���b����Ϊtrue
			int a = 'a'+0;
			int bPos = c2[i]-a;
			if(b[bPos]==false) b[bPos]=true;
		}
		for(int i=0;i<c1.length;i++){
			int a = 'a'+0;
			int bPos = c1[i]-a;
			if(b[bPos]==false) sb.append(c1[i]);
		}
		return sb.toString();
	}
}
