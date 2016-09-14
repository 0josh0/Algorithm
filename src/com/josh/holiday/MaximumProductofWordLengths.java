package com.josh.holiday;
/*
 * 题意: 给定一个String数组，求两个没有重复字符的串的长度的最大乘积
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn"
 * 
 * 分析: 用int的后26位记录一个串出现的字母情况，出现位置置1，不出现置0.用一个int数组记录String数组中每个串中出现字母的情况
 * 		最后通过与&运算判断俩个串是否有相同字母
 */
public class MaximumProductofWordLengths {
	public int maxProduct(String[] words) {
        int[] apl = new int[words.length];
        for(int i=0;i<words.length;i++){
        	apl[i]=0;//统计每个string中出现的字母情况
        	for(int j=0;j<words[i].length();j++){
        		apl[i] = apl[i] | (1<<(words[i].charAt(j)-'a'));
        	}
        }
        //求最大长度
        int maxLen=0;
        for(int i=0;i<apl.length;i++){
        	for(int j=i+1;j<apl.length;j++){
        		if((apl[i]&apl[j])==0){//表示各个位上的字母都不同，即没有重复出现的字母
        			maxLen = Math.max(maxLen, words[i].length()*words[j].length());
        		}
        	}
        }
        return maxLen;
    }
}
