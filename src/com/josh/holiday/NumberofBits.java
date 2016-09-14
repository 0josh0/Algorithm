package com.josh.holiday;

import org.junit.Test;

/*
 * ���⣺����һ��int�������Ķ��������м���1
 * ������1��ʮ����ת�������ƣ�����1�ĸ���
 *     2��������λ��һλ��������λ��һλ�����ƶ����������Ƚ��ƶ�ǰ����ֵ��С�仯�����б仯����λ��Ϊ1������Ϊ0
 *     e.g. ԭ�� 0001101(13) -> �����ƶ�һλ 0000110(6) -> �����ƶ�һλ 0001100(12) -> 13-12!=0 -> ��λ����1
 */
public class NumberofBits {
	@Test
	public void test(){
		int n=13;
		//String s = Integer.toBinaryString(n);
		
		System.out.println(hammingWeight2(n));
		
	}
	//ͨ��λ������
	public int hammingWeight1(int n) {
		int count = 0,left=0,m=0;
		for(int i=0;i<32;i++){
			m=n;
			n = n>>>1;
			left = n<<1;
			if((m-left)==1) count++;
		}
        return count;  
    }
	//ͨ��λ����&(��)��ֻ�е�������Ӧλ�ö���1�ǣ������Ӧλ�ò�Ϊ1������Ϊ0
	public int hammingWeight2(int n) {
		int count = 0;
		while(n!=0){
			count = count + (n & 1);
			n = n>>>1;
		}
        return count;  
    }
	public int hammingWeight(int n) {
		String binaryString  = Integer.toBinaryString(n);
		int count=0;
		for(int i=0;i<binaryString.length();i++){
			if(binaryString.charAt(i)=='1')count++;
		}
        return count;  
    }
}
