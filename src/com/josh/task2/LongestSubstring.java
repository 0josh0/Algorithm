package com.josh.task2;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * �ҳ�һ���ַ�����û���ظ��ַ�����Ӵ�
 * �����䳤��
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
		//���ַ���ת��Ϊchar����
    	char[] sChar = s.toCharArray();
    	//��set���ϴ洢�ַ���s��ÿ���ַ�����Ϊset���Ͼ��в��洢�ظ�Ԫ�ص�����
    	Set<Character> set = new HashSet<Character>();
    	int maxLength = 0;//��¼�Ӵ���󳤶�
    	if(sChar.length == 0){
    		System.out.println("��Ӵ����ȣ�"+0);
    		return 0;
    	}
    	//����ظ��ַ��Ƿ����
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
    	System.out.println("��Ӵ����ȣ�"+maxLength);
    	return maxLength;
        
    }
}
