package com.josh.holiday;
/*
 * ����: ����һ��String���飬������û���ظ��ַ��Ĵ��ĳ��ȵ����˻�
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn"
 * 
 * ����: ��int�ĺ�26λ��¼һ�������ֵ���ĸ���������λ����1����������0.��һ��int�����¼String������ÿ�����г�����ĸ�����
 * 		���ͨ����&�����ж��������Ƿ�����ͬ��ĸ
 */
public class MaximumProductofWordLengths {
	public int maxProduct(String[] words) {
        int[] apl = new int[words.length];
        for(int i=0;i<words.length;i++){
        	apl[i]=0;//ͳ��ÿ��string�г��ֵ���ĸ���
        	for(int j=0;j<words[i].length();j++){
        		apl[i] = apl[i] | (1<<(words[i].charAt(j)-'a'));
        	}
        }
        //����󳤶�
        int maxLen=0;
        for(int i=0;i<apl.length;i++){
        	for(int j=i+1;j<apl.length;j++){
        		if((apl[i]&apl[j])==0){//��ʾ����λ�ϵ���ĸ����ͬ����û���ظ����ֵ���ĸ
        			maxLen = Math.max(maxLen, words[i].length()*words[j].length());
        		}
        	}
        }
        return maxLen;
    }
}
