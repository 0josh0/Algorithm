package com.josh.holiday;

import org.junit.Test;

/*
 * 题意: Integer转化为罗马数字
 * 分析: 
 */
public class IntegertoRoman {
	@Test
	public void test(){
		int num = 3999;
		System.out.println(intToRoman(num));
	}
	public String intToRoman(int num) {
        StringBuilder thousand = new StringBuilder();
        int th = num/1000;//千位数，M的个数
        for(int i=0;i<th;i++){
        	thousand.append("M");
        }
        num = num-th*1000;//更新num的值
        
        StringBuilder hundred = new StringBuilder();
        int fHu = num/500;
        int hu = num/100;
        if(fHu==1){
        	if(hu==9)hundred.append("CM");//百位数900
        	else{//百位数500-800
        		hundred.append("D");
        		for(int i=0;i<hu-5;i++){
        			hundred.append("C");
        		}
        	}
        }else{//百位数0-400
        	if(hu==4) hundred.append("CD");
        	else{
        		for(int i=0;i<hu;i++){
        			hundred.append("C");
        		}
        	}
        }
        num = num - hu*100;//更新num值
        
        StringBuilder ten = new StringBuilder();
        int fTe = num/50;
        int te = num/10;
        if(fTe==1){//50-90
        	if(te==9)ten.append("XC");//十位数90
        	else{//十位数50-80
        		ten.append("L");
        		for(int i=0;i<te-5;i++){
        			ten.append("X");
        		}
        	}
        }else{//十位数0-4
        	if(te==4) ten.append("XL");
        	else{
        		for(int i=0;i<te;i++){
        			ten.append("X");
        		}
        	}
        }
        num = num - te*10;//更新num值
        
        StringBuilder one = new StringBuilder();
        int five = num/5;
        if(five==1){
        	if(num==9) one.append("IX");
        	else{
        		one.append("V");
        		for(int i=0;i<num-5;i++){
        			one.append("I");
        		}
        	}
        }else{
        	if(num==4) one.append("IV");
        	else{
        		for(int i=0;i<num;i++){
        			one.append("I");
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        return sb.append(thousand.append(hundred.append(ten.append(one)))).toString();
    }
}
