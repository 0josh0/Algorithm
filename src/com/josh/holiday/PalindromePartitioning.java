package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/*
 * 题意：切割字符串为回文串，返回所有能将s切割成若干回文串的情况
 * 分析：回溯
 *      对字符串s来说，从头开始遍历，一次判断前i个是否是回文串，若是递归执行判断剩下的len-i个
 *      当指针到达s末尾将结果加入res
 * 
 */
public class PalindromePartitioning {
	@Test
	public void test(){
		String s = "a";
		List<List<String>> res = new ArrayList<List<String>>();
		res = partition(s);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<List<String>>();
		if(s==null||s.length()==0) return res;
		helper(s,0,new ArrayList<String>(),res);
		return res;
	}
	public void helper(String s,int start,List<String> list,List<List<String>> res){
		if(start>s.length()) return;
		if(start==s.length()){
			res.add(new ArrayList<String>(list));
			return;
		}else{
			for(int i=start;i<s.length();i++){
				if(isPalindrome(s, start, i+1)){
					list.add(s.substring(start,i+1));
					helper(s,i+1,list,res);
					list.remove(list.size()-1);
				}
			}
		}
	}
	public List<List<String>> partition1(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s==null||s.length()==0) return res;
        for(int i=0;i<s.length();i++){
        	List<String> list = new ArrayList<String>();
        	int j=i+1;
        	while(j<=s.length()&&isPalindrome(s,i,j)){//判断以当前字母开头的字符串是否是回文串
        		list.add(s.substring(i,j));
        		j++;
        	}
        	int step=1;
        	while(i-step>=0&&i+step<s.length()&&isPalindrome(s,i-step,i+step+1)){
        		list.add(s.substring(i-step,i+step+1));
        		step++;
        	}
        	res.add(list);
        }
		return res;
    }
	//判断一个字符串从m-n是否是回文串
	public boolean isPalindrome(String s,int m,int n){
		for(int i=m;i<(m+n)/2;i++){
			if(s.charAt(i)!=s.charAt(n+m-i-1)) return false;
		}
		return true;
	}
}
