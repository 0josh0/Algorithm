package com.josh.task11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * 题意：找出所有单词组合在一起能构成回文 字符串的的单词下标
 * 分析：1、就知道，暴力解法一定超时！！！！！
 * 	    2、把字典中的所有单词全部存进map中，然后遍历s[]，每次遍历到一个s[i]时，将s[i]翻转得到reverse
 * 		      然后，看reverse是否在map中，若在，直接加入list，若不在，再次遍历s[],和所有比s[i]长的字符比较
 * 		      截取s[]的前半段，若和s[i]相等并且s[]的其余部分是回文则这两个能构成回文串，然后再截取后半段进行同样比较
 * 		      -----超时！
 * 		      没有充分用到map的性质，时间复杂度O(n2*K)
 *      3、把字典中的所有单词全部存入map中，然后遍历s[],对每个s[i]字符串,从左到右遍历，截取并翻转，
 *        若截取翻转部分在map中，并且s[i]截取剩余部分是回文串，则这两个字符串能构成回文串，在对s[i]从右向左进行同样操作
 *        注意：可能有重复的，这里用一个set去重。 时间复杂度O(n*k)
 */
public class PalindromePairs {

	@Test
	public void test(){
		String[] s = {"bb","bababab","baab","abaabaa","aaba","","bbaa","aba","baa","b"};
		//String[] s = {"a", ""};
		List<List<Integer>> ans =palindromePairs3(s);
		for(int i=0;i<ans.size();i++){
			
			for(int j=0;j<ans.get(i).size();j++){
				System.out.print(ans.get(i).get(j)+"  ");
			}
			System.out.println();
		}
	}
	public List<List<Integer>> palindromePairs(String[] words) {
	    List<List<Integer>> pairs = new LinkedList<>();
	    if (words == null) return pairs;
	    HashMap<String, Integer> map = new HashMap<>();
	    for (int i = 0; i < words.length; ++ i) map.put(words[i], i);
	    for (int i = 0; i < words.length; ++ i) {
	        int l = 0, r = 0;
	        while (l <= r) {
	            String s = words[i].substring(l, r);
	            Integer j = map.get(new StringBuilder(s).reverse().toString());
	            if (j != null && i != j && isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l)))
	                pairs.add(Arrays.asList(l == 0 ? new Integer[]{i, j} : new Integer[]{j, i}));
	            if (r < words[i].length()) ++r;
	            else ++l;
	        }
	    }
	    return pairs;
	}
	public List<List<Integer>> palindromePairs3(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		Set<List<Integer>> set = new HashSet<>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<words.length;i++){//将s中的字符存在map中，index为value
			map.put(words[i],i);
		}
		for(int i=0;i<words.length;i++){
			for(int j=0;j<=words[i].length();j++){
				String s=words[i].substring(0, j);
				Integer n = map.get(new StringBuilder(s).reverse().toString());
				if(n!=null&&n!=i&&isPalindrome(words[i].substring(j, words[i].length()))){
					set.add(Arrays.asList(new Integer[] {i,n}));
				}
			}
			for(int j=words[i].length();j>=0;j--){
				String s=words[i].substring(j, words[i].length());
				Integer n = map.get(new StringBuilder(s).reverse().toString());
				if(n!=null&&n!=i&&isPalindrome(words[i].substring(0, j))){
					set.add(Arrays.asList(new Integer[] {n,i}));
				}
			}
		}
		Iterator<List<Integer>> it = set.iterator();
		while(it.hasNext()){
			res.add(it.next());
		}
		return res;
	}
	public List<List<Integer>> palindromePairs2(String[] words) {
		List<List<Integer>> res = new ArrayList<>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i=0;i<words.length;i++){//将s中的字符存在map中，index为value
			map.put(words[i],i);
		}
		for(int i=0;i<words.length;i++){
			String reverse = new StringBuilder(words[i]).reverse().toString();
			Integer rever = map.get(reverse);
			if(rever!=null && rever!=i){
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				list.add(rever);
				res.add(list);
			}else{
				int len = reverse.length();
				for(int j=0;j<words.length;j++){
					if(words[j].length()>len){
						//words[j]的前半部分和reverse相等,并且剩余部分是回文串
						if(words[j].substring(0, len).equals(reverse) && isPalindrome(words[j].substring(len, words[j].length()))){
						//if(isValidLeft(words[j], reverse)){
							List<Integer> list = new ArrayList<Integer>();
							list.add(j);
							list.add(i);
							res.add(list);
						}
						//words[j]的后半部分和reverse相等,并且剩余部分是回文串
						if(words[j].substring(words[j].length()-len, words[j].length()).equals(reverse) && isPalindrome(words[j].substring(0, len))){
						//if(isValidRight(words[j], reverse)){
							List<Integer> list = new ArrayList<Integer>();
							list.add(i);
							list.add(j);
							res.add(list);
						}
					}
				}
			}
		}
		return res;
	}
//	public boolean isValidLeft(String s1,String s2){
//		for(int i=0;i<s1.length();i++){
//			if(i<s2.length()){
//				if(s1.charAt(i)!=s2.charAt(i)) return false;//判断前半段是否和s2相等
//			}else{
//				if(s1.charAt(i)!=s1.charAt(s1.length()-1-i)) return false;//判断后半段是否是回文串
//			}
//		}
//		return true;
//	}
//	public boolean isValidRight(String s1,String s2){
//		for(int i=0;i<s1.length();i++){
//			if(i<(s1.length()-s2.length())){
//				if(s1.charAt(i)!=s1.charAt(s1.length()-s2.length()-1-i)) return false;//判断前半段是否是回文串
//			}else{
//				if(s1.charAt(i)!=s2.charAt(i-(s1.length()-s2.length()))) return false;//判断后半段是否和s2相等
//			}
//		}
//		return true;
//	}
	public List<List<Integer>> palindromePairs1(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
		for(int i=0;i<words.length;i++){
			for(int j=i+1;j<words.length;j++){
				if(isPalindrome(words[i]+words[j])){
					List<Integer> list = new ArrayList<>();
					list.add(i);list.add(j);res.add(list);
				}
				if(isPalindrome(words[j]+words[i])){
					List<Integer> list = new ArrayList<>();
					list.add(j);list.add(i);res.add(list);
				}
			}
		}
		return res;
    }
	public boolean isPalindrome(String s){
		//if(s.length()==1) return true;
		for(int i=0;i<(s.length()/2);i++){
			if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
		}
		return true;
	}
}
