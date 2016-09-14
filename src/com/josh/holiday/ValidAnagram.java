package com.josh.holiday;

import java.util.HashMap;

import org.junit.Test;

/*
 * ���⣺�Ƚ������ַ����е��ַ��Ƿ���ȫ���
 * ������1������t�и����ַ�λ�ã�������t��ȫת����s������ת������ȣ��������.�˷���-��ʱ
 *      2��������map�洢s��t�������ַ��ĸ��������Ƚ�map�Ƿ���ȡ�
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
    public boolean isAnagram2(String s, String t) {//��ʱ
        if(s==null && t==null) return true;
        if(s.length()!=t.length()) return false;
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i)!=t.charAt(i)){
        		int j=i+1;
        		for(;j<t.length();j++){//����iλ��֮��������ַ���Ѱ�Һ�s��iλ����ȵ��ַ�
        			if(s.charAt(i)==t.charAt(j)) 
        				break;//�ҵ�������ѭ��
        		}
        		if(j<t.length() && s.charAt(i)==t.charAt(j)){//����i��jλ�õ��ַ�
        			StringBuffer sb = new StringBuffer(t);
        			char posi = t.charAt(i);
        			sb.setCharAt(i, t.charAt(j));
        			sb.setCharAt(j, posi);
        			t=sb.toString();
        		}else{//���û�ҵ�iλ������ַ���s��=t
        			return false;
        		}
        	}
        }
    	return true;
    }
    //����һ������26����ĸ��int���飬�ֱ����s��t������ĸ����
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
