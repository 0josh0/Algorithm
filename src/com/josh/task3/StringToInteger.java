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
				if(isNum(str.charAt(i))){//如果开始出现数字.肯定是整数
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
				if(isSymbol(str.charAt(i))){//如果开始出现的事是符号- +
					if((i+1) == str.length() || !isNum(str.charAt(i+1))){//符号后面不是数字
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
	//判断是否是数字
	public boolean isNum(char c){
		if(c>='0' && c<='9'){
			return true;
		}else{
			return false;
		}
	}
	//判断是否是正负号
	public boolean isSymbol(char c){
		if(c == '-' || c == '+'){
			return true;
		}else{
			return false;
		}
	}
}
