package com.josh.holiday;
/*
 * 题意:用一个数组表示一个整数的各个位上的数字，求这个数字加1后的结果，各个位数字仍然存在数组中
 * 分析:除法，取余。首先判断最后一位是否是9，不是，直接+1返回，然后依次判断各个位
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
    	if(digits.length==0) return digits;
    	int bit = 1;//保存进位
    	for(int i=digits.length-1;i>=0;i--){
    		if(digits[i]<9){
    			digits[i] = digits[i]+bit;
    			return digits;
    		}else{
    			int digital = (digits[i]+bit)%10;
    			bit = (digits[i]+bit)/10;
    			digits[i] = digital;
    		}
    	}
    	//如果遍历后没有return，说明需要申请一个大一点的数组
    	int[] newDigits = new int[digits.length+1];
    	newDigits[0]=1;
		return newDigits;
        
    }
}
