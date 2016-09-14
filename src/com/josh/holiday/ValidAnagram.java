package com.josh.holiday;

import java.util.HashMap;

import org.junit.Test;

/*
 * 题意：比较两个字符串中的字符是否完全相等
 * 分析：1、调整t中各个字符位置，尽力将t完全转化成s，若能转化则相等，否则不相等.此方法-超时
 *      2、用两个map存储s和t中所有字符的个数，最后比较map是否相等。
 */
public class ValidAnagram {
	@Test
	public void test(){
		String s="ab";
		String t="ba";
		System.out.println(isAnagram(s, t));
//		
//		HashMap<String, Integer> map1 = new HashMap<>();
//		HashMap<String, Integer> map2 = new HashMap<>();
//		
//		map1.put("s", 1);
//		map1.put("a", 2);
//		map2.put("s", 1);
//		map2.put("a", 2);
//		//System.out.println(map1.equals(map2));
//		if(map1.containsKey("s")){
//			int v = map1.get("s");
//			//v++;
//			map1.put("s",++v);
//		}
//		System.out.println(map1.get("s"));
	}
	public boolean isAnagram(String s,String t){
		if(s==null && t==null) return true;
        if(s.length()!=t.length()) return false;
      
        HashMap<Character, Integer> mapS = new HashMap<>();
		HashMap<Character, Integer> mapT = new HashMap<>();
		
		for(int i=0;i<s.length();i++){
			if(mapS.containsKey(s.charAt(i))){
				int value = mapS.get(s.charAt(i));
				mapS.put(s.charAt(i), ++value);
			}else{
				mapS.put(s.charAt(i),1);
			}
			if(mapT.containsKey(t.charAt(i))){
				int value = mapT.get(t.charAt(i));
				mapT.put(t.charAt(i), ++value);
			}else{
				mapT.put(t.charAt(i),1);
			}
		}
		return mapS.equals(mapT);
	}
    public boolean isAnagram2(String s, String t) {//超时
        if(s==null && t==null) return true;
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)!=t.charAt(i)){
        		int j=i+1;
        		for(;j<t.length();j++){//遍历i位置之后的所有字符，寻找和s的i位置相等的字符
        			if(s.charAt(i)==t.charAt(j)) 
        				break;//找到，跳出循环
        		}
        		if(j<t.length() && s.charAt(i)==t.charAt(j)){//交换i和j位置的字符
        			StringBuffer sb = new StringBuffer(t);
        			char posi = t.charAt(i);
        			sb.setCharAt(i, t.charAt(j));
        			sb.setCharAt(j, posi);
        			t=sb.toString();
        		}else{//如果没找到i位置相等字符，s！=t
        			return false;
        		}
        	}
        }
    	return true;
    }
    //声明一个代表26个字母的int数组，分别遍历s和t计算字母个数
    public boolean isAnagram3(String s,String t){
    	int[] A = new int[26];
    	for(int i=0;i<s.length();i++){
    		A[s.charAt(i)-'a']++;
    	}
    	for(int j=0;j<t.length();j++){
    		A[t.charAt(j)-'a']--;
    	}
    	for(int k=0;k<A.length;k++){
    		if(A[k]!=0) return false;
    	}
    	return true;
    }
}
