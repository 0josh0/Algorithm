package com.josh.holiday;

import org.junit.Test;

/*
 * ����: ��תһ�������Ķ�����bit����01.
 * ����: 1 ���32λ���ļ�λ��1��Ȼ��2��32-i������� -- Խ�磡��
 *      2 ����λ�����㣬n&1�жϵ�ǰλ�Ƿ���1�����ǣ�res|1����Res��Ӧλ����Ϊ1��Ȼ��n��res��>>����1λ
 */
public class ReverseBits {
	@Test
	public void test(){
		System.out.println(reverseBits(1));
	}
	public int reverseBits(int n) {
		int res=0;
		for(int i=0;i<31;i++){
			if((n&1)==1) res = res|1;
			n=n>>1;
			res=res<<1;
		}
		if((n&1)==1) res = res|1;
        return res;
    }
}
