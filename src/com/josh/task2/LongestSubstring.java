package com.josh.task2;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 找出一个字符串中没有重复字符的最长子串
 * 返回其长度
 * @author Josh
 *
 */
public class LongestSubstring {

	@Test
	public void test(){
		String s = "aab";
		lengthOfLongestSubstring(s);
	}
    public int lengthOfLongestSubstring(String s) {
		//将字符串转化为char数组
    	char[] sChar = s.toCharArray();
    	//用set集合存储字符串s的每个字符，因为set集合具有不存储重复元素的性质
    	Set<Character> set = new HashSet<Character>();
    	int maxLength = 0;//记录子串最大长度
    	if(sChar.length == 0){
    		System.out.println("最长子串长度："+0);
    		return 0;
    	}
    	//标记重复字符是否出现
    	boolean flag = false;
    	for(int i=0;i<sChar.length;i++){
    		int j=i;
    		while(j<sChar.length && flag == false){
    			if(!set.contains(sChar[j])){
        			set.add(sChar[j]);
        		}else{
        			flag = true;
        			
        		}
    			if(set.size() > maxLength){
    				maxLength = set.size();
    			}
    			j++;
    		}
    		flag = false;
    		set.clear();
    	}
    	System.out.println("最长子串长度："+maxLength);
    	return maxLength;
        
    }
}
