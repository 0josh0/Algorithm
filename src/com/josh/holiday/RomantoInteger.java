package com.josh.holiday;

import java.util.HashMap;

import org.junit.Test;

/*
 * 题意：将罗马数字转换为阿拉伯数字，范围限于1-3999
 * 罗马数字中：I-1，V-5，X-10，L-50，C-100，D-500，M-1000；
 * 计数规则：
	1、相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3
	2、小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8
	3、小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4
	4、正常使用时，连续的数字重复不得超过三次
 * 分析：用一个map存储罗马数字中的标识和所代表的数，然后依次遍历String计数
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
    //从后向前相加
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
    //从前向后相加
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
