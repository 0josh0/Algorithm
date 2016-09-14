package com.josh.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * 题意: 给一个String s和字典，判断这个s能否被空格切分成字典中的词,返回所有可能切分情况
 * 分析: 用一个boolean数组记录截止到i位置的时候该字符串能否被正确切分，那么b[i]等于所有以字符i结尾的字符串和之前位置的b[j]为true
 */
public class WordBreakII {
/*
 * 未完成。。。。。。。。。
 * 
 * /
 */
	public List<String> wordBreak(String s, Set<String> wordDict) {
		if(s==null|s.length()==0) return null;
        List<String> list = new ArrayList<String>();
        boolean[] b=new boolean[s.length()];
        b[0] = wordDict.contains(s.substring(0,1));
        for(int i=1;i<s.length();i++){
        	if(wordDict.contains(s.substring(0,i+1))){
        		b[i] = true;
        	}else{
        		for(int j=1;j<=i;j++){
        			if(b[j-1]&&wordDict.contains(s.substring(j,i+1))){
        				b[i]=true;
        				break;
        			}
        		}
        	}
        }
       
        return list;
    }
}
