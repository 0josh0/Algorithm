package com.josh.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
/**
 * �����ַ������ҳ����ִ�������1�εģ�����Ϊ10�����ַ���
 * ����Ѱ�ҳ���Ϊ10���ظ����ֵ�DNA������
 *
 *  ʱ�临�Ӷ�O(n)
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
		
		List<String> res = new ArrayList<String>();//�洢���ֶ���һ�ε�ʮ�����ȵ��ַ���
		Set<Integer> set = new HashSet<Integer>();//�洢DNA�����з��ظ�ʮ�����ȵ��ַ���
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		//set���Ѿ��洢�ˣ��洢�ڶ��γ�����ͬ��DNA������
		Set<Integer> copySet = new HashSet<Integer>();
		
		//DNA����С��ʮ��
		if(s.length() <= 10){
			System.out.println("δ�ҵ�����Ҫ����ַ���");
			return res;
		}
		//�����ּ����ӳ��Ϊ0-1-2-3
		map.put('A', 0);
		map.put('G', 1);
		map.put('C', 2);
		map.put('T', 3);
		int DNASquences = 0;//ʮ�����ȵ�DNA����
		for(int i=0;i<s.length();i++){
			if(i<9){
				//��ʮ�����ȵ�DNA���д洢��20��bit�ϣ�ÿ����bit��Ӧһ�������
				DNASquences = (DNASquences << 2) + map.get(s.charAt(i));
			}else{
				DNASquences = (DNASquences << 2) + map.get(s.charAt(i));
				//ֻȡǰ20λ
				DNASquences = DNASquences & ((1 << 20) - 1);
				//set���У�copySet��û�У���ʾDNA�����еڶ��γ��֣�����list��
				//set���У�copySet��Ҳ�У���ʾDNA�����е����γ��֣�������list��
				if(set.contains(DNASquences) && !copySet.contains(DNASquences)){
					//���ֶ���һ�Σ��洢��list��
					res.add(s.substring(i-9,i+1));
					copySet.add(DNASquences);
				}else{
					//��һ�γ��ֵ�ʮ������DNA���У�����Set��
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
