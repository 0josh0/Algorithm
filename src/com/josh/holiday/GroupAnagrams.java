package com.josh.holiday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/*
 * ���⣺�ж��������Ƿ��Ǳ��δΣ�������ͬ����ĸ���ɣ����δʷ���һ��list�У���󷵻ر��δʵĸ���
 * ����������
 */
public class GroupAnagrams {
	@Test
	public void test(){
//		System.out.println((int)'a');
//		System.out.println((int)'z');
//		System.out.println((int)'A');
//		System.out.println((int)'Z');
		String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> res = new ArrayList<List<String>>();
		res = groupAnagrams(strs);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<List<String>>();
		if(strs==null||strs.length==0) return res;
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		for(int i=0;i<strs.length;i++){
			char[] charArray = strs[i].toCharArray();//��strs[i]ת��Ϊchar����
			Arrays.sort(charArray);//char�������������
			String str = new String(charArray);//���ź��������ת��Ϊstring
			if(map.containsKey(str)){
				map.get(str).add(strs[i]);
			}else{
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				map.put(str, list);
			}
		} 
		for(List<String> list:map.values()){
			Collections.sort(list);
			res.add(list);
		}
		return res;
	}
}
