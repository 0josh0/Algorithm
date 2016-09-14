package com.josh.holiday;

import java.util.HashMap;

import org.junit.Test;

/*
 * ���⣺����������ת��Ϊ���������֣���Χ����1-3999
 * ���������У�I-1��V-5��X-10��L-50��C-100��D-500��M-1000��
 * ��������
	1����ͬ��������д������ʾ����������Щ������ӵõ����������磺III = 3
	2��С�������ڴ�������ұߣ�����ʾ����������Щ������ӵõ����������磺VIII = 8
	3��С�����֣����ڣ�I��X��C���ڴ��������ߣ�����ʾ�������ڴ�����ȥС�����õ��������磺IV = 4
	4������ʹ��ʱ�������������ظ����ó�������
 * ��������һ��map�洢���������еı�ʶ�������������Ȼ�����α���String����
 */
public class RomantoInteger {
	@Test
	public void test(){
		String s = "MMMCMXCIX";
		System.out.println(romanToInt2(s));
	}
    public int romanToInt(String s) {
    	HashMap<Character,Integer> map = new HashMap<>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	
    	if(s.length()==1) return map.get(s.charAt(0));
        int first = map.get(s.charAt(0)),second = map.get(s.charAt(1)),res=0;
        for(int i=0;i<s.length();){
        	first = map.get(s.charAt(i));
        	if(i+1<s.length()){
        		second = map.get(s.charAt(i+1));
        		if(first<second){
        			res = res + second - first;
        			i=i+2;
        		}else{
        			res = res + first;
        			i++;
        		}
        	}else{
        		res = res + first;
        		i++;
        	}
        }
    	return res;
    }
    //�Ӻ���ǰ���
    public int romanToInt1(String s) {
    	HashMap<Character,Integer> map = new HashMap<>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	int res=map.get(s.charAt(s.length()-1)),pre=res;
    	for(int i=s.length()-2;i>=0;i--){
    		int cur = map.get(s.charAt(i));
    		if(pre>cur) res = res - cur;
    		else res = res + cur;
    		pre = cur;
    	}
    	return res;
    }
    //��ǰ������
    public int romanToInt2(String s) {
    	HashMap<Character,Integer> map = new HashMap<>();
    	map.put('I', 1);
    	map.put('V', 5);
    	map.put('X', 10);
    	map.put('L', 50);
    	map.put('C', 100);
    	map.put('D', 500);
    	map.put('M', 1000);
    	int res=map.get(s.charAt(0)),pre=res;
    	for(int i=1;i<s.length();i++){
    		int cur = map.get(s.charAt(i));
    		if(pre<cur) res = res + cur - 2*pre;
    		else res = res + cur;
    		pre = cur;
    	}
    	return res;
    }
}
