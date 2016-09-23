package com.josh.task3;

import org.junit.Test;

public class StringToInteger {
	@Test
	public void test(){
		String str = "-9223372036854775809";
		int i = myAtoi(str);
		System.out.println(i);
	}
	public int myAtoi(String str) {
		int i=0;
		String strNum = "";
		while(i<str.length()){
			if(str.charAt(i) == ' ' || str.charAt(i) == '0'){
				i++;
			}else if(isNum(str.charAt(i)) || isSymbol(str.charAt(i))){
				if(isNum(str.charAt(i))){//�����ʼ��������.�϶�������
					int j=i;
					while(j<str.length() && isNum(str.charAt(j))){
						strNum = str.substring(i,j+1);
						if(strNum.length() > (Integer.MAX_VALUE+"  ").length()){
							return Integer.MAX_VALUE;
						}
						j++;
					}
					if(Long.parseLong(strNum)>=Integer.MAX_VALUE){
						return Integer.MAX_VALUE;
					}else{
						return Integer.parseInt(strNum);
					}
				}
				if(isSymbol(str.charAt(i))){//�����ʼ���ֵ����Ƿ���- +
					if((i+1) == str.length() || !isNum(str.charAt(i+1))){//���ź��治������
						return 0;
					}else{
						int j=i+1;
						while(j<str.length() && isNum(str.charAt(j))){
							strNum = str.substring(i,j+1);
							if(strNum.length() > (Integer.MAX_VALUE+"  ").length()){
								if(str.charAt(i) == '-'){
									return Integer.MIN_VALUE;
								}else{
									return Integer.MAX_VALUE;
								}
							}
							j++;
						}
						if(Long.parseLong(strNum)>=Integer.MAX_VALUE || Long.parseLong(strNum) <= Integer.MIN_VALUE){
							if(str.charAt(i) == '-'){
								return Integer.MIN_VALUE;
							}else{
								return Integer.MAX_VALUE;
							}
						}else{
							return Integer.parseInt(strNum);
						}
					}
				}
			}else if(!isNum(str.charAt(i))){
				return 0;
			}
		}
		return 0;
        
    }
	//�ж��Ƿ�������
	public boolean isNum(char c){
		if(c>='0' && c<='9'){
			return true;
		}else{
			return false;
		}
	}
	//�ж��Ƿ���������
	public boolean isSymbol(char c){
		if(c == '-' || c == '+'){
			return true;
		}else{
			return false;
		}
	}
}
