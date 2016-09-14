package com.josh.task9;

import org.junit.Test;

/*
 * 题意: 求两个任意大整数的乘积。两个数分别以字符串形式给出，最后返回结果也是字符串
 * 分析: 1 将String的每一位提取出来，单独计算，然后在累加 -- 哥！超时了！！！
 *      2 
 */
public class MultiplyStrings {
	@Test
	public void test(){
		System.out.println(multiply1("9369162965141127216164882458728854782080715827760307787224298083754"
,"7204554941577564438"));
	}
	public String multiply(String num1, String num2) {
		if(num1=="0"||num2=="0") return "0";
		int[] a1 = new int[num1.length()];
		int[] a2 = new int[num2.length()];
		for(int i=0;i<num1.length();i++){
			a1[i] = Integer.valueOf(num1.substring(i,i+1));
		}
		for(int i=0;i<num2.length();i++){
			a2[i] = Integer.valueOf(num2.substring(i,i+1));
		}
		
		return "";
	}
	public String multiply1(String num1, String num2) {
		if(num1=="0"||num2=="0") return "0";
		String res = "0";
		for(int i=num1.length()-1;i>=0;i--){
			String sum = "";
			int b=0;
			for(int j=num2.length()-1;j>=0;j--){
				int num = Integer.valueOf(num1.substring(i,i+1))*Integer.valueOf(num2.substring(j,j+1));
				num=num+b;
				if(num<10){
					sum = String.valueOf(num)+sum;
	    			b=0;
				}else{
					b=num/10;
					num=num-10*b;
					sum = String.valueOf(num)+sum;
				}
			}
			if(b>0) sum = String.valueOf(b)+sum;
			for(int k=0;k<num1.length()-i-1;k++){
				sum=sum+"0";
			}
			res = add(res,sum);
		}
		return res;
	}
    public String add(String num1, String num2) {
    	int b=0,i=num1.length()-1,j=num2.length()-1;
    	String sum = "";
    	for(;i>=0&&j>=0;i--,j--){
    		int num = Integer.valueOf(num1.substring(i,i+1))+Integer.valueOf(num2.substring(j,j+1));
    		num = num+b;//加上进位数
    		if(num<10){
    			sum = String.valueOf(num)+sum;
    			b=0;
    		}else{
    			num=num-10;
    			b=1;
    			sum = String.valueOf(num)+sum;
    		}
    	}
    	if(b==0){
    		if(i>=0) sum = num1.substring(0,i+1)+sum;
        	if(j>=0) sum = num2.substring(0,j+1)+sum;
    	}else{
    		if(i>=0){
    			//int a = Integer.valueOf(num1.substring(0,i+1))+b;
    			sum = String.valueOf(Integer.valueOf(num1.substring(0,i+1))+b)+sum;
    		}else if(j>=0){
        		//int a = Integer.valueOf(num2.substring(0,j+1))+b;
        		sum = String.valueOf(Integer.valueOf(num2.substring(0,j+1))+b)+sum;
        	}else{
        		sum = "1"+sum;
        	}
    	}
        return sum;
    }
}
