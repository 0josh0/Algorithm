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
 * ���⣺�ҳ����е��������һ���ܹ��ɻ��� �ַ����ĵĵ����±�
 * ������1����֪���������ⷨһ����ʱ����������
 * 	    2�����ֵ��е����е���ȫ�����map�У�Ȼ�����s[]��ÿ�α�����һ��s[i]ʱ����s[i]��ת�õ�reverse
 * 		      Ȼ�󣬿�reverse�Ƿ���map�У����ڣ�ֱ�Ӽ���list�������ڣ��ٴα���s[],�����б�s[i]�����ַ��Ƚ�
 * 		      ��ȡs[]��ǰ��Σ�����s[i]��Ȳ���s[]�����ಿ���ǻ������������ܹ��ɻ��Ĵ���Ȼ���ٽ�ȡ���ν���ͬ���Ƚ�
 * 		      -----��ʱ��
 * 		      û�г���õ�map�����ʣ�ʱ�临�Ӷ�O(n2*K)
 *      3�����ֵ��е����е���ȫ������map�У�Ȼ�����s[],��ÿ��s[i]�ַ���,�����ұ�������ȡ����ת��
 *        ����ȡ��ת������map�У�����s[i]��ȡʣ�ಿ���ǻ��Ĵ������������ַ����ܹ��ɻ��Ĵ����ڶ�s[i]�����������ͬ������
 *        ע�⣺�������ظ��ģ�������һ��setȥ�ء� ʱ�临�Ӷ�O(n*k)
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
		for(int i=0;i<words.length;i++){//��s�е��ַ�����map�У�indexΪvalue
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
		for(int i=0;i<words.length;i++){//��s�е��ַ�����map�У�indexΪvalue
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
						//words[j]��ǰ�벿�ֺ�reverse���,����ʣ�ಿ���ǻ��Ĵ�
						if(words[j].substring(0, len).equals(reverse) && isPalindrome(words[j].substring(len, words[j].length()))){
						//if(isValidLeft(words[j], reverse)){
							List<Integer> list = new ArrayList<Integer>();
							list.add(j);
							list.add(i);
							res.add(list);
						}
						//words[j]�ĺ�벿�ֺ�reverse���,����ʣ�ಿ���ǻ��Ĵ�
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
//				if(s1.charAt(i)!=s2.charAt(i)) return false;//�ж�ǰ����Ƿ��s2���
//			}else{
//				if(s1.charAt(i)!=s1.charAt(s1.length()-1-i)) return false;//�жϺ����Ƿ��ǻ��Ĵ�
//			}
//		}
//		return true;
//	}
//	public boolean isValidRight(String s1,String s2){
//		for(int i=0;i<s1.length();i++){
//			if(i<(s1.length()-s2.length())){
//				if(s1.charAt(i)!=s1.charAt(s1.length()-s2.length()-1-i)) return false;//�ж�ǰ����Ƿ��ǻ��Ĵ�
//			}else{
//				if(s1.charAt(i)!=s2.charAt(i-(s1.length()-s2.length()))) return false;//�жϺ����Ƿ��s2���
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
