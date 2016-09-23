package com.josh.task10;

import org.junit.Test;

/*
 * ����: String 1-26�ֱ����A-Z������һ������String�����䷭���A-Z�м�������
 * 		e.g. 12�����֣�AB��L
 * 		һ��ֻ�ܷ���һλ������λ����һλһλ������ʱ����λ����Ϊ0������0
 * 						         ����λ��λ������ʱ��00,30,40�����޷�����������0
 * 											0N��ʱ�򣬿��Խ���Ϊx0+N
 * ����: DP
 * 		���dp[i-1]dp[i]<=26: dp[i]=dp[i-1]+dp[i-2]
 * 		���dp[i-1]dp[i]> 26: dp[i]=dp[i-1]
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
		dp[0] = 1;//bit1�϶�����0����������Ϊ��һ�о������ж��ˣ�����dp[0]=1����һ���ж�dp[1]ȡֵ������
		if(bit2==0){
			if(bit1>2)return 0;
			dp[1] = 1;
		}else {//bit2������0��ȡֵ��1-9֮��
			if(bit1==1 || (bit1==2 && (bit2>0&&bit2<7))){
				dp[1] = 2;
			}else{
				dp[1] = 1;
			}
		}
		for(int i=2;i<dp.length;i++){
			bit1 = s.charAt(i-1)-'0';
			bit2 = s.charAt(i)-'0';
			//�ж�bit1��bit2����ȡ0�����
			//���1��������Ϊ0��return 0
			//���2����һ��Ϊ0���ڶ�����Ϊ0��dp[i]=dp[i-1]
			//���3����һ����Ϊ0���ڶ���Ϊ0����1����һ��1����2��dp[i]=dp[i-2]
			//                        ��1����һ������2��dp[i]=dp[i-1] ע�⣺��ǰ�ĵڶ�λ�������һλ����������һλ��return 0��
			//���4������Ϊ0����1-26֮�䣬dp[i]=dp[i-1]+dp[i-2]
			//			     ����1-26֮�䣬dp[i]=dp[i-1]
			if(bit1==0&&bit2==0){
				return 0;
			}else if(bit1==0&&bit2!=0){
				dp[i]=dp[i-1];
			}else if(bit1!=0&&bit2==0){
				if(bit1==1||bit1==2){
					dp[i]=dp[i-2];
				}else if(bit1>2){//ע�⣺��ǰ�ĵڶ�λ�������һλ����������һλ��return 0��
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
