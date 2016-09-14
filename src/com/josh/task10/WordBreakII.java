package com.josh.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * ����: ��һ��String s���ֵ䣬�ж����s�ܷ񱻿ո��зֳ��ֵ��еĴ�,�������п����з����
 * ����: ��һ��boolean�����¼��ֹ��iλ�õ�ʱ����ַ����ܷ���ȷ�з֣���ôb[i]�����������ַ�i��β���ַ�����֮ǰλ�õ�b[j]Ϊtrue
 */
public class WordBreakII {
/*
 * δ��ɡ�����������������
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
