package com.josh.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
/**
 * 遍历字符串，找出出现次数多于1次的，长度为10的子字符串
 * 即：寻找长度为10的重复出现的DNA子序列
 *
 *  时间复杂度O(n)
 * 
 * @author Josh
 *
 */
public class DNASquences {
	
	@Test
	public void test(){
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		findRepeatedDnaSequences(s);
	}
	
	public List<String> findRepeatedDnaSequences(String s) {
		
		List<String> res = new ArrayList<String>();//存储出现多于一次的十个长度的字符串
		Set<Integer> set = new HashSet<Integer>();//存储DNA的所有非重复十个长度的字符串
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		//set中已经存储了，存储第二次出现相同的DNA子序列
		Set<Integer> copySet = new HashSet<Integer>();
		
		//DNA序列小于十个
		if(s.length() <= 10){
			System.out.println("未找到满足要求的字符串");
			return res;
		}
		//将四种碱基对映射为0-1-2-3
		map.put('A', 0);
		map.put('G', 1);
		map.put('C', 2);
		map.put('T', 3);
		int DNASquences = 0;//十个长度的DNA序列
		for(int i=0;i<s.length();i++){
			if(i<9){
				//把十个长度的DNA序列存储在20个bit上，每两个bit对应一个碱基对
				DNASquences = (DNASquences << 2) + map.get(s.charAt(i));
			}else{
				DNASquences = (DNASquences << 2) + map.get(s.charAt(i));
				//只取前20位
				DNASquences = DNASquences & ((1 << 20) - 1);
				//set中有，copySet中没有，表示DNA子序列第二次出现，加入list中
				//set中有，copySet中也有，表示DNA子序列第三次出现，不加入list中
				if(set.contains(DNASquences) && !copySet.contains(DNASquences)){
					//出现多于一次，存储在list中
					res.add(s.substring(i-9,i+1));
					copySet.add(DNASquences);
				}else{
					//第一次出现的十个长度DNA序列，放入Set中
					set.add(DNASquences);
				}
			}
		}
		
//		for(int a=0;a<res.size();a++){
//			System.out.println(res.get(a));
//		}
		return res;
    }
}
