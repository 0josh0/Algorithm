package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺�ж�һ�������ַ����Ƿ��ǿɼӵģ���112358���֣�ǰ���������ۼӵú������������Ȼ��ڶ����͵�������ӵõ��ĸ�һֱ�����
 * ������ö��ǰ��������һ��������
 */
public class AdditiveNumber {
	@Test
	public void test(){
		String num = "0235813";
		System.out.println(isAdditiveNumber(num));
	}
    public boolean isAdditiveNumber(String num) {
    	if(num.length()<3) return false;
    	for(int i=1;i<num.length();i++){
    		for(int j=i+1;j<num.length();j++){
    			Long a1 = Long.valueOf(num.substring(0,i));
    			Long a2 = Long.valueOf(num.substring(i,j));
    			Long sum = a1+a2;
    			int sumLen = (sum+"").length();//�ж�02����Ƿ�Ϸ�
    			if((a1+"").length()!=num.substring(0,i).length()||(a2+"").length()!=num.substring(i,j).length()||sumLen>num.length()-j) break;
    			int k=j;
    			while(k<num.length()&&(num.length()-k)>=sumLen&&sum.equals(Long.valueOf(num.substring(k,k+sumLen)))){
    				a1=a2;//�ۼ�����
    				a2=sum;
    				sum=a1+a2;
    				k=k+sumLen;
    				sumLen=(sum+"").length();
    			}
    			if(k==num.length()) return true;
    		}
    	}
        return false;
    }
}
