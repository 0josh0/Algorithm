package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

/*
 * ���⣺ÿ���绰�����ϵ����ִ���������ĸ������һ�����֣�������п�����ĸ���
 * ������һ�ν�ÿ�����ִ������ĸ���뵽list�У���i�����ֵ�ʱ���õ����ִ������ĸletters
 *     Ȼ�����list��ÿ��list�е�Ԫ�ض���letters����letters����Ԫ�أ�������list
 *     ��ԭ��list.size()��Ԫ�����ӵ�list.size()+letters.length()��
 *     Ȼ�����list
 */
public class LetterCombinationsofPhoneNumber {

	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits==null||digits.length()==0) return res;
        res.add("");
        for(int i=0;i<digits.length();i++){
        	String letters = initial(digits.charAt(i));//�õ����ִ������ĸ
        	List<String> tmp = new ArrayList<String>();
        	for(int j=0;j<res.size();j++){
        		for(int k=0;k<letters.length();k++){//��letters��ÿһ����ĸ���뵽res��
        			tmp.add(res.get(j)+letters.charAt(k));
        		}
        	}
        	res=tmp;//����res
        }
		return res;
    }
	//��ʼ��
	public String initial(char c){
		switch(c){
		case '0':
			return " ";
		case '2':
			return "abc";
		case '3':
			return "def";
		case '4':
			return "ghi";
		case '5':
			return "jkl";
		case '6':
			return "mno";
		case '7':
			return "qprs";
		case '8':
			return "tuv";
		case '9':
			return "wzyx";
		default:
			return "";
		}
	}
}
