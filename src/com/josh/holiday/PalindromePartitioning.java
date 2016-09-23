package com.josh.holiday;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/*
 * ���⣺�и��ַ���Ϊ���Ĵ������������ܽ�s�и�����ɻ��Ĵ������
 * ����������
 *      ���ַ���s��˵����ͷ��ʼ������һ���ж�ǰi���Ƿ��ǻ��Ĵ������ǵݹ�ִ���ж�ʣ�µ�len-i��
 *      ��ָ�뵽��sĩβ���������res
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
        	while(j<=s.length()&&isPalindrome(s,i,j)){//�ж��Ե�ǰ��ĸ��ͷ���ַ����Ƿ��ǻ��Ĵ�
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
	//�ж�һ���ַ�����m-n�Ƿ��ǻ��Ĵ�
	public boolean isPalindrome(String s,int m,int n){
		for(int i=m;i<(m+n)/2;i++){
			if(s.charAt(i)!=s.charAt(n+m-i-1)) return false;
		}
		return true;
	}
}
