package com.josh.holiday;
/*
 * ����:��һ�������ʾһ�������ĸ���λ�ϵ����֣���������ּ�1��Ľ��������λ������Ȼ����������
 * ����:������ȡ�ࡣ�����ж����һλ�Ƿ���9�����ǣ�ֱ��+1���أ�Ȼ�������жϸ���λ
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
    	if(digits.length==0) return digits;
    	int bit = 1;//�����λ
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
    	//���������û��return��˵����Ҫ����һ����һ�������
    	int[] newDigits = new int[digits.length+1];
    	newDigits[0]=1;
		return newDigits;
        
    }
}
