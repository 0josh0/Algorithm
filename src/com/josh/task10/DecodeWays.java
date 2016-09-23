package com.josh.task10;

import org.junit.Test;

/*
 * 题意: String 1-26分别代表A-Z，给出一个数字String，将其翻译成A-Z有几种做法
 * 		e.g. 12有两种：AB和L
 * 		一次只能翻译一位或者两位，当一位一位解析的时候，首位不能为0，返回0
 * 						         当两位两位解析的时候，00,30,40……无法解析，返回0
 * 											0N的时候，可以解析为x0+N
 * 分析: DP
 * 		如果dp[i-1]dp[i]<=26: dp[i]=dp[i-1]+dp[i-2]
 * 		如果dp[i-1]dp[i]> 26: dp[i]=dp[i-1]
 */
public class DecodeWays {
	@Test
	public void test(){
		String s="301";
		System.out.println(numDecodings(s));
	}
	public int numDecodings(String s) {
		if(s.length()==0 || s.charAt(0)=='0') return 0;
		int[] dp = new int[s.length()];
		if(s.length()==1) return 1;
		int bit1 = s.charAt(0)-'0';
		int bit2 = s.charAt(1)-'0';
		dp[0] = 1;//bit1肯定不是0！！！，因为第一行就做了判断了，所以dp[0]=1，下一步判断dp[1]取值。。。
		if(bit2==0){
			if(bit1>2)return 0;
			dp[1] = 1;
		}else {//bit2不等于0，取值在1-9之间
			if(bit1==1 || (bit1==2 && (bit2>0&&bit2<7))){
				dp[1] = 2;
			}else{
				dp[1] = 1;
			}
		}
		for(int i=2;i<dp.length;i++){
			bit1 = s.charAt(i-1)-'0';
			bit2 = s.charAt(i)-'0';
			//判断bit1和bit2可能取0的情况
			//情况1：两个都为0，return 0
			//情况2：第一个为0，第二个不为0，dp[i]=dp[i-1]
			//情况3：第一个不为0，第二个为0，【1】第一个1或者2：dp[i]=dp[i-2]
			//                        【1】第一个大于2：dp[i]=dp[i-1] 注意：当前的第二位不是最后一位，如果是最后一位，return 0；
			//情况4：都不为0，在1-26之间，dp[i]=dp[i-1]+dp[i-2]
			//			     不在1-26之间，dp[i]=dp[i-1]
			if(bit1==0&&bit2==0){
				return 0;
			}else if(bit1==0&&bit2!=0){
				dp[i]=dp[i-1];
			}else if(bit1!=0&&bit2==0){
				if(bit1==1||bit1==2){
					dp[i]=dp[i-2];
				}else if(bit1>2){//注意：当前的第二位不是最后一位，如果是最后一位，return 0；
					return 0;
					//dp[i]=dp[i-1];
				}
			}else{
				if(bit1==1 || (bit1==2&&bit2<7)){
					dp[i]=dp[i-1]+dp[i-2];
				}else{
					dp[i]=dp[i-1];
				}
			}
		}
		return dp[dp.length-1];
    }
}
