package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

/*
 * 题意：每个电话按键上的数字代表三各字母，输入一串数字，输出所有可能字母组合
 * 分析：一次将每个数字代表的字母加入到list中，第i个数字的时候，拿到数字代表的字母letters
 *     然后遍历list，每个list中的元素都和letters构成letters个新元素，遍历玩list
 *     由原来list.size()个元素增加到list.size()+letters.length()个
 *     然后更新list
 */
public class LetterCombinationsofPhoneNumber {

	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits==null||digits.length()==0) return res;
        res.add("");
        for(int i=0;i<digits.length();i++){
        	String letters = initial(digits.charAt(i));//得到数字代表的字母
        	List<String> tmp = new ArrayList<String>();
        	for(int j=0;j<res.size();j++){
        		for(int k=0;k<letters.length();k++){//将letters的每一个字母加入到res中
        			tmp.add(res.get(j)+letters.charAt(k));
        		}
        	}
        	res=tmp;//更新res
        }
		return res;
    }
	//初始化
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
