package com.josh.holiday;
/*
 * ���⣺�ж�һ��32λ�����Ƿ���4����
 * ������λ����
 */
public class PowerofFour {
    public boolean isPowerOfFour(int num) {
    	if(num==1) return true;
        if(num<4) return false;
        int n=1;
    	for(int i=0;i<16;i++){
    		n=n<<2;
    		if(n==num) return true;
    	}
    	return false;
    }
}
