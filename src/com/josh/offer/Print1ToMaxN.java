package com.josh.offer;

import org.junit.Test;

/*
 * 打印从1到最大n位数
 * 用String模拟大树加法
 * 
 */
public class Print1ToMaxN {

	@Test
	public void test(){
		solu(2);
		//测试自定义加1函数
//		StringBuilder num = new StringBuilder();
//		num.append("0");
//		System.out.println(num);
//		for(int i=1;i<50;i++){
//			num = addOne(num);
//			System.out.println(num);
//		}
	}
	public void solu(int n){
		//char[] numbers = new char[n];
		StringBuilder maxNum = new StringBuilder();
		for(int i=0;i<n;i++){
			maxNum.append("9");
		}
		StringBuilder num = new StringBuilder();
		num.append("0");
		System.out.println(num);
		while(!num.toString().equals(maxNum.toString())){
			num=addOne(num);
			System.out.println(num);
		}
		//System.out.println(maxNum);
	}
	//自定义加1函数
	public static StringBuilder addOne(StringBuilder s){
		int i=s.length()-1;
		while(i>=0){
			int num = Integer.valueOf(String.valueOf(s.charAt(i)));
			if(num==9){
				s.replace(i, i+1,"0");
			}else if(num<9){//如果最后一位小于9，直接在原位上加1
				num++;
				s.replace(i, i+1,String.valueOf((num)));
				break;
			}
			i--;
		}
		if(s.charAt(0)=='0'){
			s.insert(0, '1');
		}
		return s;
	}
}
