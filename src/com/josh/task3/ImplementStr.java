package com.josh.task3;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ImplementStr {

	@Test
	public void test(){
		String haystack = "a";
		String needle = "";
		strStr(haystack,needle);
	}
	public int strStr(String haystack, String needle) {
		if(haystack.length()<needle.length()){
			System.out.println("�Ӵ�������-1");
			return -1;
		}
		if(needle.length() == 0){
			System.out.println("�Ӵ�������0");
			return 0;
		}
		//�洢needle�ĵ�һ���ַ���������haystack�е�����λ��
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<haystack.length();i++){
			if(haystack.charAt(i) == needle.charAt(0)){
				list.add(i);
			}
		}
		if(list.isEmpty()){
			System.out.println("�Ӵ�������-1");
			return -1;
		}
		int key=0;
		System.out.println(haystack.length()-list.get(key));
		System.out.println(needle.length());
		while(key<list.size() && (haystack.length()-list.get(key)) >= needle.length()){
			if(haystack.substring(list.get(key),list.get(key)+needle.length()).equals(needle)){
				System.out.println("�Ӵ�������"+list.get(key));
				return list.get(key);
			}
			key++;
		}
		System.out.println("�Ӵ�������-1");
		return -1;
    }
}
