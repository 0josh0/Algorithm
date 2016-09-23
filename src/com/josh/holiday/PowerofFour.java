package com.josh.holiday;
/*
 * 题意：判断一个32位整数是否是4的幂
 * 分析：位操作
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
