package com.josh.holiday;
/*
 * ���⣺�Ӹ���������Χ������������AND&�ĺ�
 * ������&����-ֻҪ��һ������λ����0����Ϊ0.
 * 		�������֣����������λ�ϵ����ֵ��ڣ�����������λ����ͬ������(0/1)����ͬ��λȫ��Ϊ0��
 * 		���ԣ�λ�������Ƚ�m��n����(���ֵ����Сֵ)����λ�Ƚϣ���ȼ������Ƚϣ�ֱ������ȣ�ȡ��Ȳ��֣����治�Ȳ���ȫ��Ϊ0
 */
public class BitwiseANDofNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
        int bitCount=0;
        while(m!=n){
        	m=m>>1;
        	n=n>>1;
        	bitCount++;
        }
        return m<<bitCount;
    }
}
